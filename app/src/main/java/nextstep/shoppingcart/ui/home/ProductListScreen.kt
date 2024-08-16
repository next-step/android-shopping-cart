package nextstep.shoppingcart.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.ShoppingCartDestinations
import nextstep.shoppingcart.ui.getProducts

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
                    .padding(paddingValues)
                    .padding(start = 18.dp),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(top = 13.dp)
            ) {
                items(products) {
                    ProductItem(
                        navController = navController,
                        product = it
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun ProductListPreview() {
    ProductList(rememberNavController(), getProducts())
}
