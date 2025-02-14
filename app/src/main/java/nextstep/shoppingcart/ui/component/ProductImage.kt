package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.SubcomposeAsyncImage
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductImage(
    url: String,
    modifier: Modifier = Modifier
) {
    SubcomposeAsyncImage(
        model = url,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        contentDescription = null,
        loading = {
            CircularProgressIndicator()
        },
        error = {
            Icon(
                imageVector = Icons.Filled.Warning,
                contentDescription = null
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductImagePreview() {
    ShoppingCartTheme {
        ProductImage("")
    }
}
