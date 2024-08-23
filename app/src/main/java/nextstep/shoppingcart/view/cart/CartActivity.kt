package nextstep.shoppingcart.view.cart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShoppingCartTheme {
                CartScreen(Cart.items) {
                    finish()
                }
            }
        }
    }
}
