package nextstep.shoppingcart.ui.screen.product.list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.screen.product.list.ProductListScreen

const val ProductListNavigationRoute = "product_list"

fun NavGraphBuilder.productListScreen() {
    composable(route = ProductListNavigationRoute) {
        ProductListScreen()
    }
}
