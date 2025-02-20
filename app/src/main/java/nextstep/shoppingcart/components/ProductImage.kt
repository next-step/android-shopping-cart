package nextstep.shoppingcart.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.GrayAAAAAA
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
@OptIn(ExperimentalGlideComposeApi::class)
internal fun ProductImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
) {
    GlideImage(
        model = imageUrl,
        contentDescription = contentDescription,
        contentScale = contentScale,
        loading = placeholder(R.drawable.ic_launcher_background),
        failure = placeholder(ColorPainter(GrayAAAAAA)),
        modifier = modifier,
    )
}

@Preview
@Composable
private fun ProductImagePreview() {
    ShoppingCartTheme {
        ProductImage(
            imageUrl = "",
            contentDescription = null,
        )
    }
}
