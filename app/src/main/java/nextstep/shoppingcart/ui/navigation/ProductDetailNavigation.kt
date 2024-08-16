package nextstep.shoppingcart.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.ui.screen.detail.ProductDetailRoute

const val PRODUCT_DETAIL_ROUTE = "product_detail"
const val PRODUCT_DETAIL_ITEM_ID = "product_id"

fun NavController.navigateToProductDetail(productId: String) {
    navigate("$PRODUCT_DETAIL_ROUTE/$productId")
}

fun NavGraphBuilder.productDetailScreen() {
    composable(
        route = "$PRODUCT_DETAIL_ROUTE/{$PRODUCT_DETAIL_ITEM_ID}",
        arguments = listOf(
            navArgument(PRODUCT_DETAIL_ITEM_ID) {
                type = NavType.StringType
            }
        )
    ) { backStackEntry ->
        val productId = backStackEntry.arguments?.getString(PRODUCT_DETAIL_ITEM_ID)
        if (productId != null) {
            ProductDetailRoute(id = productId)
        }
    }
}
