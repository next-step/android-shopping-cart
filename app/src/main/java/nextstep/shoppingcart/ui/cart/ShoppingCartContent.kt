package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.component.BlueBottomButton
import nextstep.shoppingcart.ui.component.ShoppingCartItem

@Composable
fun ShoppingCartContent(
    cartItem: List<CartItem>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(cartItem) { item ->
                ShoppingCartItem(
                    cartItem = item,
                    onClickCloseButton = {},
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        BlueBottomButton(
            label = stringResource(id = R.string.price_format_button_label, Cart.totalPrice),
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartContentPreview() {
    ShoppingCartContent(
        cartItem = listOf(
            CartItem(
                product = Product("[든든] 동원 스위트콘", "", 99800),
                count = 1
            ),
            CartItem(
                product = Product("PET보틀-원형(500ml)", "", 84400),
                count = 1
            )
        ),
    )
}
