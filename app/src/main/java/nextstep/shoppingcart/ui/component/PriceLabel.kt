package nextstep.shoppingcart.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R

@Composable
fun PriceLabel(
    price: Long,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    textUnit: TextUnit = 16.sp
) {
    Text(
        text = stringResource(id = R.string.price_format, price),
        fontSize = textUnit,
        color = textColor,
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
private fun PriceLabelPreview() {
    PriceLabel(price = 1000)
}
