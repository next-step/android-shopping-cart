package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.ui.ProductCartScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductCartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductCartScreen(
                    model = Cart.items,
                    onBackButtonClick = {
                        onBackPressedDispatcher.onBackPressed()
                    }
                )
            }
        }
    }
}
