package nextstep.shoppingcart.ui.detail

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import nextstep.shoppingcart.base.BaseComponentActivity
import nextstep.shoppingcart.data.mockProducts
import nextstep.shoppingcart.model.Product

class ProductDetailActivity : BaseComponentActivity() {

    private val getProduct: Product by lazy {
        mockProducts.firstOrNull { it.id == intent.getIntExtra(KEY_PRODUCT_ID, -1) }
            ?: throw IllegalArgumentException("productId is required")
    }

    override val rootComponent: @Composable () -> Unit
        get() = {
            ProductDetailScreen(
                item = getProduct,
                onBack = { onBackPressedDispatcher.onBackPressed() }
            )
        }

    companion object {
        private const val KEY_PRODUCT_ID = "key_product_id"

        fun newInstance(context: Context, item: Product): Intent {
            return Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(KEY_PRODUCT_ID, item.id)
            }
        }
    }
}