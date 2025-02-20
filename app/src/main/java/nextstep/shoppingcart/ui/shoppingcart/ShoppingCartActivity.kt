package nextstep.shoppingcart.ui.shoppingcart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
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

                enableEdgeToEdge()
                ShoppingCartScreen(
                    cartItems = cartItems,
                    onBackButtonClick = ::finish,
                    onAddProductClick = { product: Product ->
                        Cart.addOne(product)
                        cartItems = Cart.items
                    },
                    onRemoveProductClick = { product: Product ->
                        Cart.removeOne(product)
                        cartItems = Cart.items
                    },
                    onRemoveAllProductClick = { product: Product ->
                        Cart.removeAll(product)
                        cartItems = Cart.items
                    },
                )
            }
        }
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, ShoppingCartActivity::class.java)
    }
}
