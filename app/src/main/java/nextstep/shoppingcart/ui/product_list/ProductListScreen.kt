@file:OptIn(ExperimentalMaterial3Api::class)

package nextstep.shoppingcart.ui.product_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.designsystem.ProductListItem
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListScreen(
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    val state by remember {
        mutableStateOf(ProductListState(products = products))
    }

    ProductListScreen(
        state = state,
        modifier = modifier,
    )
}

@Composable
private fun ProductListScreen(
    state: ProductListState,
    modifier: Modifier = Modifier,
) {
    val lazyState = rememberLazyGridState()
    val scope = rememberCoroutineScope()
    val showScrollToTopButton by remember {
        derivedStateOf {
            lazyState.firstVisibleItemIndex >= 5
        }
    }

    Scaffold(
        topBar = {
            ProductListTopBar(state.selectedItemCount)
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
        LazyVerticalGrid(
            state = lazyState,
            columns = GridCells.Fixed(2),
            modifier = modifier
                .padding(paddingValues)
                .padding(horizontal = 18.dp, vertical = 13.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(bottom = 100.dp)
        ) {
            items(state.products) { product ->
                ProductListItem(product)
            }
        }
    }
}

@Composable
private fun ProductListTopBar(
    addedItemCount: Int,
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
                modifier = Modifier.padding(end = 4.dp),
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
                products = listOf(
                    Product(
                        imageUrl = "",
                        name = "PET-보틀-정사각형 정사각형 정사각형 ",
                        price = 10_000
                    ),
                    Product(
                        imageUrl = "",
                        name = "PET-보틀-세모",
                        price = 10_000_000
                    ),
                    Product(
                        imageUrl = "",
                        name = "PET-보틀-정사각형 정사각형 정사각형 ",
                        price = 1_000_000_000,
                    ),
                    Product(
                        imageUrl = "",
                        name = "PET-보틀-정사각형 정사각형 정사각형 ",
                        price = 10_000
                    ),
                    Product(
                        imageUrl = "",
                        name = "PET-보틀-정사각형 정사각형 정사각형 ",
                        price = 10_000
                    ),
                )
            ),
        )
    }
}
