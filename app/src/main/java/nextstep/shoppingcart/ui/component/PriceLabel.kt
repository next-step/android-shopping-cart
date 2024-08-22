package nextstep.shoppingcart.ui.component

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R

@Composable
fun PriceLabel(
    price: Int,
    style: TextStyle = LocalTextStyle.current,
    textAlign: TextAlign? = null,
) {
    Text(
        text = stringResource(id = R.string.price_format, price),
        style = style,
        textAlign = textAlign
    )
}

@Preview
@Composable
private fun PriceLabelPreview() {
    PriceLabel(
        price = 1000,
        style = MaterialTheme.typography.titleSmall
    )
}