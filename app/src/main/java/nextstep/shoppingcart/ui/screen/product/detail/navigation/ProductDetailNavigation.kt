package nextstep.shoppingcart.ui.screen.product.detail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.screen.product.detail.ProductDetailScreen

const val ProductDetailNavigationRoute = "product_detail"
fun NavGraphBuilder.productDetailScreen(onClickBack: () -> Unit) {
    composable(route = ProductDetailNavigationRoute) {
        ProductDetailScreen(onClickBack = onClickBack)
    }
}
