package nextstep.shoppingcart.common.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductImage(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        modifier = modifier
            .aspectRatio(1f),
        model = imageUrl,
        contentDescription = contentDescription
    )
}

@Preview
@Composable
private fun ProductImagePreview() {
    ShoppingCartTheme {
        ProductImage(
            imageUrl = "https://picsum.photos/id/1/300/300",
            contentDescription = "",
        )
    }
}
