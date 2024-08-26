package nextstep.shoppingcart

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.component.main.ProductItem
import nextstep.shoppingcart.component.main.MainTopBar
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts

@Composable
fun ProductListScreen(
    cartItems: List<CartItem>,
    onItemClick: (product: Product) -> Unit,
    onAddCartClick: (product: Product) -> Unit,
    onItemIncrease: (product: Product) -> Unit,
    onItemDecrease: (product: Product) -> Unit,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { MainTopBar(onCartClick) }
    ) { paddingValues ->
        LazyVerticalGrid(
            modifier = modifier
                .padding(paddingValues = paddingValues)
                .padding(horizontal = 16.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(items = dummyProducts) {
                ProductItem(
                    cartItem = CartItem(
                        Product(
                        it.name,
                        it.imageUrl,
                        it.price
                    ),
                        count = cartItems.find { cartItem ->
                            cartItem.product == it
                        }?.count ?: 0
                    ),
                    onAddToCart = { onAddCartClick(it) },
                    onIncrease = { onItemIncrease(it) },
                    onDecrease = { onItemDecrease(it) },
                    modifier = Modifier.clickable (
                        onClick = { onItemClick(it) },
                    )
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen(
        cartItems = listOf(
            CartItem(
                dummyProducts.first(),
                1
            ),
            CartItem(
                dummyProducts[1],
                -30
            ),
            CartItem(
                dummyProducts[2],
                20
            )
        ),
        onItemClick = { _-> },
        onCartClick = {},
        onItemIncrease = {},
        onItemDecrease = {},
        onAddCartClick = {}
    )
}