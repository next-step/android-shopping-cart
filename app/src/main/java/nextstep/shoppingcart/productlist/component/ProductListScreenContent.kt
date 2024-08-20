package nextstep.shoppingcart.productlist.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.common.model.Product

@Composable
internal fun ProductListScreenContent(
    paddingValues: PaddingValues,
    products: List<Product>,
    onProductClick: (Product) -> Unit,
) {
    LazyVerticalGrid(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .padding(horizontal = 18.dp),
        columns = GridCells.Adaptive(156.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            items = products,
            key = { item -> item.id }
        ) { item ->
            ProductListScreenCard(
                product = item,
                modifier = Modifier.clickable { onProductClick(item) }
            )
        }
    }
}