package nextstep.shoppingcart.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import nextstep.shoppingcart.navigation.Navigation
import nextstep.shoppingcart.ui.cart.CartScreen
import nextstep.shoppingcart.ui.product.detail.ProductDetailScreen
import nextstep.shoppingcart.ui.product.list.ProductListScreen

@Composable
internal fun AppNavHost(
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Navigation.ProductList.route,
    ) {
        composable(Navigation.ProductList.route) {
            ProductListScreen(navHostController)
        }
        composable(Navigation.ProductDetail.route) {
            ProductDetailScreen(navHostController)
        }
        composable(Navigation.Cart.route) {
            CartScreen(navHostController)
        }
    }
}
