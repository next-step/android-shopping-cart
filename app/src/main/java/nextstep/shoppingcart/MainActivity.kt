package nextstep.shoppingcart

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.detail.ProductDetailActivity
import nextstep.shoppingcart.model.products
import nextstep.shoppingcart.productlist.ProductListScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductListScreen(
                    productList = products,
                    onProductClick = { id ->
                        val intent = Intent(this, ProductDetailActivity::class.java).apply {
                            putExtra(ProductDetailActivity.KEY_PRODUCT_ID, id)
                        }
                        startActivity(intent)
                    },
                    onCartClick = {
                        startActivity(Intent(this, CartActivity::class.java))
                    }
                )
            }
        }
    }
}
