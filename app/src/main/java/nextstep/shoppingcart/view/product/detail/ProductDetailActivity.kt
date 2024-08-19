package nextstep.shoppingcart.view.product.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.model.Product

class ProductDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val productName = intent.getStringExtra("product_name") ?: "None"
        val productImageUrl = intent.getStringExtra("product_image_url") ?: "None"
        val productPrice = intent.getIntExtra("product_price", 0)

        val product = Product(productName, productImageUrl, productPrice)

        setContent {
            ProductDetailScreen(product)
        }
    }
}
