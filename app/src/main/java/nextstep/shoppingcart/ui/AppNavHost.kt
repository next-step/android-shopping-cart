package nextstep.shoppingcart.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.navigation.Navigation
import nextstep.shoppingcart.ui.cart.CartScreen
import nextstep.shoppingcart.ui.product.detail.ProductDetailScreen
import nextstep.shoppingcart.ui.product.list.ProductListScreen

internal const val PRODUCT_ID_ARG = "productId"

@Composable
internal fun AppNavHost(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Navigation.ProductList.route,
    ) {
        composable(Navigation.ProductList.route) {
            ProductListScreen(
                onCartClick = {
                    navHostController.navigate(Navigation.Cart.route)
                },
                onProductItemClick = { productId ->
                    navHostController.navigate(
                        route = "${Navigation.ProductDetail.route}/${productId.id}"
                    )
                },
            )
        }
        composable(
            route = "${Navigation.ProductDetail.route}/{$PRODUCT_ID_ARG}",
            arguments = listOf(
                navArgument(PRODUCT_ID_ARG) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString(PRODUCT_ID_ARG)
            ProductDetailScreen(
                productId = checkNotNull(productId),
                onBackClick = { navHostController.popBackStack() },
            )
        }
        composable(Navigation.Cart.route) {
            CartScreen(navHostController)
        }
    }
}
