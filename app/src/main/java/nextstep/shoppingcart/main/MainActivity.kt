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
import androidx.navigation.compose.NavHost
import nextstep.shoppingcart.cart.cartNavGraph
import nextstep.shoppingcart.productdetail.productDetailNavGraph
import nextstep.shoppingcart.productlist.ProductListRoute
import nextstep.shoppingcart.productlist.productListNavGraph
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberMainNavigator()
            ShoppingCartTheme {
                MainScreen(
                    mainNavigator = navController,
                )
            }
        }
    }
}

@Composable
private fun MainScreen(
    mainNavigator: MainNavigator,
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
                    navController = mainNavigator.navController,
                    startDestination = ProductListRoute,
                ) {
                    productListNavGraph(
                        onProductClick = { product -> mainNavigator.navigateProductDetail(product) },
                        onCartClick = { mainNavigator.navigateCart() },
                    )

                    productDetailNavGraph(
                        onAddToCartClick = {},
                        onBackClick = { mainNavigator.popBackStack() }
                    )

                    cartNavGraph(onBackClick = { mainNavigator.popBackStack() })
                }
            }
        }
    )
}