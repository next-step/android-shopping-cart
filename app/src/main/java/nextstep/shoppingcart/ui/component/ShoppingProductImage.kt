package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R.string.shopping_item_description
import nextstep.shoppingcart.data.dummyProducts
import nextstep.shoppingcart.ui.shoppinglist.model.Product

@Composable
fun ShoppingProductImage(
    product: Product,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = product.imageUrl,
        contentDescription = stringResource(id = shopping_item_description),
        modifier = modifier
            .width(width = 360.dp)
            .height(height = 360.dp),
    )
}

@Preview
@Composable
private fun ShoppingProductImagePreview() {
    ShoppingProductImage(product = dummyProducts[0])
}
