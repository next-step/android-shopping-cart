package nextstep.shoppingcart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.enums.ScreenRouteType
import nextstep.shoppingcart.screen.ProductListScreen


/**
 * navigation productlist composable 구성용 확장 함수
**/
fun NavGraphBuilder.productListScreen(
    onProductItemClicked:(clickedProductId: Int) -> Unit,
    onShoppingCartIconClicked: () -> Unit,
){
    composable(route = ScreenRouteType.SHOPPING_ITEM_LIST.navRoute) {
        ProductListScreen(
            onProductItemClicked = { clickedProductId ->
                onProductItemClicked(clickedProductId)
            },
            onShoppingCartIconClicked = {
                onShoppingCartIconClicked()
            }
        )
    }
}
