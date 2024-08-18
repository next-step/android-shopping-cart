package nextstep.shoppingcart.ui.shopping.productdetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.navigation.ShoppingRoute
import nextstep.shoppingcart.ui.shopping.productdetail.ProductDetailScreen


fun NavController.navigateToProductDetailScreen(productId: Int) {
    val route = ShoppingRoute.PRODUCT_DETAIL.replace("{id}", productId.toString())
    navigate(route)
}

fun NavGraphBuilder.productDetail(
    onClickNavigateBack: () -> Unit,
    onClickCartButton: () -> Unit
) {
    composable(
        route = ShoppingRoute.PRODUCT_DETAIL,
        arguments = listOf(
            navArgument("id") { type = NavType.IntType },
        )
    ) { backStackEntry ->
        val productId = backStackEntry.arguments?.getInt("id") ?: -1

        if (productId != -1) {
            ProductDetailScreen(
                productId = productId,
                onClickNavigateBack = onClickNavigateBack,
                onClickCartButton = onClickCartButton
            )
        }
    }
}
