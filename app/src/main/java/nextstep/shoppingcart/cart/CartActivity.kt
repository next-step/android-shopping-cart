package nextstep.shoppingcart.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.cart.data.CartDataSourceImpl
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                CartScreen(
                    cartItems = CartDataSourceImpl.items,
                    totalPrice = CartDataSourceImpl.totalPrice,
                    popBackStack = { finish() },
                    deleteItem = { CartDataSourceImpl.removeAll(it.product) },
                    increaseItemCount = { CartDataSourceImpl.addOne(it.product) },
                    decreaseItemCount = { CartDataSourceImpl.removeOne(it.product) },
                )
            }
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, CartActivity::class.java)
    }
}
