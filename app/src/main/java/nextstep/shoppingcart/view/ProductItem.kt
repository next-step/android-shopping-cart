package nextstep.shoppingcart.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

const val productNameMaxLine = 1

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductItem(product: Product, onItemClick: (Product) -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.clickable { onItemClick(product) }) {
        GlideImage(
            model = product.imageUrl,
            contentDescription = product.name,
            loading = placeholder(R.drawable.ic_launcher_foreground),
        )
        Text(
            text = product.name,
            modifier = modifier.padding(bottom = dimensionResource(id = R.dimen.product_name_bottom_padding)),
            maxLines = productNameMaxLine,
            fontSize = dimensionResource(id = R.dimen.product_name_size).value.sp,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.product_item_currency_unit, product.price),
            fontSize = dimensionResource(id = R.dimen.product_price_size).value.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ShoppingCartTheme {
        ProductItem(dummyProducts.first(), onItemClick = {})
    }
}
