package nextstep.shoppingcart.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.ui.feature.CartScreen
import nextstep.shoppingcart.ui.feature.ProductDetailScreen
import nextstep.shoppingcart.ui.feature.ProductListScreenRouter
import nextstep.shoppingcart.ui.navigation.Navigation

internal const val PRODUCT_ID_ARG = "productId"

@Composable
fun AppNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Navigation.ProductList.route
    ) {
        composable(Navigation.ProductList.route) {
            ProductListScreenRouter(
                onCartClick = { navHostController.navigate(Navigation.Cart.route) },
                onProductClick = { productId -> navHostController.navigate("${Navigation.ProductDetail.route}/${productId}") }
            )
        }
        composable(
            route = "${Navigation.ProductDetail.route}/{$PRODUCT_ID_ARG}",
            arguments = listOf(
                navArgument(PRODUCT_ID_ARG) { type = NavType.IntType },
            ),
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt(PRODUCT_ID_ARG) ?: -1
            ProductDetailScreen(
                productId = productId,
                onBackClick = { navHostController.popBackStack() },
                onAddCartClick = {}
            )
        }
        composable(Navigation.Cart.route) {
            CartScreen(onBackClick = { navHostController.popBackStack() })
        }
    }
}
