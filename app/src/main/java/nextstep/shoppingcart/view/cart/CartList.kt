package nextstep.shoppingcart.view.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.ItemCountButton
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@Composable
fun CartList(
    cartItems: List<CartItem>,
    contentPadding: PaddingValues,
    verticalArrangement: Arrangement.Vertical,
    onItemRemoved: (CartItem) -> Unit,
    onAddClicked: (CartItem) -> Unit,
    onRemoveClicked: (CartItem) -> Unit,
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = verticalArrangement
    ) {
        itemsIndexed(cartItems) { _, item ->
            CartItemView(
                product = item.product,
                onItemRemoved = { onItemRemoved(item) },
                content = {
                    ItemCountButton(
                        product = item.product,
                        itemCount = Cart.getCountByProductName(item.product.name),
                        onAddClicked = { onAddClicked(item) },
                        onRemoveClicked = { onRemoveClicked(item) },
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(id = R.dimen.cart_item_quantity_padding_start),
                                dimensionResource(id = R.dimen.cart_item_quantity_padding)
                            )
                    )
                }
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
                CartItem(dummyProducts[0], 1, false),
                CartItem(dummyProducts[1], 1, false),
                CartItem(dummyProducts[2], 1, false),
            ),
            contentPadding = PaddingValues(
                horizontal = 18.dp,
                vertical = 16.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            onItemRemoved = {},
            onAddClicked = {},
            onRemoveClicked = {},
        )
    }
}
