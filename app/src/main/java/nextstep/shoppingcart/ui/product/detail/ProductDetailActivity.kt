package nextstep.shoppingcart.ui.product.detail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.cart.ShoppingCartActivity
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Suppress("DEPRECATION")
class ProductDetailActivity : ComponentActivity() {

    private val product: Product by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_PRODUCT, Product::class.java)
        } else {
            intent.getParcelableExtra(EXTRA_PRODUCT)
        } ?: throw IllegalArgumentException("product is required")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductDetailScreen(
                    product = product,
                    onBack = { finish() },
                    onShowShoppingCart = {
                        startActivity(
                            Intent(
                                this,
                                ShoppingCartActivity::class.java,
                            )
                        )
                    },
                )
            }
        }
    }

    companion object {
        const val EXTRA_PRODUCT = "EXTRA_PRODUCT"
    }
}
