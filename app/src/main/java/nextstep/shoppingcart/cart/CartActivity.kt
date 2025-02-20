package nextstep.shoppingcart.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.cart.data.Cart
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                CartScreen(
                    currentCartItems = Cart.items,
                    popBackStack = { finish() },
                    deleteItem = { Cart.removeAll(it.product) },
                    increaseItemCount = { Cart.addOne(it.product) },
                )
            }
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, CartActivity::class.java)
    }
}
