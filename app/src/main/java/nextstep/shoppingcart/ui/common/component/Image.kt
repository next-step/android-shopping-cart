package nextstep.shoppingcart.ui.common.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import nextstep.shoppingcart.R

@Composable
fun Image(
    modifier: Modifier = Modifier,
    url: String,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current).data(url).crossfade(true).build(),
        placeholder = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "image",
        contentScale = ContentScale.Crop,
        modifier = modifier,
    )
}
