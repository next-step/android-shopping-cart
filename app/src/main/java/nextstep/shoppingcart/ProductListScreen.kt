package nextstep.shoppingcart

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.component.ProductList
import nextstep.shoppingcart.component.ProductListTopAppBar
import nextstep.shoppingcart.model.Product

@Composable
fun ProductListScreen(
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ProductListTopAppBar(title = "상품 목록")
        }
    ) { innerPadding ->
        ProductList(
            modifier = modifier.padding(innerPadding),
            products = products
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ProductListScreen(
        products = List(10) {
            Product(
                id = it,
                imageUrl = "https://picsum.photos/id/1/300/300",
                name = "PET보틀-정사각형 어쩌구",
                price = 10000
            )
        }
    )
}
