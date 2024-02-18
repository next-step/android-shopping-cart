package nextstep.shoppingcart.products.detail.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.products.formatter.DefaultPriceFormatter
import nextstep.shoppingcart.products.formatter.PriceFormatter

@Composable
fun ProductPrice(
    productPrice: Int,
    modifier: Modifier = Modifier,
    priceFormatter: PriceFormatter = DefaultPriceFormatter,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            modifier = Modifier.wrapContentWidth(Alignment.Start),
            fontSize = 20.sp,
            text = stringResource(R.string.product_details_screen_product_price),
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier.wrapContentWidth(Alignment.End),
            fontSize = 20.sp,
            text = priceFormatter.format(productPrice),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductPricePreview() {
    ProductPrice(productPrice = 1_234_567)
}
