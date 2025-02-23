package nextstep.shoppingcart.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage

@Composable
fun ShoppingCartImage(
    imageUrl: String,
    contentDescription: String,
    error: Painter,
    placeholder: Painter,
    contentScale: ContentScale = ContentScale.Fit,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        error = error,
        placeholder = placeholder,
        contentScale = contentScale,
        modifier = modifier,
    )
}
