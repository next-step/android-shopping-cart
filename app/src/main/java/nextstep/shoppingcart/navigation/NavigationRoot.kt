package nextstep.shoppingcart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.product_detail.ProductDetailScreen
import nextstep.shoppingcart.ui.product_list.ProductListScreen

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        startDestination = "product",
        navController = navController,
    ) {
        productGraph(navController)
    }
}

private fun NavGraphBuilder.productGraph(navController: NavController) {
    navigation(
        startDestination = "product_list",
        route = "product"
    ) {
        composable(route = "product_list") {
            ProductListScreen()
        }

        composable(route = "product_detail") {
            ProductDetailScreen(
                product = Product("", "", 0)
            )
        }
    }
}
