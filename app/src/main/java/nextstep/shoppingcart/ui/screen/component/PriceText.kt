package nextstep.shoppingcart.ui.screen.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import nextstep.shoppingcart.ui.utils.formatter.DefaultMoneyFormatter
import nextstep.shoppingcart.ui.utils.formatter.MoneyFormatter

@Composable
fun PriceText(
    price: Int,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal,
    fontColor: Color = Color.Unspecified,
    formatter: MoneyFormatter = DefaultMoneyFormatter
) {
    Text(
        text = "${formatter.format(price)}원",
        modifier = modifier,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = fontColor,
    )
}

@Preview(showBackground = true)
@Composable
private fun PriceTextPreview() {
    PriceText(price = 10000)
}