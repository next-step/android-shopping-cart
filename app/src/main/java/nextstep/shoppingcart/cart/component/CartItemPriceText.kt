package nextstep.shoppingcart.cart.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartPriceText(
    price: Int,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = stringResource(R.string.price_format, price),
        style = TextStyle(
            fontWeight = FontWeight.W400,
            fontSize = 16.sp,
            lineHeight = 26.67.sp,
            letterSpacing = 0.5.sp
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun CartPricePreview() {
    ShoppingCartTheme {
        CartPriceText(
            price = 10000
        )
    }
}
