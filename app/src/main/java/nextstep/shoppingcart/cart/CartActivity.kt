package nextstep.shoppingcart.cart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import nextstep.shoppingcart.model.dummyCartItem
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                CartScreen(
                    totalPrice = Cart.totalPrice,
                    cartItems = Cart.items,
                    onBackPressed = { finish() },
                    onButtonClick = { finish() },
                    onRemoveClick = { Cart.removeAll(it.product) },
                    onPlusClick = { Cart.addOne(it.product)} ,
                    onMinusClick = { Cart.removeOne(it.product)} ,
                )
            }
        }
    }
}
