package nextstep.shoppingcart.ui.shoppingcart.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R.string.shopping_cart_item_description
import nextstep.shoppingcart.data.Products.dummyProducts
import nextstep.shoppingcart.ui.shoppinglist.model.Product

@Composable
fun ShoppingCartItem(
    product: Product,
    onSubtractClick: () -> Unit,
    onAddClick: () -> Unit,
    sum: Long,
    count: Int,
    onRemoveClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shoppingListItemDescription = stringResource(id = shopping_cart_item_description)


    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(size = 4.dp),
            )
            .padding(all = 18.dp)
            .semantics { contentDescription = shoppingListItemDescription },
    ) {
        ShoppingCartItemHeader(
            product = product,
            onRemoveClick = onRemoveClick,
        )
        Spacer(modifier = Modifier.height(height = 6.dp))
        ShoppingCartItemBody(
            product = product,
            onSubtractClick = onSubtractClick,
            onAddClick = onAddClick,
            sum = sum,
            count = count,
        )
    }
}

@Preview
@Composable
private fun ShoppingCartItemPreview() {
    ShoppingCartItem(
        product = dummyProducts[0],
        onRemoveClick = {},
        onSubtractClick = {},
        onAddClick = {},
        sum = 0L,
        count = 0,
    )
}
