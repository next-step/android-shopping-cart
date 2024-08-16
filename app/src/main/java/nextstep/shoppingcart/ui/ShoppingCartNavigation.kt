package nextstep.shoppingcart.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.cart.ShoppingCart
import nextstep.shoppingcart.ui.detail.ProductDetail
import nextstep.shoppingcart.ui.home.ProductList

object ShoppingCartDestinations {
    const val HOME_ROUTE = "home"
    const val DETAIL_ROUTE = "detail"
    const val SHOPPING_CART = "shoppingCart"
}

@Composable
fun ShoppingCardNavigation() {
    val products: List<Product> = getProducts()
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
            val product = products.firstOrNull { it.productId == productId } ?: return@composable
            ProductDetail(navController = navController, product)
        }
        composable(route = ShoppingCartDestinations.SHOPPING_CART) {
            ShoppingCart(navController = navController)
        }
    }

}

fun getProducts(): List<Product> {
    return listOf(
        Product(
            productId = 1,
            name = "PET보틀-정사각형",
            price = 10000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            productId = 2,
            name = "PET보틀-밀크티",
            price = 12000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            productId = 3,
            name = "PET보틀-정사각각형",
            price = 10000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            productId = 4,
            name = "PET보틀-납작(200ml)",
            price = 12000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            productId = 5,
            name = "PET보틀-정사각형",
            price = 10000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            productId = 6,
            name = "PET보틀-납작(200ml)",
            price = 12000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            productId = 7,
            name = "PET보틀-정사각형",
            price = 10000,
            imageUrl = "https://picsum.photos/156/158"
        ),
        Product(
            productId = 8,
            name = "PET보틀-납작(200ml)",
            price = 12000,
            imageUrl = "https://picsum.photos/156/158"
        )
    )
}

@Preview
@Composable
private fun ShoppingCardNavigationPreview() {
    ShoppingCardNavigation()
}

