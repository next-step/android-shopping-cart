package nextstep.shoppingcart.ui.component

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.Product
import nextstep.shoppingcart.ProductDetailActivity
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import kotlin.math.round

@Composable
fun ProductInfo(
    product: Product,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Column(
        modifier = modifier.clickable {
            val intent = Intent(context, ProductDetailActivity::class.java).apply {
                putExtra("imageUrl", product.imageUrl)
                putExtra("name", product.name)
                putExtra("price", product.price)
            }
            context.startActivity(intent)
        },
        horizontalAlignment = Alignment.Start,
    ) {
        AsyncImage(
            model = product.imageUrl,
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
            text = stringResource(id = R.string.price_format, product.price),
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
        ProductInfo(product = productInfo)
    }
}