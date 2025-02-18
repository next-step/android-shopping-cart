package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Product

@Composable
fun ProductDetail(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
    ) {
        ProductImage(
            imageUrl = product.imageUrl,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = product.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.W700,
            modifier = Modifier.padding(18.dp),
        )
        HorizontalDivider(modifier = Modifier)
        TitleValueItem(
            title = stringResource(id = R.string.product_detail_price),
            value = stringResource(id = R.string.currency_unit, product.price),
            modifier = Modifier.padding(18.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailPreview() {
    ProductDetail(
        product = Product(
            id = 1,
            name = "PET보틀-원형(500ml)",
            price = 1000,
            imageUrl = "https://developer.android.com/images/brand/Android_Robot.png"
        ),
    )
}