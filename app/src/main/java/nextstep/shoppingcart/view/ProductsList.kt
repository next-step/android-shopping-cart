package nextstep.shoppingcart.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

const val gridCellsCount = 2

@Composable
fun ProductsGrid(
    products: List<Product>,
    onItemClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(gridCellsCount),
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = dimensionResource(id = R.dimen.grid_horizontal_padding),
            vertical = dimensionResource(id = R.dimen.grid_vertical_padding)
        ),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.grid_horizontal_space)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.grid_vertical_space))
    ) {
        items(products) { product ->
            ProductItem(product, onItemClick, modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsGridPreview() {
    ShoppingCartTheme {
        ProductsGrid(dummyProducts, onItemClick = {})
    }
}
