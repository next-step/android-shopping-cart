package nextstep.shoppingcart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import nextstep.shoppingcart.enums.ScreenRouteType
import nextstep.shoppingcart.screen.ProductDetailScreen

/**
 * 상품 id가 에러가 있는 경우 -1로 처리
 **/
const val ERROR_PRODUCT_ID = -1

/**
 * navigation product detail composable 구성용 확장 함수
 **/
fun NavGraphBuilder.productDetailScreen(
    addCartButtonClicked: () -> Unit,
    toolbarBackBtnClicked: () -> Unit,
) {
    composable(
        route = ScreenRouteType.PRODUCT_DETAIL.navRoute + "?productId={productId}",
        arguments = listOf(navArgument("productId") {
            type = NavType.Companion.IntType; defaultValue = ERROR_PRODUCT_ID
        })
    ) { navBackStackEntry ->
        val productId = navBackStackEntry.arguments?.getInt("productId") ?: ERROR_PRODUCT_ID
        ProductDetailScreen(
            productId = productId,
            addCartButtonClicked = {
                addCartButtonClicked()
            },
            toolbarBackBtnClicked = {
                toolbarBackBtnClicked()
            }
        )
    }
}
