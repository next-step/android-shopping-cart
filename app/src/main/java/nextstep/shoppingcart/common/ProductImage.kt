package nextstep.shoppingcart.common

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R

@Composable
fun ProductImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit
) {
    if (LocalInspectionMode.current) {
        Image(
            modifier = modifier,
            painter = painterResource(R.drawable.ic_launcher_background),
            contentScale = contentScale,
            contentDescription = null
        )
    } else {
        AsyncImage(
            modifier = modifier,
            placeholder = ColorPainter(Color.LightGray),
            model = imageUrl,
            contentScale = contentScale,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun ProductImagePreview() {
    ProductImage(imageUrl = "Preview에서는 디폴트 이미지만 표시됩니다.")
}