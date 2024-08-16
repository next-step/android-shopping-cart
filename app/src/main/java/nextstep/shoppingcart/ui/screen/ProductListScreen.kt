package nextstep.shoppingcart.ui.screen

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
import nextstep.shoppingcart.data.Product

@Composable
fun ProductList(products: List<Product>) {
    Scaffold(
        topBar = {
            Title(title = "상품 목록") {

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
    val products: List<Product> = listOf(
        Product(
            name = "PET보틀-정사각",
            price = 10000,
            imageUrl = "https://example.com/pet_bottle_square.jpg"
        ),
        Product(
            name = "PET보틀-밀크티",
            price = 12000,
            imageUrl = "https://example.com/pet_bottle_milktea.jpg"
        ),
        Product(
            name = "PET보틀-정사각",
            price = 10000,
            imageUrl = "https://example.com/pet_bottle_square_2.jpg"
        ),
        Product(
            name = "PET보틀-납작(2",
            price = 12000,
            imageUrl = "https://example.com/pet_bottle_flat_1.jpg"
        ),
        Product(
            name = "PET보틀-정사각",
            price = 10000,
            imageUrl = "https://example.com/pet_bottle_square_3.jpg"
        ),
        Product(
            name = "PET보틀-납작(2",
            price = 12000,
            imageUrl = "https://example.com/pet_bottle_flat_2.jpg"
        )
    )
    ProductList(products)
}
