package nextstep.shoppingcart.detail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.cart.Cart
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.getProductById
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = intent.getStringExtra(KEY_PRODUCT_ID) ?: ""

        setContent {
            ShoppingCartTheme {
                ProductDetailScreen(
                    product = getProductById(id),
                    onButtonClick = {
                        Cart.addOne(it)
                        startActivity(Intent(this, CartActivity::class.java))
                    },
                    onBackPressed = { finish() }
                )
            }
        }
    }

    companion object {
        const val KEY_PRODUCT_ID = "product_id"
    }
}