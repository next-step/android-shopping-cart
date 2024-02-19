package nextstep.shoppingcart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.ui.screen.cart.navigation.cartScreen
import nextstep.shoppingcart.ui.screen.cart.navigation.navigateToCart
import nextstep.shoppingcart.ui.screen.product.detail.navigation.navigateToDetail
import nextstep.shoppingcart.ui.screen.product.detail.navigation.productDetailScreen
import nextstep.shoppingcart.ui.screen.product.list.navigation.ProductListNavigationRoute
import nextstep.shoppingcart.ui.screen.product.list.navigation.productListScreen

@Composable
fun ShoppingCartNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDirections: String = ProductListNavigationRoute
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDirections
    ) {
        productListScreen(
            onClickCart = navController::navigateToCart,
            onClickDetail = navController::navigateToDetail
        )
        productDetailScreen(onClickBack = navController::popBackStack)
        cartScreen(onClickBack = navController::popBackStack)
    }
}
