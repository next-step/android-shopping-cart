package nextstep.shoppingcart.view.product.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import nextstep.shoppingcart.R
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductDetailImage(
    productImageUrl: String,
    productName: String,
    modifier: Modifier = Modifier
) {
//    Column {
        GlideImage(
            model = productImageUrl,
            contentDescription = productName,
            loading = placeholder(R.drawable.ic_launcher_foreground),
            modifier = modifier
        )
//    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailImagePreview() {
    ShoppingCartTheme {
        ProductDetailImage(
            "imageUrl",
            "name",
            Modifier.fillMaxWidth()
        )
    }
}
