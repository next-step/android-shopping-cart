package nextstep.shoppingcart.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.cart.cartNavGraph
import nextstep.shoppingcart.cart.navigateCart
import nextstep.shoppingcart.productdetail.navigateProductDetail
import nextstep.shoppingcart.productdetail.productDetailNavGraph
import nextstep.shoppingcart.productlist.ProductListRoute
import nextstep.shoppingcart.productlist.productListNavGraph
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ShoppingCartTheme {
                MainScreen(
                    navController = navController,
                )
            }
        }
    }
}

@Composable
private fun MainScreen(
    navController: NavHostController,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                NavHost(
                    navController = navController,
                    startDestination = ProductListRoute,
                ) {
                    productListNavGraph(
                        onProductClick = { product -> navController.navigateProductDetail(product) },
                        onCartClick = { navController.navigateCart() },
                    )

                    productDetailNavGraph(
                        onAddToCartClick = {},
                        onBackClick = { navController.popBackStack() }
                    )

                    cartNavGraph(onBackClick = { navController.popBackStack() })
                }
            }
        }
    )
}