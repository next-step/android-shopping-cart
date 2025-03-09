package nextstep.shoppingcart.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import nextstep.shoppingcart.Cart
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingCartTheme {
                val items = remember { mutableStateOf(Cart.items) }
                val totalPrice = remember { mutableIntStateOf(Cart.totalPrice) }

                CartScreen(
                    cartItems = items.value,
                    totalPrice = totalPrice.intValue,
                    onBack = ::finish,
                    onClickItemRemove = {
                        Cart.removeAll(it)
                        items.value = Cart.items
                        totalPrice.intValue = Cart.totalPrice
                    },
                    onChangeItemCount = { id, count ->
                        Cart.changeCount(id, count)
                        items.value = Cart.items
                        totalPrice.intValue = Cart.totalPrice
                    },
                    modifier = Modifier.background(Color.White),
                )
            }
        }
    }

    companion object {
        fun intent(context: Context): Intent {
            return Intent(context, CartActivity::class.java)
        }
    }
}
