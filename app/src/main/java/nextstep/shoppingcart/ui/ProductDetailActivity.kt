package nextstep.shoppingcart.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.data.repository.ProductRepository
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {
    private val product: Product
        get() {
            val id = intent.getIntExtra(EXTRA_PRODUCT_ID, 0)
            return ProductRepository.getProductById(id)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingCartTheme {
                ProductDetailScreen(
                    product = product,
                    onAddCartClick = {},
                    onBackButtonClick = {
                        onBackPressedDispatcher.onBackPressed()
                    }
                )
            }
        }
    }

    companion object {
        private const val EXTRA_PRODUCT_ID = "key_product_id"

        fun open(activity: Activity, productId: Int) {
            val intent = Intent(activity, ProductDetailActivity::class.java).apply {
                putExtra(EXTRA_PRODUCT_ID, productId)
            }

            activity.startActivity(intent)
        }
    }
}
