package nextstep.shoppingcart

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import nextstep.shoppingcart.enums.ScreenRouteType
import nextstep.shoppingcart.screen.ProductDetailScreen
import nextstep.shoppingcart.screen.ShoppingCartScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

/**
 * 상품 id가 에러가 있는 경우 -1로 처리
**/
const val ERROR_PRODUCT_ID = -1

/**
 * Create Date: 2024. 9. 2.
 *
 * 장바구니 앱 - 화면 이동 처리를 위한 메인 화면
 * navhost 구성
 * @author LeeDongHun
 *
 *
 **/
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    val navHostController = rememberNavController()
    NavHost(
        modifier = modifier.padding(0.dp),
        navController = navHostController,
        startDestination = ScreenRouteType.SHOPPING_ITEM_LIST.navRoute,
        enterTransition = {
            EnterTransition.None
        },
        exitTransition = {
            ExitTransition.None
        }
    ) {
        composable(route = ScreenRouteType.SHOPPING_ITEM_LIST.navRoute) {
            ShoppingCartScreen(
                navigateToManagementScreen = { clickedProductId ->
                    navHostController.navigate(
                        route = ScreenRouteType.PRODUCT_DETAIL.navRoute+"?productId=$clickedProductId"
                    )
                }
            )
        }

        composable(
            route = ScreenRouteType.PRODUCT_DETAIL.navRoute + "?productId={productId}",
            arguments = listOf(navArgument("productId") {
                type = NavType.Companion.IntType; defaultValue = ERROR_PRODUCT_ID
            })
        ) { navBackStackEntry->
            val productId = navBackStackEntry.arguments?.getInt("productId")?:ERROR_PRODUCT_ID
            ProductDetailScreen(
                productId = productId,
                addCartButtonClicked = {
                    // TODO: 장바구니에 상품 추가 기능 구현
                },
                toolbarBackBtnClicked = {
                    navHostController.popBackStack()
                }
            )
        }
    }
}

/**
 * MainScreen 프리뷰 함수
 */
@Preview
@Composable
fun MainScreenPreview() {
    ShoppingCartTheme {
        MainScreen()
    }
}

