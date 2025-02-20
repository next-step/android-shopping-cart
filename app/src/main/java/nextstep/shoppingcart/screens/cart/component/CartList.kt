package nextstep.shoppingcart.screens.cart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun CartList(
    cart: Cart,
    onAddOneClick: (Product) -> Unit,
    onRemoveOneClick: (Product) -> Unit,
    onRemoveAllClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 18.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        items(key = { it.product.id }, items = cart.items) { cartItem ->
            CartItem(
                cartItem = cartItem,
                onAddOneClick = { onAddOneClick(cartItem.product) },
                onRemoveOneClick = { onRemoveOneClick(cartItem.product) },
                onRemoveAllClick = { onRemoveAllClick(cartItem.product) },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartListPreview() {
    ShoppingCartTheme {
        CartList(
            cart = Cart(
                initialItems = FakeProductRepository
                    .getAllProducts()
                    .value
                    .map { CartItem(it) }
            ),
            onAddOneClick = {},
            onRemoveOneClick = {},
            onRemoveAllClick = {},
        )
    }
}
