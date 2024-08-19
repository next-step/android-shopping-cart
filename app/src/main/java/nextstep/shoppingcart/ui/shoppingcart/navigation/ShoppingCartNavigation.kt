package nextstep.shoppingcart.ui.shoppingcart.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.shoppingcart.ShoppingCartScreen
import nextstep.shoppingcart.ui.shoppingcart.navigation.ShoppingCartRoute.ROUTE

fun NavGraphBuilder.shoppingCartScreen() {
    composable(route = ROUTE) {
        ShoppingCartScreen()
    }
}

fun NavController.navigateToShoppingCart() {
    navigate(route = ROUTE)
}

object ShoppingCartRoute {
    const val ROUTE = "ShoppingCartScreen"
}
