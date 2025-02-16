package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.productdetail.ProductDetailActivity
import nextstep.shoppingcart.products.ProductsScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                enableEdgeToEdge()
                ProductsScreen(
                    products = FakeProductsRepository.getProducts(),
                    onProductClick = { product -> handleProductClick(product) }
                )
            }
        }
    }

    private fun handleProductClick(product: Product) {
        startActivity(ProductDetailActivity.getIntent(this, product.id))
    }
}


