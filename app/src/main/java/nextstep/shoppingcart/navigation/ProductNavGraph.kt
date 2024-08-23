package nextstep.shoppingcart.navigation

import android.os.Build
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import nextstep.shoppingcart.MainScreen
import nextstep.shoppingcart.ProductDetailScreen
import nextstep.shoppingcart.ShoppingCartScreen
import nextstep.shoppingcart.model.Product

fun NavController.navigate(
    route: String,
    args: Bundle,
    navOptions: NavOptions? = null,
    navigatorExtras: Navigator.Extras? = null
) {
    val nodeId = graph.findNode(route = route)?.id
    if (nodeId != null) {
        navigate(nodeId, args, navOptions, navigatorExtras)
    }
}

@Composable
fun ProductNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {

        composable(
            route = "main"
        ) {
            MainScreen(
                onItemClick = { product ->
                    navController.navigate(
                        route = "productDetail",
                        args = bundleOf("product" to product)
                    )
                },
                onCartClick = { navController.navigate("shoppingCart") }
            )
        }
        composable(route = "productDetail") { backStackEntry ->
            val product = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                backStackEntry.arguments?.getParcelable("product", Product::class.java)
            } else {
                backStackEntry.arguments?.getParcelable("product")
            }
            if (product != null) {
                ProductDetailScreen(
                    product = product,
                    onBackClick = { navController.navigateUp() },
                    onCartClick = { navController.navigate("shoppingCart") }
                )
            }
        }
        composable(
            route = "shoppingCart"
        ) {
            ShoppingCartScreen(
                onBackClick = { navController.navigateUp() }
            )
        }
    }

}