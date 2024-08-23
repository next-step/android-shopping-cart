package nextstep.shoppingcart.view.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@Composable
fun CartList(
    cartItems: List<CartItem>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = 18.dp,
            vertical = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(cartItems) { _, item ->
            CartItemView(item.product, modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartListPreview() {
    ShoppingCartTheme {
        CartList(
            cartItems = listOf(
                CartItem(dummyProducts[0], 1),
                CartItem(dummyProducts[1], 1),
                CartItem(dummyProducts[2], 1),
            )
        )
    }
}
