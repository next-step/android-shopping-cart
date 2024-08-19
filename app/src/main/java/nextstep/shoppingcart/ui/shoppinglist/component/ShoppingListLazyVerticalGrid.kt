package nextstep.shoppingcart.ui.shoppinglist.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.shoppinglist.model.Product
import nextstep.shoppingcart.ui.shoppinglist.model.dummyProducts

@Composable
fun ShoppingListLazyVerticalGrid(
    products: List<Product>,
    onItemClick: (productId: Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    val shoppingListDescription = stringResource(id = R.string.shopping_list_description)

    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = 20.dp,
                vertical = 12.dp,
            )
            .semantics { contentDescription = shoppingListDescription },
        verticalArrangement = Arrangement.spacedBy(space = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(space = 20.dp),
    ) {
        items(
            items = products,
            key = { product -> product.id },
        ) {
            ShoppingListItem(
                product = it,
                onItemClick = onItemClick,
            )
        }
    }
}

@Preview
@Composable
private fun ShoppingListPreview() {
    ShoppingListLazyVerticalGrid(
        products = dummyProducts,
        onItemClick = {},
    )
}
