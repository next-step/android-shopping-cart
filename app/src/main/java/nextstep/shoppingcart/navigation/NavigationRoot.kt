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
import nextstep.shoppingcart.ui.model.Product
import nextstep.shoppingcart.ui.basket.BasketScreenRoot
import nextstep.shoppingcart.ui.product_detail.ProductDetailScreenRoot
import nextstep.shoppingcart.ui.product_list.ProductListScreenRoot

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
            ProductListScreenRoot(
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

            ProductDetailScreenRoot(
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
            BasketScreenRoot(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
