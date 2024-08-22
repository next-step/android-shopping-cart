package nextstep.shoppingcart.view.product

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.view.product.detail.ProductDetailActivity
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

class ProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductsScreen { productName, productImageUrl, productPrice ->
                    val intent = Intent(this, ProductDetailActivity::class.java).apply {
                        putExtra("product_name", productName)
                        putExtra("product_image_url", productImageUrl)
                        putExtra("product_price", productPrice)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}
