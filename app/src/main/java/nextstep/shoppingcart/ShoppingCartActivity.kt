package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.ui.shoppingcart.ShoppingCartScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ShoppingCartActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShoppingCartTheme {
                ShoppingCartScreen(
                    onBackClick = { finish() },
                    onItemAdd = { product -> Cart.addOne(product) },
                    onItemRemove = { product -> Cart.removeOne(product) },
                    onDelete = { product -> Cart.removeAll(product) }
                )
            }
        }
    }
}