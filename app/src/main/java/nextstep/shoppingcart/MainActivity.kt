package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.catalog.CatalogRoute
import nextstep.shoppingcart.detail.DetailActivity
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                CatalogRoute(
                    navigateToDetail = { startDetailActivity() },
                    navigateToCart = { startCartActivity() },
                )
            }
        }
    }

    private fun startDetailActivity() {
        startActivity(DetailActivity.newIntent(this))
    }

    private fun startCartActivity() {
        startActivity(CartActivity.newIntent(this))
    }
}