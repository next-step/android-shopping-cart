package nextstep.shoppingcart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun ShoppingNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination : String = SHOPPING_LIST_ROUTE
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ){
        shoppingListScreen(
            onClickCart = {
                navController.navigateToCart()
            },
            onClickDetail = { productId ->
                navController.navigateToDetail(productId)
            }
        )
        shoppingDetailScreen(
            onClickCart = {
                navController.navigateToCart()
            },
            onClickBack = {
                navController.popBackStack()
            }
        )
        shoppingCartScreen(
            onClickBack = {
                navController.popBackStack()
            }
        )
    }
}