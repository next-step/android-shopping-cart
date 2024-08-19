package nextstep.shoppingcart.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.productdetail.ProductDetailScreen

internal fun NavController.navigateProductDetail(product: Product) {
    navigate(route = ProductDetailRoute(product))
}

internal fun NavGraphBuilder.productDetailNavGraph(
    onAddToCartClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    composable<ProductDetailRoute>(
        typeMap = ProductDetailRoute.typeMap
    ) { navBackStackEntry ->
        val product = navBackStackEntry.toRoute<ProductDetailRoute>().product
        ProductDetailScreen(
            product = product,
            onAddToCartClick = onAddToCartClick,
            onBackClick = onBackClick,
        )
    }
}