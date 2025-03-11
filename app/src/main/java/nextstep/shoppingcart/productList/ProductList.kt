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
import nextstep.shoppingcart.data.DummyProduct
import nextstep.shoppingcart.data.Product

@Composable
fun ProductList(
    products: List<Product>,
    onItemClick: (Product) -> Unit,
    onPlusClick: (Product) -> Unit,
    onMinusClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 13.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier,
    ) {
        items(products) { product->
            ProductItem(
                product = product,
                onClick = {
                    onItemClick(product)
                },
                onPlusClick = {
                    onPlusClick(product)
                },
                onMinusClick = {
                    onMinusClick(product)
                },
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListPreview() {
    val products = DummyProduct.productDummyList

    ProductList(
        products = products,
        onItemClick = {},
        onPlusClick = {},
        onMinusClick = {},
    )
}