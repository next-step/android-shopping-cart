package nextstep.shoppingcart.view.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@Composable
fun ProductsScreen(
    onItemClick: (Product) -> Unit,
    onItemButtonClick: (Product) -> Unit,
    onAddClicked: (Product) -> Unit,
    onRemoveClicked: (Product) -> Unit,
    buttonClickState: Boolean
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProductsTopAppBar()
            ProductsList(
                products = dummyProducts,
                onItemClick = onItemClick,
                onItemButtonClick = onItemButtonClick,
                buttonClickState = buttonClickState,
                onAddClicked = onAddClicked,
                onRemoveClicked = onRemoveClicked,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsScreenPreview() {
    ShoppingCartTheme {
        ProductsScreen(
            onItemClick = {},
            onItemButtonClick = {},
            onAddClicked = {},
            onRemoveClicked = {},
            buttonClickState = false
        )
    }
}
