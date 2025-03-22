package nextstep.shoppingcart

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.ui.shoppinglist.ShoppingListScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ShoppingListScreen(
                    onItemClick = { product ->
                        startActivity(Intent(this, ProductDetailActivity::class.java).apply {
                            putExtra("product", product)
                        })
                    },
                    onShoppingCartClick = {
                        startActivity(Intent(this, ShoppingCartActivity::class.java))
                    }
                )
            }
        }
    }
}