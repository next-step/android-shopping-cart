package nextstep.shoppingcart.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.Cart
import nextstep.shoppingcart.Product
import nextstep.shoppingcart.R

@SuppressLint("ResourceAsColor")
@Composable
fun ProductDetail(
    product: Product,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
        )
        Text(
            text = product.name,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(18.dp)
        )
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 18.dp,
                    start = 18.dp,
                    end = 18.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = stringResource(id = R.string.price_title),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = stringResource(id = R.string.price_format, product.price),
                style = MaterialTheme.typography.titleLarge
            )
        }

        ShoppingCartButton(
            onClick = {
                Cart.addOne(product = product)
            },
            buttonText = stringResource(id = R.string.add_to_cart),
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
private fun ProductDetailPreview() {
    val productInfo = Product(
        imageUrl = "https://image.msscdn.net/images/goods_img/20230425/3257548/3257548_16823548430020_500.jpg",
        name = "루바토 브이넥 반팔 티셔츠 네이비",
        price = 16371
    )
    ProductDetail(
        productInfo,
        modifier = Modifier.fillMaxSize()
    )
}