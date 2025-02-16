package nextstep.shoppingcart.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductCartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingCartTheme {
                ProductCartScreen(
                    onBackButtonClick = {
                        onBackPressedDispatcher.onBackPressed()
                    }
                )
            }
        }
    }

    companion object {
        fun open(activity: Activity) {
            val intent = Intent(activity, ProductCartActivity::class.java)
            activity.startActivity(intent)
        }
    }
}
