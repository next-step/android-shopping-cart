package nextstep.shoppingcart.ui.cart

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import nextstep.shoppingcart.base.BaseComponentActivity

class CartActivity : BaseComponentActivity() {

    override val rootComponent: @Composable () -> Unit
        get() = {
            CartScreen(onBack = { onBackPressedDispatcher.onBackPressed() })
        }

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, CartActivity::class.java)
        }
    }
}