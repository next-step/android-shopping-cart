package nextstep.shoppingcart.ui.shoppingdetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.ui.shoppingdetail.ShoppingDetailScreen
import nextstep.shoppingcart.ui.shoppingdetail.navigation.ShoppingDetailRoute.ROUTE

fun NavGraphBuilder.shoppingDetailScreen(
    onBackClick: () -> Unit,
    onAddClick: () -> Unit,
) {
    composable(
        route = "${ROUTE}/{productId}",
        arguments = listOf(
            navArgument(name = "productId") { type = NavType.LongType },
        ),
    ) {
        val productId = it.arguments?.getLong("productId", -1) ?: -1

        ShoppingDetailScreen(
            productId = productId,
            onBackClick = onBackClick,
            onAddClick = onAddClick,
        )
    }
}

fun NavController.navigateToShoppingDetail(productId: Long) {
    navigate(route = "${ROUTE}/$productId")
}

object ShoppingDetailRoute {
    const val ROUTE = "ShoppingDetailScreen"
}
