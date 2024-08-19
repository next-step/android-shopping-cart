package nextstep.shoppingcart.ui.view.product.detail

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import nextstep.shoppingcart.ui.base.BaseComposeActivity
import nextstep.shoppingcart.ui.extension.getExtra
import nextstep.shoppingcart.ui.model.Product

class ProductDetailActivity : BaseComposeActivity() {

    private val product: Product? by lazy {
        intent.getExtra<Product>(EXTRA_PRODUCT)
    }

    override val content: @Composable () -> Unit = {
        ProductDetailScreen(product = product)
    }

    companion object {
        const val EXTRA_PRODUCT = "product"

        fun newIntent(context: Context, product: Product): Intent {
            return Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(EXTRA_PRODUCT, product)
            }
        }
    }
}
