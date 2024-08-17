package nextstep.shoppingcart.ui.product.list.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import nextstep.shoppingcart.ui.product.list.ProductListRoute

const val PRODUCT_LIST_ROUTE = "product_list"

fun NavGraphBuilder.productListScreen(
    onCartClick: () -> Unit,
    onProductDetailClick: (Long) -> Unit,
) {
    composable(
        route = PRODUCT_LIST_ROUTE,
        content = {
            ProductListRoute(
                onCartClick = onCartClick,
                onProductDetailClick = onProductDetailClick,
            )
        },
    )
}
