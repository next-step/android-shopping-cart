package nextstep.shoppingcart.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.ui.cart.navigation.cartScreen
import nextstep.shoppingcart.ui.product.detail.navigation.productDetailScreen
import nextstep.shoppingcart.ui.product.list.navigation.PRODUCT_LIST_ROUTE
import nextstep.shoppingcart.ui.product.list.navigation.productListScreen

@Composable
internal fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = PRODUCT_LIST_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        productListScreen(
            navController = navController,
        )
        productDetailScreen(
            navController = navController,
        )
        cartScreen(
            navController = navController,
        )
    }
}
