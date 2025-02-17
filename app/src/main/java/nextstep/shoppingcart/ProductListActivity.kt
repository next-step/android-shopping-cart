package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.model.toProductWithCartCount
import nextstep.shoppingcart.ui.ProductListScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                val updatedTime by remember { Cart.updateTime }
                val items by remember(updatedTime) { mutableStateOf(dummyProducts.toProductWithCartCount()) }

                ProductListScreen(items)
            }
        }
    }
}
