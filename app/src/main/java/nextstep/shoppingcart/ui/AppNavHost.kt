package nextstep.shoppingcart.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import nextstep.shoppingcart.ui.shoppinglist.navigation.ShoppingListRoute

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = ShoppingListRoute.ROUTE,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
    }
}
