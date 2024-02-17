package nextstep.shoppingcart

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import nextstep.shoppingcart.cart.CartScreen
import nextstep.shoppingcart.products.ProductItemUiState
import nextstep.shoppingcart.products.ProductsScreen
import nextstep.shoppingcart.products.StubProductItemUiStates
import nextstep.shoppingcart.products.detail.ProductDetailScreen

sealed class NavigationItem(val route: String) {

    data object Products : NavigationItem("Products")
    data object ProductDetail : NavigationItem("ProductDetail")
    data object Cart : NavigationItem("Cart")
}

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    startDestination: String = NavigationItem.Products.route,
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        composable(NavigationItem.Products.route) {
            ProductsScreen(
                navHostController = navHostController,
                productItemUiStates = StubProductItemUiStates,
            )
        }

        composable(NavigationItem.ProductDetail.route) {
            val productItemUiState = navHostController.previousBackStackEntry?.savedStateHandle
                ?.get<ProductItemUiState>(ProductItemUiState::class.java.name)
                ?: return@composable

            ProductDetailScreen(
                navController = navHostController,
                productItemUiState = productItemUiState,
                onPutInCartButtonClick = {},
            )
        }

        composable(NavigationItem.Cart.route) {
            CartScreen(navHostController)
        }
    }
}
