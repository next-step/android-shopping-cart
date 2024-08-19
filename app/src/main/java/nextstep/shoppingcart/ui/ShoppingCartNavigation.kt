package nextstep.shoppingcart.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import nextstep.shoppingcart.data.cart.Cart
import nextstep.shoppingcart.data.goods.Product
import nextstep.shoppingcart.data.goods.impl.ProductRepositoryImpl
import nextstep.shoppingcart.ui.cart.ShoppingCart
import nextstep.shoppingcart.ui.detail.ProductDetail
import nextstep.shoppingcart.ui.home.ProductList
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

object ShoppingCartDestinations {
    const val HOME_ROUTE = "home"
    const val DETAIL_ROUTE = "detail"
    const val SHOPPING_CART = "shoppingCart"
}

@Composable
fun ShoppingCardNavigation() {
    val repository = ProductRepositoryImpl()
    val products: List<Product> = repository.getProducts()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ShoppingCartDestinations.HOME_ROUTE) {
        composable(route = ShoppingCartDestinations.HOME_ROUTE) {
            ProductList(navController = navController, products = products)
        }
        composable(
            route = ShoppingCartDestinations.DETAIL_ROUTE + "/{productId}",
            arguments = listOf(navArgument("productId") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: -1
            ProductDetail(navController = navController, productId)
        }
        composable(route = ShoppingCartDestinations.SHOPPING_CART) {
            ShoppingCart(navController = navController)
        }
    }

}



@Preview
@Composable
private fun ShoppingCardNavigationPreview() {
    ShoppingCartTheme {
        ShoppingCardNavigation()
    }
}

