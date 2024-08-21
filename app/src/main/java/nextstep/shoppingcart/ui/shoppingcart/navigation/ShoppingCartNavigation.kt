package nextstep.shoppingcart.ui.shoppingcart.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.shoppingcart.ShoppingCartScreen
import nextstep.shoppingcart.ui.shoppingcart.navigation.ShoppingCartDestination.ROUTE

fun NavGraphBuilder.shoppingCartScreen(
    onBackClick: () -> Unit,
) {
    composable(route = ROUTE) {
        ShoppingCartScreen(onBackClick = onBackClick)
    }
}

fun NavController.navigateToShoppingCart() {
    navigate(route = ROUTE)
}

object ShoppingCartDestination {
    const val ROUTE = "ShoppingCartScreen"
}
