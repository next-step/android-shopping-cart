package nextstep.shoppingcart.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.screen.products.ProductRoute

const val PRODUCTS_ROUTE = "products"

fun NavGraphBuilder.productsScreen(
    onItemClick: (id: String) -> Unit
) {
    composable(
        route = PRODUCTS_ROUTE,
    ) {
        ProductRoute(onItemClick = onItemClick)
    }
}
