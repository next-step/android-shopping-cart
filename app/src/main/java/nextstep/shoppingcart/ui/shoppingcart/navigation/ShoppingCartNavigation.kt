package nextstep.shoppingcart.ui.shoppingcart.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.shoppingcart.ShoppingCartScreen
import nextstep.shoppingcart.ui.shoppingdetail.navigation.ShoppingDetailRoute.ROUTE

fun NavGraphBuilder.shoppingCartScreen(
) {
    composable(route = ROUTE) {
        ShoppingCartScreen()
    }
}

fun NavController.navigateToShoppingCart() {
    navigate(ROUTE)
}

object ShoppingCartRoute {
    const val ROUTE = "ShoppingCartScreen"
}
