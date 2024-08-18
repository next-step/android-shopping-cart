package nextstep.shoppingcart.ui.shopping.productlist.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.navigation.ShoppingRoute
import nextstep.shoppingcart.ui.shopping.productlist.ProductListScreen


fun NavGraphBuilder.productList(
    onClickItem: (Int) -> Unit,
    onClickShoppingCart: () -> Unit
) {
    composable(ShoppingRoute.PRODUCT_LIST) {
        ProductListScreen(
            onClickItem = onClickItem,
            onClickShoppingCart = onClickShoppingCart
        )
    }
}
