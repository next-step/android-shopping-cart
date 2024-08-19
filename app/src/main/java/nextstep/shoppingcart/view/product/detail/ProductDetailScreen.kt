package nextstep.shoppingcart.view.product.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@Composable
fun ProductDetailScreen(product: Product) {
    ShoppingCartTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ProductDetailAppBar()
                ProductDetailImage(
                    product.imageUrl,
                    product.name,
                    Modifier
                        .wrapContentSize()
                        .aspectRatio(1f)
                )
                ProductDetailNameText(product.name, Modifier.fillMaxWidth())
                Divider(modifier = Modifier.fillMaxWidth())
                ProductDetailPriceText(product.price, Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.weight(1f))
                ProductDetailButton(Modifier.fillMaxWidth())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(Product("name", "imageUrl", 0))
    }
}
