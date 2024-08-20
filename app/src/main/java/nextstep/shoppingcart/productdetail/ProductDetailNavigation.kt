package nextstep.shoppingcart.productdetail

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import nextstep.shoppingcart.common.model.Cart
import nextstep.shoppingcart.common.model.Product

internal fun NavController.navigateProductDetail(product: Product) {
    navigate(route = ProductDetailRoute(product))
}

internal fun NavGraphBuilder.productDetailNavGraph(
    onBackClick: () -> Unit,
) {
    composable<ProductDetailRoute>(
        typeMap = ProductDetailRoute.typeMap
    ) { navBackStackEntry ->
        val product = navBackStackEntry.toRoute<ProductDetailRoute>().product
        ProductDetailScreen(
            product = product,
            onAddToCartClick = { Cart.addOne(product) },
            onBackClick = onBackClick,
        )
    }
}