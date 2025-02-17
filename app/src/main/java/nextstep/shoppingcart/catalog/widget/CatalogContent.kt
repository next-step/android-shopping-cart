package nextstep.shoppingcart.catalog.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.catalog.component.ProductGridItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.util.DataUtil.dummyProducts

@Composable
fun CatalogContent(
    products: List<Product>,
    navigateToDetail: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(top = 13.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),
    ) {
        items(products) { product ->
            ProductGridItem(
                product = product,
                onClickItem = { navigateToDetail.invoke() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CatalogContentPreview() {
    CatalogContent(
        products = dummyProducts,
        navigateToDetail = {},
    )
}