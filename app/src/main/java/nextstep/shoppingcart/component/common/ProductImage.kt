package nextstep.shoppingcart.component.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun ProductImage(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier
    )
}