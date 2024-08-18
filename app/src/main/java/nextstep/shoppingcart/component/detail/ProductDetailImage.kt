package nextstep.shoppingcart.component.detail

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailImage(
    imageUrl: String,
    name: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        model = imageUrl,
        contentDescription = name,
    )
}

@Preview
@Composable
private fun ProductDetailImagePreview() {
    ShoppingCartTheme {
        ProductDetailImage(
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            name = "Product Image"
        )
    }
}