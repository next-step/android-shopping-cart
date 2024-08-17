package nextstep.shoppingcart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.shopping.productdetail.ProductDetailScreen


fun NavGraphBuilder.productDetail() {
    composable(ShoppingRoute.PRODUCT_DETAIL) {
        ProductDetailScreen()
    }
}
