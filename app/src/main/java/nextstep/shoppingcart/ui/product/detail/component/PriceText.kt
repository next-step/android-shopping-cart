package nextstep.shoppingcart.ui.product.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.Black10

@Composable
fun PriceText(
    modifier: Modifier = Modifier,
    price: Long,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(id = R.string.price),
            color = Black10,
            fontSize = 20.sp,
        )
        Text(
            text = stringResource(id = R.string.price_format, price),
            color = Black10,
            fontSize = 20.sp,
        )
    }
}

@Preview(widthDp = 320)
@Composable
private fun PriceTextPreview() {
    PriceText(price = 1_000_000_000)
}
