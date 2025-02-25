package nextstep.shoppingcart.cart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import nextstep.shoppingcart.cart.model.CartViewModel
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class CartActivity : ComponentActivity() {
    private val viewModel: CartViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingCartTheme {
                CartScreen(
                    onBackButtonClick = { onBackPressedDispatcher.onBackPressed() },
                    viewModel = viewModel
                )
            }
        }
    }
}
