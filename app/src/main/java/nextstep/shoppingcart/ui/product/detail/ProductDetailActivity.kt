package nextstep.shoppingcart.ui.product.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductDetailScreen()
            }
        }
    }

    companion object {
        const val EXTRA_PRODUCT = "EXTRA_PRODUCT"
    }
}
