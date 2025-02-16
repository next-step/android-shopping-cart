package nextstep.shoppingcart.productdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nextstep.shoppingcart.FakeProductsRepository
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productId = intent.getLongExtra(PRODUCT_ID, 0)
        setContent {
            ShoppingCartTheme {
                enableEdgeToEdge()
                ProductDetailScreen(
                    product = FakeProductsRepository.getProduct(productId),
                    onAddProductClick = { /*TODO*/ },
                    onBackButtonClick = { finish() }
                )
            }
        }
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