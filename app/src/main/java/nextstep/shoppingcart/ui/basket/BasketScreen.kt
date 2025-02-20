@file:OptIn(ExperimentalMaterial3Api::class)

package nextstep.shoppingcart.ui.basket

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.onStart
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.repository.CartRepository
import nextstep.shoppingcart.ui.designsystem.CartListItem
import nextstep.shoppingcart.ui.designsystem.InitialCircularLoading
import nextstep.shoppingcart.ui.mapper.toEntity
import nextstep.shoppingcart.ui.mapper.toUi
import nextstep.shoppingcart.ui.model.CartItem
import nextstep.shoppingcart.ui.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun BasketScreenRoot(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    cartRepository: CartRepository = CartRepository.getInstance(),
) {
    var state by rememberSaveable {
        mutableStateOf(BasketState())
    }

    // 초기 로딩 시간이 0.5초 보다 오래 걸리는 경우에만 로딩바 보여주기
    LaunchedEffect(state.isInitialLoading) {
        if (state.isInitialLoading) {
            delay(500L)
            state = state.copy(
                isLoadingShow = true,
            )
        }
    }

    // Q. 화면이 파괴되면 Composable도 recomposition에서 제외되므로, Fragment에서 처럼 repeatOnLifecycle 등으로 Lifecycle을 지정하지 않아도 되나요?
    LaunchedEffect(Unit) {
        cartRepository.getItems()
            .onStart {
                state = state.copy(
                    isInitialLoading = false,
                )
            }
            .distinctUntilChanged()
            .collect { items ->
                state = state.copy(cartItems = items.map { it.toUi() })
            }
    }

    if (state.isInitialLoading) {
        if (state.isLoadingShow) {
            InitialCircularLoading()
        }
        return
    }
    BasketScreen(
        state = state,
        navigateBack = navigateBack,
        onRemoveCartItemClick = { cartRepository.removeAll(it.product.toEntity()) },
        onIncreaseQuantityClick = { cartRepository.addOne(it.product.toEntity()) },
        onDecreaseQuantityClick = { cartRepository.removeOne(it.product.toEntity()) },
        modifier = modifier,
    )
}

@Composable
internal fun BasketScreen(
    state: BasketState,
    navigateBack: () -> Unit,
    onRemoveCartItemClick: (CartItem) -> Unit,
    onIncreaseQuantityClick: (CartItem) -> Unit,
    onDecreaseQuantityClick: (CartItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            BasketTopBar(navigateBack)
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(state.cartItems, key = { it.product.id }) {
                    CartListItem(
                        cartItem = it,
                        onRemoveCartItemClick = onRemoveCartItemClick,
                        onIncreaseQuantityClick = onIncreaseQuantityClick,
                        onDecreaseQuantityClick = onDecreaseQuantityClick,
                        modifier = Modifier.padding(horizontal = 18.dp),
                    )
                }
            }

            Button(
                modifier = Modifier
                    .testTag("orderButton")
                    .fillMaxWidth(),
                onClick = {
                    // 주문하기는 미구현.
                },
                shape = RectangleShape,
            ) {
                Text(
                    text = stringResource(R.string.basket_order, state.totalPrice),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 4.dp),
                )
            }
        }
    }
}

@Composable
private fun BasketTopBar(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(stringResource(R.string.basket))
        },
        navigationIcon = {
            IconButton(
                onClick = navigateBack,
                modifier = Modifier.padding(horizontal = 8.dp),
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.navigation_back),
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
private fun BasketScreenPreview() {
    ShoppingCartTheme {
        BasketScreen(
            state = BasketState(
                cartItems = listOf(
                    CartItem(
                        product = Product(
                            id = "Ilene",
                            imageUrl = "Linden",
                            name = "Ignacio",
                            price = 8650
                        ),
                        count = 9757,
                    ),
                    CartItem(
                        product = Product(
                            id = "Stacy",
                            imageUrl = "Rhyan",
                            name = "Lester",
                            price = 3533
                        ),
                        count = 3012,
                    ),
                    CartItem(
                        product = Product(
                            id = "A",
                            imageUrl = "Rhyan",
                            name = "Lester",
                            price = 3533
                        ),
                        count = 3012,
                    ),
                    CartItem(
                        product = Product(
                            id = "B",
                            imageUrl = "Rhyan",
                            name = "Lester",
                            price = 3533
                        ),
                        count = 3012,
                    ),
                    CartItem(
                        product = Product(
                            id = "C",
                            imageUrl = "Rhyan",
                            name = "Lester",
                            price = 3533
                        ),
                        count = 3012,
                    ),
                )
            ),
            navigateBack = {},
            onRemoveCartItemClick = {},
            onIncreaseQuantityClick = {},
            onDecreaseQuantityClick = {},
        )
    }
}
