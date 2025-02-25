package nextstep.shoppingcart.productList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.Product

@Composable
fun ProductList(
    products: List<Product> = emptyList(),
    onItemClick: (Product) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 13.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier,
    ) {
        items(products) {
            ProductItem(
                product = it,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onItemClick(it)
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListPreview() {
    val products = List(10) {
        Product(
            "상품이름",
            "",
            10_000,
        )
    }

    ProductList(
        products = products,
    )
}