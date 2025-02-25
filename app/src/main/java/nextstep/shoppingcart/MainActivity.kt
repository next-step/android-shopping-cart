package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.cart.data.CartDataSourceImpl
import nextstep.shoppingcart.catalog.CatalogScreen
import nextstep.shoppingcart.detail.DetailActivity
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.DataUtil.getProducts

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                var products by remember { mutableStateOf(listOf<Product>()) }

                LaunchedEffect(Unit) {
                    products = getProducts()
                }

                CatalogScreen(
                    products = products,
                    cartDataSource = CartDataSourceImpl,
                    navigateToDetail = { startDetailActivity(it) },
                    navigateToCart = { startCartActivity() },
                )
            }
        }
    }

    private fun startDetailActivity(product: Product) {
        startActivity(DetailActivity.newIntent(this, product))
    }

    private fun startCartActivity() {
        startActivity(CartActivity.newIntent(this))
    }
}