package nextstep.shoppingcart.ui.shoppingcart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.ui.shoppingcart.model.CartItem

@Composable
fun ShoppingCartLazyColumn(
    cartProducts: List<CartItem>,
    onRemoveClick: (productId: Long) -> Unit,
    onSubtractClick: (productId: Long) -> Unit,
    onAddClick: (productId: Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space = 16.dp),
        modifier = modifier.padding(horizontal = 18.dp),
    ) {
        items(
            items = cartProducts,
            key = { cartProduct -> cartProduct.product.id },
        ) { cartProduct ->
            ShoppingCartItem(
                product = cartProduct.product,
                onRemoveClick = { onRemoveClick(cartProduct.product.id) },
                onSubtractClick = { onSubtractClick(cartProduct.product.id) },
                onAddClick = { onAddClick(cartProduct.product.id) },
                sum = cartProduct.totalPrice,
                count = cartProduct.count,
            )
        }
    }
}

@Preview
@Composable
private fun ShoppingCartLazyColumnPreview() {
    ShoppingCartLazyColumn(
        cartProducts = Cart.items,
        onRemoveClick = {},
        onSubtractClick = {},
        onAddClick = {},
    )
}
