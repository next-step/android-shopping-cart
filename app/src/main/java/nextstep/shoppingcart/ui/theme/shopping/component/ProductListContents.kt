package nextstep.shoppingcart.ui.theme.shopping.component

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.ui.theme.shopping.getProductsTestData
import nextstep.shoppingcart.ui.theme.shopping.model.Product

@Composable
fun ProductListContents(productItems: List<Product>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
    ) {
        items(items = productItems, key = { it.productId }) { item ->
            Product(item)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListContentsPreview() {
    ProductListContents(productItems = getProductsTestData())
}
