package nextstep.shoppingcart.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nextstep.shoppingcart.Cart
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.common.Products
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productId = intent.getIntExtra(PRODUCT_ID, DEFAULT_ID)
        if (productId == DEFAULT_ID) finish()

        enableEdgeToEdge()
        setContent {
            ShoppingCartTheme {
                ProductDetailScreen(
                    product = Products.items[productId],
                    onBack = ::finish,
                    onClickBottomButton = {
                        Cart.addOne(productId)
                        startActivity(CartActivity.intent(this))
                    }
                )
            }
        }
    }

    companion object {
        private const val PRODUCT_ID = "productId"
        private const val DEFAULT_ID = -1
        fun intent(context: Context, productId: Int): Intent {
            return Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(PRODUCT_ID, productId)
            }
        }
    }
}
