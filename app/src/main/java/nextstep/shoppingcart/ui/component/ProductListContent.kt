package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.model.Product

@Composable
internal fun ProductListContent(
    productList: List<Product>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(top = 13.dp, start = 18.dp, end = 18.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        items(
            items = productList,
            key = { it.id }
        ) { product ->
            ProductItem(product)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListContentPreview() {
    ProductListContent(
        (0..100).map {
            Product(
                id = it,
                imageUrl = "https://www.google.com/#q=tristique",
                name = "상품_$it",
                price = 3124
            )
        }
    )
}
