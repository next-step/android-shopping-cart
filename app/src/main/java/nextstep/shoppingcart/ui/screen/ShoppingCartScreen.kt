package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.repository.CartRepository
import nextstep.shoppingcart.ui.screen.component.CartItemContainer

@Composable
fun ShoppingCartScreen(
    modifier: Modifier = Modifier,
    cartItemList: List<CartItem>,
    onMinusCartItem: (CartItem) -> Unit,
    onPlusCartItem: (CartItem) -> Unit,
    onCartItemDelete: (CartItem) -> Unit,
) {
    LazyColumn(
        modifier = modifier.padding(horizontal = 18.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
    ) {
        items(cartItemList) { cartItem ->
            CartItemContainer(
                cartItem = cartItem,
                onMinusCartItem = { onMinusCartItem(cartItem) },
                onPlusCartItem = { onPlusCartItem(cartItem) },
                onCartItemDelete = { onCartItemDelete(cartItem) },
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShoppingCartScreenPreview() {
    ShoppingCartScreen(
        cartItemList = CartRepository.items,
        onMinusCartItem = { },
        onPlusCartItem = { },
        onCartItemDelete = { },
    )
}