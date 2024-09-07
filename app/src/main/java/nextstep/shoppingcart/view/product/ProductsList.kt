package nextstep.shoppingcart.view.product

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
fun ProductsList(
    products: List<Product>,
    onItemClick: (Product) -> Unit,
    onItemButtonClick: (Product) -> Unit,
    onAddClicked: (Product) -> Unit,
    onRemoveClicked: (Product) -> Unit,
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
            ProductItem(
                product = product,
                onItemClick = onItemClick,
                onItemButtonClick = onItemButtonClick,
                onAddClicked = onAddClicked,
                onRemoveClicked = onRemoveClicked,
                modifier = modifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsListPreview() {
    ShoppingCartTheme {
        ProductsList(
            products = dummyProducts,
            onItemClick = {},
            onItemButtonClick = {},
            onAddClicked = {},
            onRemoveClicked = {},
        )
    }
}
