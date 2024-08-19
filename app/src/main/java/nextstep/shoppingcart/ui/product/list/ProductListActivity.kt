package nextstep.shoppingcart.ui.product.list

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.ui.cart.ShoppingCartActivity
import nextstep.shoppingcart.ui.product.detail.ProductDetailActivity
import nextstep.shoppingcart.ui.product.detail.ProductDetailActivity.Companion.EXTRA_PRODUCT
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductListScreen(
                    onShowShoppingCart = {
                        startActivity(Intent(this, ShoppingCartActivity::class.java))
                    },
                    onShowProductDetail = {
                        startActivity(Intent(this, ProductDetailActivity::class.java).apply {
                            putExtra(EXTRA_PRODUCT, it)
                        })
                    },
                )
            }
        }
    }
}
