package nextstep.shoppingcart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.enums.ScreenRouteType
import nextstep.shoppingcart.screen.ShoppingCartScreen

/**
 * Shopping Cart Navigation
 **/
fun NavGraphBuilder.shoppingCartScreen(
    toolbarBackBtnClicked: () -> Unit,
) {
    composable(
        route = ScreenRouteType.SHOPPING_CART.navRoute
    ) {
        ShoppingCartScreen(
            toolbarBackBtnClicked = {
                toolbarBackBtnClicked()
            }
        )
    }
}
