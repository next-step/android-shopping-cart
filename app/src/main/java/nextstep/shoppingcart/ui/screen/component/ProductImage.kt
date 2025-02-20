package nextstep.shoppingcart.ui.screen.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.request.error
import coil3.request.placeholder
import nextstep.shoppingcart.R

@Composable
fun ProductImage(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(imageUrl)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .crossfade(true)
            .build(),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductImagePreview() {
    ProductImage(
        imageUrl = "https://picsum.photos/200/300",
        contentDescription = "Product Image",
    )
}