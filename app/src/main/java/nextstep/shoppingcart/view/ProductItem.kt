package nextstep.shoppingcart.view

import android.icu.text.NumberFormat
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.resource.ShoppingCartTheme
import java.util.Locale

const val productNameMaxLine = 1

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductItem(product: Product, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        GlideImage(
            model = product.imageUrl,
            contentDescription = product.name,
            loading = placeholder(R.drawable.ic_launcher_foreground),
            modifier = Modifier
                .fillMaxSize()
        )
        Text(
            text = product.name,
            modifier = modifier.padding(bottom = dimensionResource(id = R.dimen.product_name_bottom_padding)),
            maxLines = productNameMaxLine,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold
        )
        val formattedPrice =
            NumberFormat.getNumberInstance(Locale.KOREAN).format(product.price)
        Text(text = "${formattedPrice}${stringResource(id = R.string.product_item_currency_unit)}")
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ShoppingCartTheme {
        ProductItem(dummyProducts.first())
    }
}
