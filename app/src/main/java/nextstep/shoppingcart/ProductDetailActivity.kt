package nextstep.shoppingcart

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.screen.ProductDetailScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {

    private val imageUrl: String by lazy {
        intent.getStringExtra(EXTRA_IMAGE_URL)
            ?: throw IllegalArgumentException("imageUrl is required")
    }

    private val name: String by lazy {
        intent.getStringExtra(EXTRA_NAME)
            ?: throw IllegalArgumentException("name is required")
    }

    private val price: Int by lazy {
        intent.getIntExtra(EXTRA_PRICE, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShoppingCartTheme {
                ProductDetailScreen(
                    product = Product(
                        imageUrl = imageUrl,
                        name = name,
                        price = price
                    ),
                    onClickBack = {
                        finish()
                    },
                    onClickAddToCart = {
                        goToCart()
                    }
                )
            }
        }
    }

    private fun goToCart() {
        val intent = Intent(this, CartActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val EXTRA_IMAGE_URL = "image_url"
        const val EXTRA_NAME = "name"
        const val EXTRA_PRICE = "price"
    }
}
