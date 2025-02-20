package nextstep.shoppingcart.cart.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.BottomLargeButton
import nextstep.shoppingcart.util.NumberFormatUtil.toCommaFormat

@Composable
fun CartOrderButton(
    price: Int,
    modifier: Modifier = Modifier,
) {
    BottomLargeButton(
        text = stringResource(R.string.cart_order_button_text, price.toCommaFormat()),
        onClickButton = {},
        modifier = modifier,
    )
}

@Preview
@Composable
private fun CartOrderButtonPreview() {
    CartOrderButton(Int.MAX_VALUE)
}
