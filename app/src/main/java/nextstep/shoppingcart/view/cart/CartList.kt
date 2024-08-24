package nextstep.shoppingcart.view.cart

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@Composable
fun CartList(
    cartItems: List<CartItem>,
    contentPadding: PaddingValues,
    verticalArrangement: Arrangement.Vertical,
    onCountButtonClicked: (CartItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    var items by remember { mutableStateOf(cartItems) }

    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = verticalArrangement
    ) {
        itemsIndexed(items) { _, item ->
            CartItemView(
                product = item.product,
                onItemRemoved = {
                    items = Cart.removeAll(item.product)
                },
                onAddClicked = {
                    onCountButtonClicked(item)
                },
                onRemoveClicked = {
                    onCountButtonClicked(item)
                },
                modifier = modifier
            )
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
            ),
            contentPadding = PaddingValues(
                horizontal = 18.dp,
                vertical = 16.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            onCountButtonClicked = { }
        )
    }
}
