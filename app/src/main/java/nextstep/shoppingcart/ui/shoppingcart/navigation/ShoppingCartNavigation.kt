package nextstep.shoppingcart.ui.shoppingcart.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.ui.shoppingcart.ShoppingCartScreen
import nextstep.shoppingcart.ui.shoppingcart.navigation.ShoppingCartRoute.ROUTE

fun NavGraphBuilder.shoppingCartScreen() {
    composable(
        route = "${ROUTE}/{productId}",
        arguments = listOf(
            navArgument(name = "productId") { type = NavType.LongType },
        ),
    ) {
        val productId = it.arguments?.getLong("productId", -1) ?: -1
        ShoppingCartScreen(
            productId = productId,
        )
    }
}

fun NavController.navigateToShoppingCart(productId: Long) {
    navigate(route = "${ROUTE}/$productId")
}

fun NavController.navigateToShoppingCart() {
    navigate(route = ROUTE)
}

object ShoppingCartRoute {
    const val ROUTE = "ShoppingCartScreen"
}
