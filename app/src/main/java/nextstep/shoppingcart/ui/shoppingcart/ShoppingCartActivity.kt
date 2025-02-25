package nextstep.shoppingcart.ui.shoppingcart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ShoppingCartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                enableEdgeToEdge()
                ShoppingCartScreen(
                    cartItems = Cart.items,
                    totalPrice = Cart.totalPrice.value,
                    onBackButtonClick = ::finish,
                    onAddProductClick = Cart::addOne,
                    onRemoveProductClick = Cart::removeOne,
                    onRemoveAllProductClick = Cart::removeAll
                )
            }
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, ShoppingCartActivity::class.java)
    }
}
