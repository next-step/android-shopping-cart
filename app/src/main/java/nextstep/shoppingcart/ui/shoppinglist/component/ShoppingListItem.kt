package nextstep.shoppingcart.ui.shoppinglist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R.string.shopping_List_item_description
import nextstep.shoppingcart.R.string.shopping_item_price_format
import nextstep.shoppingcart.data.Products.dummyProducts
import nextstep.shoppingcart.ui.shoppinglist.model.Product
import nextstep.shoppingcart.ui.theme.RobotoBold
import nextstep.shoppingcart.ui.theme.RobotoRegular

@Composable
fun ShoppingListItem(
    product: Product,
    isContained: Boolean,
    onItemClick: (productId: Long) -> Unit,
    onAddClick: (productId: Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    val shoppingListItemDescription = stringResource(id = shopping_List_item_description)

    Column(
        modifier = modifier
            .fillMaxSize()
            .clickable { onItemClick(product.id) }
            .semantics { contentDescription = shoppingListItemDescription },
    ) {
        ShoppingProductHeader(product, isContained, onAddClick)
        Text(
            text = product.name,
            modifier = Modifier.padding(
                start = 4.dp,
                top = 8.dp,
                bottom = 2.dp,
            ),
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = RobotoBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = stringResource(id = shopping_item_price_format, product.price),
            modifier = Modifier.padding(
                start = 4.dp,
                bottom = 4.dp,
                end = 86.dp,
            ),
            color = Color.Black,
            fontSize = 16.sp,
            fontFamily = RobotoRegular,
            maxLines = 1,
        )
    }
}

@Preview
@Composable
private fun ShoppingListItemPreview() {
    ShoppingListItem(
        product = dummyProducts[0],
        isContained = false,
        onItemClick = {},
        onAddClick = {},
        modifier = Modifier.background(Color.White),
    )
}
