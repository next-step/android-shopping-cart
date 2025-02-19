package nextstep.shoppingcart.detail.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.util.ImageUtil.getUrlIfNotPreview

@Composable
fun DetailProductImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
) {
    AsyncImage(
        model = getUrlIfNotPreview(imageUrl),
        contentDescription = contentDescription,
        placeholder = painterResource(R.drawable.woori),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(1f)
            .fillMaxWidth()
    )
}

@Preview
@Composable
private fun DetailProductImagePreview() {
    DetailProductImage(
        imageUrl = "",
    )
}
