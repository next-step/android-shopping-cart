package nextstep.shoppingcart.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.feature.CartScreen
import nextstep.shoppingcart.ui.feature.ProductDetailScreen
import nextstep.shoppingcart.ui.feature.ProductListScreen
import nextstep.shoppingcart.ui.navigation.Navigation

@Composable
fun AppNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Navigation.ProductList.route
    ) {
        composable(Navigation.ProductList.route) {
            ProductListScreen(navHostController)
        }
        composable(Navigation.ProductList.route) {
            ProductDetailScreen(navHostController)
        }
        composable(Navigation.ProductList.route) {
            CartScreen(navHostController)
        }
    }
}
