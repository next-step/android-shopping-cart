package nextstep.shoppingcart.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import nextstep.shoppingcart.ui.shoppingcart.navigation.navigateToShoppingCart
import nextstep.shoppingcart.ui.shoppingcart.navigation.shoppingCartScreen
import nextstep.shoppingcart.ui.shoppingdetail.navigation.navigateToShoppingDetail
import nextstep.shoppingcart.ui.shoppingdetail.navigation.shoppingDetailScreen
import nextstep.shoppingcart.ui.shoppinglist.navigation.ShoppingListDestination
import nextstep.shoppingcart.ui.shoppinglist.navigation.shoppingListScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = ShoppingListDestination.ROUTE,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        shoppingListScreen(
            onShoppingCartClick = navController::navigateToShoppingCart,
            onItemClick = navController::navigateToShoppingDetail,
        )
        shoppingCartScreen(onBackClick = navController::popBackStack)
        shoppingDetailScreen(
            onBackClick = navController::popBackStack,
            onAddClick = navController::navigateToShoppingCart,
        )
    }
}
