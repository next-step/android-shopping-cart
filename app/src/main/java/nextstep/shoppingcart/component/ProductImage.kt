package nextstep.shoppingcart.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R

@Composable
fun ProductImage(
    imageUrl: String = "",
    ratio: Float,
    modifier: Modifier = Modifier
) {
    if (imageUrl.isNotEmpty()) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Product Image",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(ratio)
        )
    } else {
        Image(
            painter = painterResource(R.drawable.test_image),
            contentDescription = "Placeholder Image",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(ratio)
        )
    }
}
