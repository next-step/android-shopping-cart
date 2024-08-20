package nextstep.shoppingcart.view.product.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.view.product.productNameMaxLine
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@Composable
fun ProductDetailNameText(productName: String, modifier: Modifier = Modifier) {
    Text(
        text = productName,
        modifier = modifier.padding(dimensionResource(id = R.dimen.product_detail_name_padding)),
        maxLines = productNameMaxLine,
        fontSize = dimensionResource(id = R.dimen.product_detail_name_size).value.sp,
        overflow = TextOverflow.Ellipsis,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailNameTextPreview() {
    ShoppingCartTheme {
        ProductDetailNameText("[최고심] 빅허그인형")
    }
}
