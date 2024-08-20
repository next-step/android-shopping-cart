package nextstep.shoppingcart.ui.shoppingcart.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R.string.shopping_cart_item_header_close_button
import nextstep.shoppingcart.data.dummyProducts
import nextstep.shoppingcart.ui.shoppinglist.model.Product
import nextstep.shoppingcart.ui.theme.RobotoBold

@Composable
fun ShoppingCartItemHeader(
    product: Product,
    onRemoveClick: (productId: Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    val shoppingCartItemHeaderCloseButtonDescription =
        stringResource(id = shopping_cart_item_header_close_button)

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = product.name,
            fontSize = 20.sp,
            fontFamily = RobotoBold,
            color = Color.Black,
        )
        Icon(
            imageVector = Filled.Clear,
            contentDescription = shoppingCartItemHeaderCloseButtonDescription,
            modifier = Modifier
                .clickable { onRemoveClick(product.id) }
                .semantics { contentDescription = shoppingCartItemHeaderCloseButtonDescription },
        )
    }
}

@Preview
@Composable
private fun ShoppingCartItemHeaderPreview() {
    ShoppingCartItemHeader(
        product = dummyProducts[0],
        onRemoveClick = {},
        modifier = Modifier.background(color = Color.White),
    )
}
