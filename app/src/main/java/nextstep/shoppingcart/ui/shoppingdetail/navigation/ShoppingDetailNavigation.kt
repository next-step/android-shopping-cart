package nextstep.shoppingcart.ui.shoppingdetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.shoppingdetail.ShoppingDetailScreen
import nextstep.shoppingcart.ui.shoppingdetail.navigation.ShoppingDetailRoute.ROUTE

fun NavGraphBuilder.shoppingDetailScreen(
) {
    composable(route = ROUTE) {
        ShoppingDetailScreen()
    }
}

fun NavController.navigateToShoppingDetail(productId: Long) {
    navigate("${ROUTE}/$productId")
}

object ShoppingDetailRoute {
    const val ROUTE = "ShoppingDetailScreen"
}
