package nextstep.shoppingcart.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
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
    painter: AsyncImagePainter = rememberAsyncImagePainter(item.imageUrl),
    contentScale: ContentScale = ContentScale.Crop
) {
    val state by painter.state.collectAsState()

    when (state) {
        is AsyncImagePainter.State.Loading, AsyncImagePainter.State.Empty -> {
            Box(
                modifier = modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(modifier = Modifier.testTag("product_image_loading"))
            }
        }

        is AsyncImagePainter.State.Error ->
            Box(
                modifier = modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text("product_image_error")
            }

        is AsyncImagePainter.State.Success -> {
            Image(
                painter = painter,
                contentDescription = "product_image",
                modifier = modifier.fillMaxSize(),
                contentScale = contentScale
            )
        }
    }
}