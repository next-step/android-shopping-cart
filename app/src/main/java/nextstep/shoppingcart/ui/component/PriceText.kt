package nextstep.shoppingcart.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography


@Composable
fun PriceText(
    price: Int,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.bodyMedium,
    fontWeight: FontWeight = FontWeight.Normal,
) {
    Text(
        text = stringResource(R.string.korean_price_format, price),
        fontWeight = fontWeight,
        style = style,
        maxLines = 1,
        modifier = modifier,
        overflow = TextOverflow.Ellipsis,
    )
}

@Preview(showBackground = true)
@Composable
private fun PriceTextPreview() {
    ShoppingCartTheme {
        PriceText(
            price = 1000,
            style = Typography.bodyMedium,
        )
    }
}