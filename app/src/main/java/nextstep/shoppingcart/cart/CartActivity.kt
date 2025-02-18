package nextstep.shoppingcart.cart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.model.dummyCartItem
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                CartScreen(
                    cartItems = listOf(dummyCartItem),
                    onBackPressed = { finish() },
                    onButtonClick = { finish() },
                )
            }
        }
    }
}
