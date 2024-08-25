package nextstep.shoppingcart.ui.product.detail

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.cart.ShoppingCartActivity
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {

    private val product: Product by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_PRODUCT, Product::class.java)
                ?: throw IllegalArgumentException("productId is required")
        } else {
            intent.getParcelableExtra(EXTRA_PRODUCT)
                ?: throw IllegalArgumentException("Product is required")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductDetailScreen(
                        product = product,
                        onClickBackButton = { finish() },
                        onClickShoppingCartAddButton = {
                            val intent = Intent(this, ShoppingCartActivity::class.java)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }

    companion object {
        const val EXTRA_PRODUCT = "product"
    }
}
