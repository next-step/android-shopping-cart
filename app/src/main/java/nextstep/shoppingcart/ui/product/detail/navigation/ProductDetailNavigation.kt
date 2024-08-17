package nextstep.shoppingcart.ui.product.detail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.ui.product.detail.ProductDetailRoute

const val PRODUCT_DETAIL_ID = "productId"
const val PRODUCT_DETAIL_ROUTE = "product_detail/{$PRODUCT_DETAIL_ID}"

fun NavHostController.navigateToProductDetail(productId: Long) {
    navigate(PRODUCT_DETAIL_ROUTE.replace("{$PRODUCT_DETAIL_ID}", productId.toString()))
}

fun NavGraphBuilder.productDetailScreen(
    onCartClick: () -> Unit,
    onNavigateUp: () -> Unit,
) {
    composable(
        route = PRODUCT_DETAIL_ROUTE,
        arguments =
            listOf(
                navArgument(PRODUCT_DETAIL_ID) {
                    type = NavType.LongType
                },
            ),
        content = { navBackStackEntry ->
            navBackStackEntry
                .arguments
                ?.getLong(PRODUCT_DETAIL_ID)
                ?.let { productId ->
                    ProductDetailRoute(
                        productId = productId,
                        onCartClick = onCartClick,
                        onNavigateUp = onNavigateUp,
                    )
                }
        },
    )
}
