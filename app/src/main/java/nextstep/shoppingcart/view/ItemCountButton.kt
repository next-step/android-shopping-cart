package nextstep.shoppingcart.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product

@Composable
fun ItemCountButton(
    product: Product,
    itemCount: Int,
    onAddClicked: () -> Unit,
    onRemoveClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                onRemoveClicked()
            },
            modifier = Modifier.size(dimensionResource(id = R.dimen.cart_item_add_icon_size)),
        ) {
            Icon(
                Icons.Filled.KeyboardArrowDown,
                contentDescription = stringResource(id = R.string.cart_remove) + " ${product.name}"
            )
        }
        Text(
            text = itemCount.toString(),
            fontSize = dimensionResource(id = R.dimen.cart_item_quantity_text_size).value.sp,
        )
        IconButton(
            onClick = {
                onAddClicked()
            },
            modifier = Modifier.size(dimensionResource(id = R.dimen.cart_item_remove_icon_size)),
        ) {
            Icon(
                Icons.Filled.KeyboardArrowUp,
                contentDescription = stringResource(id = R.string.cart_add) + " ${product.name}"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartItemQuantityButtonPreview() {
    ItemCountButton(
        product = Product(
            name = "Product 1",
            price = 1000,
            imageUrl = "https://www.example.com/image1.jpg"
        ),
        itemCount = 1,
        onAddClicked = { },
        onRemoveClicked = { },
    )
}
