package nextstep.shoppingcart.ui.productdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nextstep.shoppingcart.FakeProductsRepository
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.shoppingcart.ShoppingCartActivity
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productId = intent.getLongExtra(PRODUCT_ID, 0)
        val product = FakeProductsRepository.getProduct(productId)
        setContent {
            ShoppingCartTheme {
                enableEdgeToEdge()
                ProductDetailScreen(
                    product = product,
                    onAddProductClick = { handleAddProductClick(product) },
                    onBackButtonClick = { finish() }
                )
            }
        }
    }

    private fun handleAddProductClick(product: Product) {
        startActivity(ShoppingCartActivity.getIntent(this))
    }

    companion object {
        private const val PRODUCT_ID = "product_id"

        fun getIntent(context: Context, productId: Long): Intent {
            return Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(PRODUCT_ID, productId)
            }
        }
    }
}