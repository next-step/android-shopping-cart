package nextstep.shoppingcart.ui.shoppingcart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.Cart.items

@Composable
fun ShoppingCartLazyColumn(
    modifier: Modifier = Modifier,
) {
    var cartProducts by remember { mutableStateOf(items) }

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
                removeItem = {
                    Cart.removeOne(cartProduct.product)
                    cartProducts = items
                },
            )
        }
    }
}

@Preview
@Composable
private fun ShoppingCartLazyColumnPreview() {
    ShoppingCartLazyColumn()
}
