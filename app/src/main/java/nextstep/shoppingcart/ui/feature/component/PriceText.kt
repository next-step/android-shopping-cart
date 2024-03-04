package nextstep.shoppingcart.ui.feature.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import java.text.DecimalFormat

@Composable
fun PriceText(
    price: Int,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp
) {
    val formattedPrice by remember(price) { mutableStateOf(price.toFormattedPrice()) }
    Text(
        modifier = modifier,
        fontSize = fontSize,
        text = stringResource(id = R.string.product_price, formattedPrice)
    )
}

private fun Int.toFormattedPrice(): String =
    DecimalFormat("#,###").format(this)

@Preview(showBackground = true)
@Composable
private fun PriceTextPreview() {
    PriceText(100_000_000)
}
