package nextstep.shoppingcart

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import nextstep.shoppingcart.products.ProductsScreen
import nextstep.shoppingcart.products.StubProductItemUiStates
import nextstep.shoppingcart.products.detail.ProductDetailScreen

sealed class NavigationItem(val route: String) {

    data object Products : NavigationItem("Products")
    data object ProductDetail : NavigationItem("ProductDetail")
    data object Cart : NavigationItem("Cart")
}

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    startDestination: String = NavigationItem.Products.route,
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
    ) {
        composable(NavigationItem.Products.route) {
            ProductsScreen(
                navHostController = navHostController,
                productItemUiStates = StubProductItemUiStates,
            )
        }

        composable(NavigationItem.ProductDetail.route) {
            ProductDetailScreen(
                navController = navHostController,
                productItemUiState = StubProductItemUiStates[0],
                onPutInCartButtonClick = {},
            )
        }

        composable(NavigationItem.Cart.route) {
            CartScreen(navHostController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "장바구니") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로가기"
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        Text(
            text = "CartScreen",
            modifier = Modifier.padding(innerPadding)
        )
    }
}
