package nextstep.shoppingcart.ui.shoppingdetail.component


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R.string.shopping_detail_product_price
import nextstep.shoppingcart.R.string.shopping_item_price_format
import nextstep.shoppingcart.data.dummyProducts
import nextstep.shoppingcart.ui.shoppinglist.model.Product

@Composable
fun ShoppingDetailProductPrice(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 18.dp),
    ) {
        ShoppingDetailPriceText(text = stringResource(id = shopping_detail_product_price))
        ShoppingDetailPriceText(
            text = stringResource(id = shopping_item_price_format, product.price),
        )
    }
}

@Preview
@Composable
private fun ShoppingDetailProductPricePreview() {
    ShoppingDetailProductPrice(product = dummyProducts[0])
}
