package nextstep.shoppingcart.ui.screen.product.list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.screen.cart.CartBox
import nextstep.shoppingcart.ui.screen.product.list.ProductListScreen

const val ProductListNavigationRoute = "product_list"

fun NavGraphBuilder.productListScreen(
    onClickCart: () -> Unit,
    onClickDetail: (Long) -> Unit
) {
    composable(route = ProductListNavigationRoute) {
        ProductListScreen(
            cart = CartBox.value,
            onClickCart = onClickCart,
            onClickDetail = onClickDetail
        )
    }
}
