package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.ShoppingListPreviewParameterProvider
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingListColumn(
    products: List<Product>,
    cartItems: List<CartItem>,
    modifier: Modifier = Modifier,
    onItemClick: (Product) -> Unit = {},
) {
    LazyVerticalGrid(
        modifier = modifier.padding(horizontal = 18.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(items = products) { item ->
            ShoppingItemView(
                product = item,
                onItemClick = onItemClick,
                modifier = Modifier.fillMaxWidth(),
                countInCart = cartItems.find { it.product == item }?.count ?: 0,
                onAddCount = { Cart.addOne(it) },
                onRemoveCount = { Cart.removeOne(it) },
                onAddToCart = { Cart.addOne(it) }
            )
        }
    }
}

@Preview
@Composable
private fun ShoppingListColumnPreview(
    @PreviewParameter(ShoppingListPreviewParameterProvider::class) products: List<Product>,
) {
    ShoppingCartTheme {
        ShoppingListColumn(
            products = products,
            cartItems = listOf(CartItem(products[0], 1))
        )
    }
}