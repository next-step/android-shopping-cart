package nextstep.shoppingcart.view.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.cart.CartItemCountButton
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

const val gridCellsCount = 2

@Composable
fun ProductsList(
    products: List<Product>,
    onItemClick: (Product) -> Unit,
    onItemButtonClick: (Product) -> Unit,
    onAddClicked: (Product) -> Unit,
    onRemoveClicked: (Product) -> Unit,
    buttonClickState: Boolean,
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
                content = {
                    if (Cart.getButtonStateByProductName(product.name)) {
                        CartItemCountButton(
                            product = product,
                            itemCount = Cart.getCountByProductName(product.name),
                            onAddClicked = { onAddClicked(product) },
                            onRemoveClicked = { onRemoveClicked(product) },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(dimensionResource(id = R.dimen.product_item_circular_add_button_padding))
                                .background(
                                    MaterialTheme.colorScheme.background
                                )
                        )

                    } else {
                        CircularAddButton(
                            onClick = { onItemButtonClick(product) },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(dimensionResource(id = R.dimen.product_item_circular_add_button_padding))
                        )
                    }
                },
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
            buttonClickState = false
        )
    }
}
