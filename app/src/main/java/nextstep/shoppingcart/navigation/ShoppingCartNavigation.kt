package nextstep.shoppingcart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import nextstep.shoppingcart.enums.ScreenRouteType
import nextstep.shoppingcart.screen.ShoppingCartRoute

/**
 * 장바구니 화면으로 이동
 */
fun NavHostController.navigateToShoppingCart() {
    navigate(route = ScreenRouteType.SHOPPING_CART.navRoute)
}

/**
 * Shopping Cart Navigation
 **/
fun NavGraphBuilder.shoppingCartScreen(
    toolbarBackBtnClicked: () -> Unit,
) {
    composable(
        route = ScreenRouteType.SHOPPING_CART.navRoute
    ) {
        ShoppingCartRoute(
            toolbarBackBtnClicked = {
                toolbarBackBtnClicked()
            }
        )
    }
}
