package nextstep.shoppingcart.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.MainScreen
import nextstep.shoppingcart.ProductDetailScreen
import nextstep.shoppingcart.ShoppingCartScreen


@Composable
fun ProductNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {

        composable(
            route = "main"
        ) {
            MainScreen(
                onItemClick = { name, imageUrl, price ->
                    val route = "productDetail/$name/$price?imageUrl=$imageUrl"
                    navController.navigate(route)
                },
                onCartClick = { navController.navigate("shoppingCart") }
            )
        }
        composable(
            route = "productDetail/{name}/{price}?imageUrl={imageUrl}",
            arguments = listOf(
                navArgument("imageUrl") {
                    type = NavType.StringType
                },
                navArgument("price") {
                    type = NavType.LongType
                },
                navArgument("name") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val price = backStackEntry.arguments?.getLong("price")
            val imageUrl = backStackEntry.arguments?.getString("imageUrl")

            if (name != null && price != null && imageUrl != null) {
                ProductDetailScreen(
                    price = price,
                    name = name,
                    imageUrl = imageUrl,
                    onNavigationClick = { navController.navigateUp() },
                    onCartClick = { navController.navigate("shoppingCart") })
            }
        }
        composable(
            route = "shoppingCart"
        ) {
            ShoppingCartScreen(
                onNavigationClick = { navController.navigateUp() }
            )
        }
    }

}