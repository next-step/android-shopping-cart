package nextstep.shoppingcart.cart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingCartTheme {
                CartScreen(
                    onBack = ::finish,
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
