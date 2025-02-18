package nextstep.shoppingcart.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.basket.BasketScreen
import nextstep.shoppingcart.ui.product_detail.ProductDetailScreen
import nextstep.shoppingcart.ui.product_list.ProductListScreen

@Composable
fun NavigationRoot(
    navController: NavHostController,
) {
    NavHost(
        startDestination = ProductDestination,
        navController = navController,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        productGraph(navController)
    }
}

private fun NavGraphBuilder.productGraph(navController: NavController) {
    navigation<ProductDestination>(
        startDestination = ProductList,
    ) {
        composable<ProductList> {
            ProductListScreen(
                onProductClick = {
                    navController.navigate(
                        ProductDetail(
                            id = it.id,
                            imageUrl = it.imageUrl,
                            name = it.name,
                            price = it.price,
                        )
                    )
                },
                onBasketClick = {
                    navController.navigate(Basket)
                }
            )
        }

        composable<ProductDetail> { backstackEntry ->
            val productDetail = backstackEntry.toRoute<ProductDetail>()

            ProductDetailScreen(
                product = Product(
                    id = productDetail.id,
                    imageUrl = productDetail.imageUrl,
                    name = productDetail.name,
                    price = productDetail.price
                ),
                navigateBack = {
                    navController.popBackStack()
                },
                onAddBasketClick = {
                    navController.navigate(Basket) {
                        popUpTo(ProductList) {
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            )
        }

        composable<Basket> {
            BasketScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
