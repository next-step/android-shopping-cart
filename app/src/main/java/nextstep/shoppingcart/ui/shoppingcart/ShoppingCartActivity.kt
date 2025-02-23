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
                var cartItems by remember { mutableStateOf(Cart.items) }
                var totalPrice by remember { mutableLongStateOf(Cart.totalPrice) }

                fun updateCarts() {
                    cartItems = Cart.items
                    totalPrice = Cart.totalPrice
                }

                enableEdgeToEdge()
                ShoppingCartScreen(
                    cartItems = cartItems,
                    totalPrice = totalPrice,
                    onBackButtonClick = ::finish,
                    onAddProductClick = { product: Product ->
                        Cart.addOne(product)
                        updateCarts()
                    },
                    onRemoveProductClick = { product: Product ->
                        Cart.removeOne(product)
                        updateCarts()
                    },
                    onRemoveAllProductClick = { product: Product ->
                        Cart.removeAll(product)
                        updateCarts()
                    }
                )
            }
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, ShoppingCartActivity::class.java)
    }
}
