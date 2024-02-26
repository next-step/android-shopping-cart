package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product

@Composable
fun ProductImage(
    modifier: Modifier = Modifier,
    product: Product
) {
    AsyncImage(
        modifier = modifier.aspectRatio(ratio = 1f),
        model = product.imageUrl,
        contentDescription = null,
        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
        contentScale = ContentScale.Crop
    )
}
