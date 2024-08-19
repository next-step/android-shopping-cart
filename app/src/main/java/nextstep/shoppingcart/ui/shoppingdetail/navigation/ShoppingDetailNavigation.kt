package nextstep.shoppingcart.ui.shoppingdetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.ui.shoppingdetail.ShoppingDetailScreen
import nextstep.shoppingcart.ui.shoppingdetail.navigation.ShoppingDetailRoute.ROUTE

fun NavGraphBuilder.shoppingDetailScreen() {
    composable(
        route = "${ROUTE}/{productId}",
        arguments = listOf(
            navArgument("productId") { type = NavType.LongType },
        ),
    ) {
        val productId = it.arguments?.getLong("productId", -1) ?: -1
        ShoppingDetailScreen(productId = productId)
    }
}

fun NavController.navigateToShoppingDetail(productId: Long) {
    navigate("${ROUTE}/$productId")
}

object ShoppingDetailRoute {
    const val ROUTE = "ShoppingDetailScreen"
}
