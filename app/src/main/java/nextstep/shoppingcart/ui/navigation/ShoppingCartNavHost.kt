package nextstep.shoppingcart.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun ShoppingCartNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PRODUCTS_ROUTE,
        modifier = modifier
    ) {
        productsScreen(
            onCartClick = { navController.navigateToShoppingCart() },
            onItemClick = { productId -> navController.navigateToProductDetail(productId) }
        )

        productDetailScreen(
            onCartClick = { navController.navigateToShoppingCart() },
            onNavigationClick = { navController.navigateUp() }
        )

        shoppingCartScreen(
            onNavigationClick = { navController.navigateUp() }
        )
    }
}
