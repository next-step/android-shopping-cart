package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.data.FakeData
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.screen.component.ProductContainer
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductScreen(
    productList: List<Product>,
    cartItemList: List<CartItem>,
    onProductClick: (Product) -> Unit,
    onPlusCircleClick: (Product) -> Unit,
    onMinusCartItemClick: (Product) -> Unit,
    onPlusCartItemClick: (Product) -> Unit,
) {
    ProductListSection(
        products = productList,
        cartItems = cartItemList,
        onProductClick = onProductClick,
        onPlusCircleClick = onPlusCircleClick,
        onMinusCartItemClick = onMinusCartItemClick,
        onPlusCartItemClick = onPlusCartItemClick
    )
}

@Composable
private fun ProductListSection(
    products: List<Product>,
    cartItems: List<CartItem>,
    modifier: Modifier = Modifier,
    onProductClick: (Product) -> Unit,
    onPlusCircleClick: (Product) -> Unit,
    onMinusCartItemClick: (Product) -> Unit,
    onPlusCartItemClick: (Product) -> Unit,
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 13.dp),
    ) {
        items(products) { product ->
            val cartItemCount = cartItems.find { it.product == product }?.count ?: 0

            ProductContainer(
                imageUrl = product.imageUrl,
                title = product.title,
                price = product.price,
                count = cartItemCount,
                isQuantityAdjusting = cartItemCount > 0,
                modifier = Modifier.clickable(
                    onClick = { onProductClick(product) }
                ),
                onPlusCircleClick = { onPlusCircleClick(product) },
                onMinusCartItemClick = { onMinusCartItemClick(product) },
                onPlusCartItemClick = { onPlusCartItemClick(product) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListPreview() {
    val fakeItemList = FakeData.products
    ProductListSection(
        products = fakeItemList,
        cartItems = emptyList(),
        onProductClick = { },
        onPlusCircleClick = { },
        onMinusCartItemClick = { },
        onPlusCartItemClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductScreenPreview() {
    ShoppingCartTheme {
        ProductScreen(
            productList = FakeData.products,
            cartItemList = emptyList(),
            onProductClick = { },
            onPlusCircleClick = { },
            onMinusCartItemClick = { },
            onPlusCartItemClick = { }
        )
    }
}