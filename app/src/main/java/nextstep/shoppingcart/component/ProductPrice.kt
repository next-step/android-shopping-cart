package nextstep.shoppingcart.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.Black33

@Composable
fun ProductPrice(
    price: Int,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified
) {
    Text(
        text = stringResource(R.string.price_comma, price),
        fontSize = fontSize,
        color = Black33,
        fontWeight = FontWeight.W400,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductPricePreview() {
    ProductPrice(price = 10000)
}