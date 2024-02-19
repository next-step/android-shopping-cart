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
                    navHostController.navigateToCart()
                },
                onProductItemClick = { productId ->
                    navHostController.navigateToProductDetail(productId.id)
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
                onProductAddClick = {
                    // TODO: 장바구니 담기
                    navHostController.popBackStack()
                }
            )
        }
        composable(Navigation.Cart.route) {
            CartScreen(navHostController)
        }
    }
}

private fun NavHostController.navigateToCart() {
    navigate(Navigation.Cart.route)
}

private fun NavHostController.navigateToProductDetail(productId: String) {
    navigate(route = "${Navigation.ProductDetail.route}/$productId")
}
