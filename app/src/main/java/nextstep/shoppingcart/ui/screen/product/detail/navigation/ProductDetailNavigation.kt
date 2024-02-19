package nextstep.shoppingcart.ui.screen.product.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.ui.screen.product.detail.ProductDetailScreen

const val ProductDetailNavigationRoute = "product_detail"
private const val NAV_ARG_PRODUCT_DETAIL = "nav_arg_product_detail"

fun NavGraphBuilder.productDetailScreen(
    onClickBack: () -> Unit
) {
    composable(
        route = "$ProductDetailNavigationRoute/{${NAV_ARG_PRODUCT_DETAIL}}",
        arguments = listOf(
            navArgument(NAV_ARG_PRODUCT_DETAIL) {
                type = NavType.StringType
            }
        )
    ) { navBackStackEntry ->
        ProductDetailScreen(
            productId = navBackStackEntry.arguments?.getString(NAV_ARG_PRODUCT_DETAIL)
                ?.toLong()
                ?: Long.MAX_VALUE,
            onClickBack = onClickBack
        )
    }
}

fun NavController.navigateToDetail(productId: Long) {
    navigate(route = "$ProductDetailNavigationRoute/$productId")
}
