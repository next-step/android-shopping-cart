package nextstep.shoppingcart

import androidx.compose.runtime.Composable
import nextstep.shoppingcart.base.BaseComponentActivity
import nextstep.shoppingcart.data.mockProducts
import nextstep.shoppingcart.navigation.RouteType
import nextstep.shoppingcart.ui.cart.CartActivity
import nextstep.shoppingcart.ui.detail.ProductDetailActivity
import nextstep.shoppingcart.ui.list.ProductListScreen

class MainActivity : BaseComponentActivity() {

    override val rootComponent: @Composable () -> Unit
        get() = {
            ProductListScreen(
                productList = mockProducts,
                onRoute = { type ->
                    when (type) {
                        RouteType.ToCart -> {
                            startActivity(CartActivity.newInstance(context = this))
                        }
                        is RouteType.ToDetail -> {
                            startActivity(ProductDetailActivity.newInstance(this, type.item))
                        }
                    }
                },
            )
        }
}
