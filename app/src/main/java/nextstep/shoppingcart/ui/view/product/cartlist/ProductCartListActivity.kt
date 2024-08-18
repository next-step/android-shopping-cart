package nextstep.shoppingcart.ui.view.product.cartlist

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import nextstep.shoppingcart.ui.base.BaseComposeActivity

class ProductCartListActivity : BaseComposeActivity() {

    override val content: @Composable () -> Unit = {
        ProductCartListScreen()
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ProductCartListActivity::class.java)
        }
    }
}
