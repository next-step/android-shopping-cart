package nextstep.shoppingcart.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.data.cart.Cart
import nextstep.shoppingcart.data.goods.Product
import nextstep.shoppingcart.data.goods.impl.ProductRepositoryImpl
import nextstep.shoppingcart.ui.ShoppingCartDestinations

@Composable
fun ProductList(
    navController: NavController,
    products: List<Product>
) {
    Scaffold(
        topBar = {
            Title(
                title = "상품 목록"
            ) {
                navController.navigate(ShoppingCartDestinations.SHOPPING_CART)
            }
        },
        content = { paddingValues ->
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(
                    top = 13.dp,
                    start = 18.dp,
                    end = 18.dp,
                    bottom = 13.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                items(products) { item ->
                    var cartItemSize by remember {
                        mutableIntStateOf(
                            Cart.items.find { it.product == item }?.count ?: 0
                        )
                    }
                    ProductItem(
                        product = item,
                        onClickItem =  {
                            navController.navigate(ShoppingCartDestinations.DETAIL_ROUTE + "/${item.productId}")
                        },
                        onMinusClick = {
                            cartItemSize -= 1
                            Cart.removeOne(item)
                        },
                        onPlusClick = {
                            cartItemSize += 1
                            Cart.addOne(item)
                        },
                        itemCount = cartItemSize
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun ProductListPreview() {
    ProductList(rememberNavController(), ProductRepositoryImpl().getProducts())
}
