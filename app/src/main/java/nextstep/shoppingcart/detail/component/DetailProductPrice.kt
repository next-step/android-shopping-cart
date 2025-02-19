package nextstep.shoppingcart.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.TypoTokens.Normal20
import nextstep.shoppingcart.util.NumberFormatUtil.toPrice

@Composable
fun DetailProductPrice(
    price: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            stringResource(R.string.detail_price),
            style = Normal20,
        )
        Text(
            price.toPrice(),
            style = Normal20,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailProductPricePreview() {
    DetailProductPrice(
        price = Int.MAX_VALUE
    )
}
