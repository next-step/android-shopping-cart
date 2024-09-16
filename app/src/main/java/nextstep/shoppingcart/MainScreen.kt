package nextstep.shoppingcart

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.enums.ScreenRouteType
import nextstep.shoppingcart.navigation.productDetailScreen
import nextstep.shoppingcart.navigation.productListScreen
import nextstep.shoppingcart.navigation.shoppingCartScreen
import nextstep.shoppingcart.screen.ShoppingCartScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme


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
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        // 상품 리스트 화면
        productListScreen(
            onShoppingCartIconClicked = {
                navHostController.navigate(
                    route = ScreenRouteType.SHOPPING_CART.navRoute
                )
            },
            onProductItemClicked = { clickedProductId ->
                navHostController.navigate(
                    route = ScreenRouteType.PRODUCT_DETAIL.navRoute + "?productId=$clickedProductId"
                )
            }
        )
        // 상품 상세 화면
        productDetailScreen(
            addCartButtonClicked = {
                navHostController.navigate(
                    route = ScreenRouteType.SHOPPING_CART.navRoute
                )
            },
            toolbarBackBtnClicked = {
                navHostController.popBackStack()
            }
        )
        // 쇼핑카트 화면
        shoppingCartScreen(
            toolbarBackBtnClicked = {
                navHostController.popBackStack()
            }
        )
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

