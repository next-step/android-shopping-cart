package nextstep.shoppingcart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.shopping.model.Product
import nextstep.shoppingcart.ui.shopping.productlist.ProductListScreen


fun NavGraphBuilder.productList(
    onClickItem: (Product) -> Unit,
    onClickShoppingCart: () -> Unit
) {
    composable(ShoppingRoute.PRODUCT_LIST) {
        ProductListScreen(
            onClickItem = onClickItem,
            onClickShoppingCart = onClickShoppingCart
        )
    }
}
