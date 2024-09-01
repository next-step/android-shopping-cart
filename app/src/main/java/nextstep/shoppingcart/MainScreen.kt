package nextstep.shoppingcart

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.enums.ScreenRouteType
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
    navHostController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier.padding(0.dp),
        navController = navHostController,
        startDestination = ScreenRouteType.SHOPPING_CART.navRoute
    ) {
        composable(ScreenRouteType.SHOPPING_CART.navRoute) {
            ShoppingCartScreen()
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

