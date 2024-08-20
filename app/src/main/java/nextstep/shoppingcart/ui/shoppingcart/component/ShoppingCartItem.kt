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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.dummyProducts
import nextstep.shoppingcart.ui.shoppinglist.model.Product

@Composable
fun ShoppingCartItem(
    product: Product,
    modifier: Modifier = Modifier,
    removeItem: (productId: Long) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(size = 4.dp),
            )
            .padding(all = 18.dp),
    ) {
        ShoppingCartItemHeader(
            product = product,
            onCloseClick = removeItem,
        )
        Spacer(modifier = Modifier.height(height = 6.dp))
        ShoppingCartItemBody(
            product = product,
            removeItem = removeItem,
        )
    }
}

@Preview
@Composable
private fun ShoppingCartItemPreview() {
    ShoppingCartItem(
        product = dummyProducts[0],
        removeItem = {},
    )
}
