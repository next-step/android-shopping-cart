package nextstep.shoppingcart.ui.productlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.component.PriceLabel
import nextstep.shoppingcart.ui.component.ProductCounter
import nextstep.shoppingcart.ui.component.ProductTitle
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductInfo(
    product: Product,
    count: Int,
    onProductClick: (Product) -> Unit,
    onMinusClick: (Product) -> Unit,
    onPlusClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.clickable {
            onProductClick(product)
        },
        horizontalAlignment = Alignment.Start,
    ) {
        Box {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(158.dp),
                contentScale = ContentScale.Crop
            )
            ProductCounter(
                count = count,
                onMinusClick = {
                    onMinusClick(product)
                },
                onPlusClick = {
                    onPlusClick(product)
                },
                modifier = Modifier
                    .padding(end = 12.dp, bottom = 12.dp)
                    .align(Alignment.BottomEnd)
                    .background(Color.White)
            )

        }
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
            id = 1,
            imageUrl = "https://image.msscdn.net/images/goods_img/20230425/3257548/3257548_16823548430020_500.jpg",
            name = "루바토 브이넥 반팔 티셔츠 네이비",
            price = 16371
        )
        ProductInfo(
            product = productInfo,
            count = 0,
            onProductClick = { },
            onMinusClick = { },
            onPlusClick = { }
        )
    }
}