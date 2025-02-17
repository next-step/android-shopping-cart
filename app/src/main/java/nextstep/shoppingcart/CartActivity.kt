package nextstep.shoppingcart

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
import nextstep.shoppingcart.data.InMemoryCartRepository
import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.repository.CartRepository
import nextstep.shoppingcart.screens.cart.CartScreen

class CartActivity : ComponentActivity() {
    private val cartRepository: CartRepository = InMemoryCartRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()

            var cart: Cart by remember { mutableStateOf(cartRepository.getCart()) }
            CartScreen(
                cart = cart,
                onBackClick = onBackPressedDispatcher::onBackPressed,
                onAddOneClick = { cart = cartRepository.addOne(it) },
                onRemoveOneClick = { cart = cartRepository.removeOne(it) },
                onRemoveAllClick = { cart = cartRepository.removeAll(it) },
            )
        }
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, CartActivity::class.java)
        }
    }
}
