package nextstep.shoppingcart.cart.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.cart.component.CartOrderButton
import nextstep.shoppingcart.cart.component.CartProductItem
import nextstep.shoppingcart.model.CartItem

@Composable
fun CartContent(
    cartItems: List<CartItem>,
    onClickDeleteItemButton: () -> Unit,
    onClickIncreaseCountButton: () -> Unit,
    onClickDecreaseCountButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(items = cartItems) {
                CartProductItem(
                    cartItem = it,
                    onClickDeleteItemButton = onClickDeleteItemButton,
                    onClickIncreaseCountButton = onClickIncreaseCountButton,
                    onClickDecreaseCountButton = onClickDecreaseCountButton,
                )
            }
        }
        CartOrderButton(
            price = 0,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
        )
    }
}

@Preview
@Composable
private fun CartContentPreview() {
    CartContent(
        cartItems = emptyList(),
        onClickDeleteItemButton = {},
        onClickIncreaseCountButton = {},
        onClickDecreaseCountButton = {},
    )
}
