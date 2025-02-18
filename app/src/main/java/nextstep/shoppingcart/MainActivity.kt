package nextstep.shoppingcart

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.screen.ProductsScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductsScreen(
                    onClickCart = {
                        goToCart()
                    },
                    onClickProductItem = {
                        goToProductDetail(it)
                    }
                )
            }
        }
    }

    private fun goToCart() {
        val intent = Intent(this, CartActivity::class.java)
        startActivity(intent)
    }

    private fun goToProductDetail(product: Product) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra(ProductDetailActivity.EXTRA_IMAGE_URL, product.imageUrl)
        intent.putExtra(ProductDetailActivity.EXTRA_NAME, product.name)
        intent.putExtra(ProductDetailActivity.EXTRA_PRICE, product.price)
        startActivity(intent)
    }
}
