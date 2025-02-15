package nextstep.shoppingcart.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.preview.ThumbnailParameterProvider
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun Thumbnail(
    id: Long,
    imageUrl: String,
    name: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .diskCacheKey(id.toString())
            .build(),
        contentDescription = stringResource(
            R.string.product_image_accessibility_text,
            name,
        ),
        contentScale = ContentScale.FillHeight,
        error = painterResource(R.drawable.ic_connection_error),
        placeholder = painterResource(R.drawable.loading_img),
        modifier = modifier,
    )
}

@Preview
@Composable
private fun ThumbnailPreview(
    @PreviewParameter(ThumbnailParameterProvider::class) model: Triple<Long, String, String>
) {
    ShoppingCartTheme {
        model.let { (id, name, url) ->
            Thumbnail(
                id = id,
                name = name,
                imageUrl = url,
            )
        }
    }
}