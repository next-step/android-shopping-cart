package nextstep.shoppingcart.productlist.component

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.productTestDataList
import nextstep.shoppingcart.ui.component.Product

@Composable
fun ProductListContents(
    productItems: List<Product>,
    navigateToProductDetail: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
    ) {
        items(items = productItems, key = { it.productId }) { item ->
            Product(
                product = item,
                navigateToProductDetail = { id -> navigateToProductDetail(id) })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListContentsPreview() {
    ProductListContents(
        productItems = productTestDataList,
        navigateToProductDetail = {},
    )
}
