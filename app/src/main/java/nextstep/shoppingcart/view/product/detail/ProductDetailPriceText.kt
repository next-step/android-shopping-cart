package nextstep.shoppingcart.view.product.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@Composable
fun ProductDetailPriceText(productPrice: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.product_detail_name_padding)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stringResource(id = R.string.product_detail_price))
        Text(
            text = stringResource(id = R.string.product_item_currency_unit, productPrice),
            fontSize = dimensionResource(id = R.dimen.product_detail_price_size).value.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailNameTextPreview() {
    ShoppingCartTheme {
        ProductDetailPriceText(43_000, Modifier.fillMaxWidth())
    }
}
