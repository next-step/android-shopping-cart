package nextstep.shoppingcart.ui.shoppinglist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.ShoppingListPreviewParameterProvider
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingListColumn(
    listOfItems: List<Product>,
    modifier: Modifier = Modifier,
    onItemClick: (Product) -> Unit = {},
) {
    LazyVerticalGrid(
        modifier = modifier.padding(horizontal = 18.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(items = listOfItems) { item ->
            ShoppingItem(
                product = item,
                onItemClick = onItemClick
            )
        }
    }
}

@Preview
@Composable
private fun ShoppingListColumnPreview(
    @PreviewParameter(ShoppingListPreviewParameterProvider::class) products: List<Product>
) {
    ShoppingCartTheme {
        ShoppingListColumn(
            listOfItems = products,
        )
    }
}