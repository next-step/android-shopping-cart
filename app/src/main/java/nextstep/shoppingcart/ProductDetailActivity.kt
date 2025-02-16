package nextstep.shoppingcart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.domain.repository.ProductRepository
import nextstep.shoppingcart.screens.ProductDetailScreen

class ProductDetailActivity : ComponentActivity() {
    private val productId: Int by lazy {
        val value = intent.getIntExtra(PRODUCT_ID, ERROR_PRODUCT_ID)
        if (value == ERROR_PRODUCT_ID) throw IllegalArgumentException("productId is required") else value
    }
    private val productRepository: ProductRepository = FakeProductRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()
            ProductDetailScreen(
                product = productRepository.getProductByIdOrNull(productId) ?: Product.NotFound,
                onAddCartClick = ::startCartActivity,
                onBackClick = onBackPressedDispatcher::onBackPressed
            )
        }
    }

    private fun startCartActivity() {
        val intent: Intent = CartActivity.getIntent(context = this)
        startActivity(intent)
    }

    companion object {
        private const val PRODUCT_ID = "productId"
        private const val ERROR_PRODUCT_ID = Int.MIN_VALUE

        fun getIntent(context: Context, productId: Int): Intent {
            return Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(PRODUCT_ID, productId)
            }
        }
    }
}
