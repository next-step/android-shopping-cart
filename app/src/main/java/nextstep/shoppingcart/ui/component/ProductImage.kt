package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import nextstep.shoppingcart.R

@Composable
fun ProductImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = stringResource(id = R.string.product_image_description),
        contentScale = ContentScale.Crop,
        modifier = modifier.aspectRatio(1f)
    )
}