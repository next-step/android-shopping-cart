package nextstep.shoppingcart.ui.product.list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.product.list.ProductListRoute

const val PRODUCT_LIST_ROUTE = "product_list"

fun NavGraphBuilder.productListScreen(navController: NavHostController) {
    composable(
        route = PRODUCT_LIST_ROUTE,
        content = {
            ProductListRoute(
                navController = navController,
            )
        },
    )
}
