package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.navigator.getProductModel
import nextstep.shoppingcart.ui.ProductDetailScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductDetailScreen(
                    model = intent.getProductModel(),
                    onBackButtonClick = {
                        onBackPressedDispatcher.onBackPressed()
                    }
                )
            }
        }
    }
}
