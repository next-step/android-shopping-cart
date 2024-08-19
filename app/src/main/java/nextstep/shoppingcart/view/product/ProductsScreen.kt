package nextstep.shoppingcart.view.product

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.product.detail.ProductDetailActivity
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@Composable
fun ProductsScreen() {
    val context = LocalContext.current

    ShoppingCartTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProductsTopAppBar()
                ProductsGrid(
                    dummyProducts,
                    onItemClick = { product ->
                        val intent = Intent(context, ProductDetailActivity::class.java).apply {
                            putExtra("product_name", product.name)
                            putExtra("product_image_url", product.imageUrl)
                            putExtra("product_price", product.price)
                        }
                        context.startActivity(intent)
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsScreenPreview() {
    ShoppingCartTheme {
        ProductsScreen()
    }
}
