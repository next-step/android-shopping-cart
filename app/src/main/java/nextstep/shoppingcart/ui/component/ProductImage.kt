package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProductImage(
    imageUrl: String,
    contentDescription: String,
    contentScale: ContentScale,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
    )
}

@Preview
@Composable
private fun ProductImagePreview() {
    ProductImage(
        imageUrl = "https://image.msscdn.net/images/goods_img/20240201/3840937/3840937_17083068789627_500.jpg",
        contentDescription = "Cut Off Curved Denim Pants - Black",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(136.dp)
            .height(84.dp)
    )
}