package nextstep.shoppingcart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.ui.theme.GridCellsCount
import nextstep.shoppingcart.ui.theme.GridEndPadding
import nextstep.shoppingcart.ui.theme.GridHorizontalSpace
import nextstep.shoppingcart.ui.theme.GridStartPadding
import nextstep.shoppingcart.ui.theme.GridTopPadding
import nextstep.shoppingcart.ui.theme.GridVerticalSpace

@Composable
fun ProductsGrid(
    products: List<Product>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(GridCellsCount),
        modifier = modifier.padding(
            start = GridStartPadding,
            end = GridEndPadding,
            top = GridTopPadding
        ),
        horizontalArrangement = Arrangement.spacedBy(GridHorizontalSpace),
        verticalArrangement = Arrangement.spacedBy(GridVerticalSpace)
    ) {
        items(products) { product ->
            ProductItem(product, modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsGridPreview() {
    ProductsGrid(dummyProducts)
}