package nextstep.shoppingcart.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.products

@Composable
fun ProductsList(
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(18.dp),
        modifier = modifier
    ) {
        items(products) { item ->
            ProductsItem(
                product = item,
            )
        }
    }
}

@Preview
@Composable
private fun ProductsListPreview() {
    ProductsList(
        products = products
    )
}