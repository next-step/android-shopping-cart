package nextstep.shoppingcart.ui.view.product.list

import androidx.compose.runtime.Composable
import nextstep.shoppingcart.ui.base.BaseComposeActivity

class ProductListActivity : BaseComposeActivity() {

    override val content: @Composable () -> Unit = {
        ProductListScreen()
    }
}
