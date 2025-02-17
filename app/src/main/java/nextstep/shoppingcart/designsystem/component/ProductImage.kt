package nextstep.shoppingcart.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import nextstep.shoppingcart.model.Product


@Composable
fun ProductImage(
    item: Product,
    modifier: Modifier = Modifier,
    painter: AsyncImagePainter = rememberAsyncImagePainter(item.imageUrl)
) {
    val state by painter.state.collectAsState()

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f), contentAlignment = Alignment.Center
    ) {
        when (state) {
            is AsyncImagePainter.State.Loading, AsyncImagePainter.State.Empty -> {
                CircularProgressIndicator(modifier = Modifier.testTag("product_image_loading"))
            }

            is AsyncImagePainter.State.Error -> Text("product_image_error")
            is AsyncImagePainter.State.Success -> {
                Image(
                    painter = painter,
                    contentDescription = "product_image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}