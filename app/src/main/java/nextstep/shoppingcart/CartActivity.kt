package nextstep.shoppingcart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nextstep.shoppingcart.data.InMemoryCartRepository
import nextstep.shoppingcart.screens.cart.CartScreen

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            enableEdgeToEdge()

            CartScreen(
                cart = InMemoryCartRepository.cart.value,
                onBackClick = onBackPressedDispatcher::onBackPressed,
                onAddOneClick = InMemoryCartRepository::addOne,
                onRemoveOneClick = InMemoryCartRepository::removeOne,
                onRemoveAllClick = InMemoryCartRepository::removeAll,
            )
        }
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, CartActivity::class.java)
        }
    }
}
