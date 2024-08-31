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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.CartItemInfo
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.component.BlueBottomButton
import nextstep.shoppingcart.ui.component.CartItem

@Composable
fun CartContent(
    cartList: List<CartItemInfo>,
    onClickIncrease: (Product) -> Unit,
    onClickDecrease: (Product) -> Unit,
    onClickDelete: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(cartList) { item ->
                CartItem(
                    cartItemInfo = item,
                    onClickIncrease = onClickIncrease,
                    onClickDecrease = onClickDecrease,
                    onClickDelete = onClickDelete,
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

class CartContentPreviewParameterProvider :
    PreviewParameterProvider<List<CartItemInfo>> {
    override val values: Sequence<List<CartItemInfo>> = sequenceOf(
        listOf(
            CartItemInfo(
                product = Product("[든든] 동원 스위트콘", "", 99800),
                count = 1
            ),
            CartItemInfo(
                product = Product("PET보틀-원형(500ml)", "", 84400),
                count = 1
            )
        )
    )
}

@Preview(showBackground = true)
@Composable
fun CartContentPreview(
    @PreviewParameter(CartContentPreviewParameterProvider::class)
    parameter: List<CartItemInfo>,
) {
    CartContent(
        cartList = parameter,
        {}, {}, {}
    )
}
