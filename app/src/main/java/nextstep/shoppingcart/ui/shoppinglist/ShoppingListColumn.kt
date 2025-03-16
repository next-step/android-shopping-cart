package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.ProductRepository
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingListColumn(
    listOfItems: List<Product>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier.padding(horizontal = 18.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(listOfItems.size) { item ->
            ShoppingItem(
                product = listOfItems[item]
            )
        }
    }
}

@Preview
@Composable
private fun ShoppingListColumnPreview() {
    val listOfItems = ProductRepository().getProducts()
    ShoppingCartTheme {
        ShoppingListColumn(
            listOfItems = listOfItems,
        )
    }
}