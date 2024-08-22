package nextstep.shoppingcart.ui.productlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.Product
import nextstep.shoppingcart.ui.component.PriceLabel
import nextstep.shoppingcart.ui.component.ProductImage
import nextstep.shoppingcart.ui.component.ProductTitle
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductInfo(
    product: Product,
    onProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable {
            onProductClick(product)
        },
        horizontalAlignment = Alignment.Start,
    ) {
        ProductImage(
            imageUrl = product.imageUrl,
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(158.dp),
            contentScale = ContentScale.Crop
        )
        ProductTitle(
            title = product.name,
            style = MaterialTheme.typography.titleMedium
        )
        PriceLabel(
            price = product.price,
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
            onProductClick = { }
        )
    }
}