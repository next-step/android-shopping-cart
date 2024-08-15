package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductInfo(
    product: Product,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        AsyncImage(
            model =  product.imageUrl,
            contentDescription = product.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(158.dp)
        )
        Text(
            text = product.name,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = product.formattedPrice,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview
@Composable
private fun ProductInfoPreview() {
    ShoppingCartTheme {
        val productInfo = Product(
            imageUrl = "https://image.msscdn.net/images/goods_img/20230425/3257548/3257548_16823548430020_500.jpg",
            name = "루바토 브이넥 반팔 티셔츠 네이비",
            price = 16371
        )
        ProductInfo(
            product = productInfo,
        )
    }
}