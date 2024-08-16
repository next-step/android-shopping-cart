package nextstep.shoppingcart.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductImage(
    modifier: Modifier = Modifier,
    productName: String,
    imageUrl: String,
) {
    AsyncImage(
        modifier = modifier,
        model = imageUrl,
        contentDescription = stringResource(R.string.product_image_description, productName),
        placeholder = painterResource(id = R.drawable.ic_launcher_background),
        contentScale = ContentScale.FillBounds
    )
}

@Preview
@Composable
private fun ProductImagePreview() {
    ShoppingCartTheme {
        ProductImage(
            productName = "아이폰",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg"
        )
    }
}
