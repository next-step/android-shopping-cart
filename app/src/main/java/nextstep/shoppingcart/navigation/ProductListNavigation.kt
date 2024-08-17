package nextstep.shoppingcart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.shopping.productlist.ProductListScreen


fun NavGraphBuilder.productList() {
    composable(ShoppingRoute.PRODUCT_LIST) {
        ProductListScreen()
    }
}