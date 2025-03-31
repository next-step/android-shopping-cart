@file:OptIn(ExperimentalMaterial3Api::class)

package nextstep.shoppingcart.ui.product_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.model.CartItemEntity
import nextstep.shoppingcart.data.repository.CartRepository
import nextstep.shoppingcart.data.repository.ProductRepository
import nextstep.shoppingcart.ui.designsystem.InitialCircularLoading
import nextstep.shoppingcart.ui.designsystem.ProductListItem
import nextstep.shoppingcart.ui.mapper.toEntity
import nextstep.shoppingcart.ui.mapper.toUi
import nextstep.shoppingcart.ui.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListScreenRoot(
    onBasketClick: () -> Unit,
    onProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
    productRepository: ProductRepository = ProductRepository.getInstance(),
    cartRepository: CartRepository = CartRepository.getInstance(),
) {
    var state by rememberSaveable {
        mutableStateOf(ProductListState())
    }

    // 장바구니 State
    val cartItems = cartRepository.items
        .onEach { cartItems ->
            val products = state.products as HashMap

            for (category in products.keys) {
                val items = mutableListOf<Product>()

                for (item in products[category]!!) {
                    val cartQuantity = cartItems[item.id]?.quantity ?: 0
                    items.add(item.copy(cartQuantity = cartQuantity))
                }
                products[category] = items
            }
            state = state.copy(
                products = products
            )
        }
        .collectAsStateWithLifecycle(emptyMap())

    // 초기 데이터 로딩
    LaunchedEffect(Unit) {
        // 초기에만 로딩되도록 조건문 추가
        // Navigation에 의해 Composition이 파괴되고 다시 생성될 때, 다시 목록을 불러오지 않도록 방지
        if (state.isInitialLoading) {
            productRepository.fetchCategory()
            state = state.copy(
                isInitialLoading = false,
            )
        }
    }

    // B마트처럼 탭이 전환되면 상품 목록 갱신하도록 하기
    LaunchedEffect(state.selectedTabIndex) {
        if (state.selectedTabIndex == ProductListState.TAB_NOT_SELECTED) {
            return@LaunchedEffect
        }
        val category = state.categories.getOrNull(state.selectedTabIndex) ?: return@LaunchedEffect

        // 로딩 설정
        state = state.copy(
            isLoading = true,
        )

        // 상품 목록
        val products = productRepository.getProduct(category).map { it.toUi() }

        val productsWithQuantity = mutableListOf<Product>()

        for (item in products) {
            val cartQuantity = cartItems.value[item.id]?.quantity ?: 0
            productsWithQuantity.add(item.copy(cartQuantity = cartQuantity))
        }

        state = state.copy(
            isLoading = false,
            isLoadingShow = false,
            products = (state.products as HashMap).also {
                it[category] = productsWithQuantity
            },
        )
    }

    LaunchedEffect(Unit) {
        // 카테고리 목록 불러오기
        launch {
            productRepository.categories.collect { categories ->
                if (categories.isNotEmpty()) {
                    state = state.copy(
                        categories = categories,
                        selectedTabIndex = if (state.selectedTabIndex == ProductListState.TAB_NOT_SELECTED) 0 else state.selectedTabIndex,
                    )
                }
            }
        }

        // 장바구니에 담긴 총 수량 불러오기
        launch {
            cartRepository.cartTotalQuantity.collect {
                state = state.copy(
                    selectedItemCount = it
                )
            }
        }
    }

    // 초기 로딩 시간이 0.5초 보다 오래 걸리는 경우에만 로딩바 보여주기
    LaunchedEffect(state.isLoading) {
        if (state.isInitialLoading) {
            delay(500L)
            if (state.isInitialLoading) {
                state = state.copy(
                    isLoadingShow = true,
                )
            }
        } else if (state.isLoading) {
            delay(500L)
            if (state.isLoading) {
                state = state.copy(
                    isLoadingShow = true,
                )
            }
        }
    }

    if (state.isInitialLoading || state.selectedTabIndex == ProductListState.TAB_NOT_SELECTED) {
        if (state.isLoadingShow) {
            InitialCircularLoading()
        }
        return
    }
    ProductListScreen(
        state = state,
        onBasketClick = onBasketClick,
        onProductClick = onProductClick,
        onIncreaseQuantityClick = {
            cartRepository.update(
                CartItemEntity(
                    product = it.copy(cartQuantity = it.cartQuantity + 1).toEntity(),
                    quantity = it.cartQuantity + 1,
                )
            )
        },
        onDecreaseQuantityClick = {
            cartRepository.update(
                CartItemEntity(
                    product = it.copy(cartQuantity = it.cartQuantity - 1).toEntity(),
                    quantity = it.cartQuantity - 1,
                )
            )
        },
        onCategoryTabClick = {
            state = state.copy(
                selectedTabIndex = it
            )
        },
        modifier = modifier,
    )
    if (state.isLoading && state.isLoadingShow) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
private fun ProductListScreen(
    state: ProductListState,
    onBasketClick: () -> Unit,
    onProductClick: (Product) -> Unit,
    onIncreaseQuantityClick: (Product) -> Unit,
    onDecreaseQuantityClick: (Product) -> Unit,
    onCategoryTabClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()

    val tabScrollStates = rememberSaveable(state.categories) {
        state.categories.indices.associateWith { LazyGridState() }
    }
    val pagerState = rememberPagerState {
        state.categories.size
    }
    val lazyState = tabScrollStates[state.selectedTabIndex] ?: rememberLazyGridState()
    val showScrollToTopButton by remember(lazyState) {
        derivedStateOf {
            lazyState.firstVisibleItemIndex >= 5
        }
    }

    Scaffold(
        topBar = {
            ProductListTopBar(
                addedItemCount = state.selectedItemCount,
                onBasketClick = onBasketClick,
            )
        },
        floatingActionButton = {
            AnimatedVisibility(
                visible = showScrollToTopButton,
                enter = fadeIn(),
                exit = fadeOut(),
            ) {
                FloatingActionButton(
                    modifier = Modifier
                        .padding(bottom = 16.dp, end = 16.dp),
                    onClick = {
                        scope.launch {
                            lazyState.animateScrollToItem(0)
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = null,
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(modifier = modifier.padding(paddingValues)) {
            SecondaryScrollableTabRow(
                selectedTabIndex = state.selectedTabIndex,
                containerColor = Color.White,
                edgePadding = 0.dp,
                contentColor = Color.Black,
            ) {
                state.categories.forEachIndexed { index, title ->
                    Tab(
                        selected = state.selectedTabIndex == index,
                        onClick = {
                            pagerState.requestScrollToPage(index) // Q. 이 코드는 문제가 없을까?
                            onCategoryTabClick(index)
                        },
                        text = {
                            Text(
                                text = title,
                                maxLines = 1,
                            )
                        }
                    )
                }
            }
            HorizontalPager(
                modifier = Modifier.fillMaxSize(),
                state = pagerState,
            ) { page ->

                LazyVerticalGrid(
                    state = tabScrollStates[state.selectedTabIndex] ?: rememberLazyGridState(),
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .padding(horizontal = 18.dp, vertical = 13.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(bottom = 100.dp)
                ) {
                    items(
                        state.products.getOrDefault(
                            state.categories[page],
                            emptyList()
                        )
                    ) { product ->
                        ProductListItem(
                            product = product,
                            onIncreaseQuantityClick = onIncreaseQuantityClick,
                            onDecreaseQuantityClick = onDecreaseQuantityClick,
                            modifier = Modifier.clickable(
                                onClick = {
                                    onProductClick(product)
                                }
                            ),
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ProductListTopBar(
    addedItemCount: Int,
    onBasketClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.product_list_screen_title),
                style = MaterialTheme.typography.titleLarge,
            )
        },
        actions = {
            BadgedBox(
                badge = {
                    if (addedItemCount > 0) {
                        Badge(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        ) {
                            Text("$addedItemCount")
                        }
                    }
                },
                modifier = Modifier
                    .padding(end = 4.dp)
                    .clickable(
                        onClick = onBasketClick
                    ),
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = stringResource(R.string.product_list_description_shopping_cart),
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors().copy(
            containerColor = Color.White,
        )
    )
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(
            state = ProductListState(
                categories = listOf(
                    "PET",
                    "BBBBBBBBBBBBBB",
                    "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"
                ),
                selectedTabIndex = 0,
                products = mapOf(
                    "PET" to listOf(
                        Product(
                            id = "1",
                            imageUrl = "",
                            name = "PET-보틀-정사각형 정사각형 정사각형 ",
                            price = 10_000,
                            cartQuantity = 0,
                            category = "PET",
                        ),
                        Product(
                            id = "2",
                            imageUrl = "",
                            name = "PET-보틀-세모",
                            price = 10_000_000,
                            cartQuantity = 10,
                            category = "PET",
                        ),
                        Product(
                            id = "3",
                            imageUrl = "",
                            name = "PET-보틀-정사각형 정사각형 정사각형 ",
                            price = 1_000_000_000,
                            cartQuantity = 10,
                            category = "PET",
                        ),
                        Product(
                            id = "4",
                            imageUrl = "",
                            name = "PET-보틀-정사각형 정사각형 정사각형 ",
                            price = 10_000,
                            cartQuantity = 0,
                            category = "PET",
                        ),
                        Product(
                            id = "5",
                            imageUrl = "",
                            name = "PET-보틀-정사각형 정사각형 정사각형 ",
                            price = 10_000,
                            cartQuantity = 0,
                            category = "PET",
                        ),
                    )
                )
            ),
            onProductClick = {},
            onBasketClick = {},
            onIncreaseQuantityClick = {},
            onDecreaseQuantityClick = {},
            onCategoryTabClick = {},
        )
    }
}
