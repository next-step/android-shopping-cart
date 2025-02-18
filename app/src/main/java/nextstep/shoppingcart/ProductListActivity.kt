package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.ui.screen.ProductListScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.Exe

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductListScreen(
                    onCartClick = { Exe.cart(this) },
                    onProductClick = { Exe.productDetail(this, it) }
                )
            }
        }
    }
}
