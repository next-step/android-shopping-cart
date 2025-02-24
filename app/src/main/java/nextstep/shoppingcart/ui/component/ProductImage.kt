package nextstep.shoppingcart.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.SubcomposeAsyncImage
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductImage(
    url: String,
    contentScale: ContentScale,
    modifier: Modifier = Modifier
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = url,
        contentScale = contentScale,
        contentDescription = url,
        loading = {
            CircularProgressIndicator(
                modifier.semantics {
                    contentDescription = url
                }
            )
        },
        error = {
            Icon(
                imageVector = Icons.Filled.Warning,
                contentDescription = url
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductImagePreview() {
    ShoppingCartTheme {
        ProductImage("", ContentScale.Crop)
    }
}
