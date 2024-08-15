package nextstep.shoppingcart.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductImage(
    imgUrl: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    placeholder: Painter = ProductImageDefaults.placeholder,
) {
    AsyncImage(
        model = imgUrl,
        contentDescription = contentDescription,
        placeholder = placeholder,
        modifier = modifier,
    )
}

@Immutable
object ProductImageDefaults {
    val placeholder: Painter
        @Composable get() = painterResource(id = R.drawable.image)
}

@Preview(showBackground = true)
@Composable
private fun ProductImagePreview() {
    ShoppingCartTheme {
        ProductImage(
            imgUrl = "https://example.com/image.jpg",
            contentDescription = "Product Image",
        )
    }
}
