package nextstep.shoppingcart.ui.shoppingcart.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.dummyProducts
import nextstep.shoppingcart.ui.component.ShoppingCountBar
import nextstep.shoppingcart.ui.component.ShoppingProductImage
import nextstep.shoppingcart.ui.shoppinglist.model.Product

@Composable
fun ShoppingCartItemBody(
    product: Product,
    onSubtractClick: () -> Unit,
    onAddClick: () -> Unit,
    sum: Long,
    count: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth(),
    ) {
        ShoppingProductImage(
            product = product,
            modifier = Modifier
                .width(width = 136.dp)
                .height(height = 84.dp),
        )
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier.wrapContentWidth(),
        ) {
            Spacer(modifier = Modifier.height(height = 18.dp))
            ShoppingCartItemSumText(sum)
            ShoppingCountBar(
                count = count,
                onSubtractClick = onSubtractClick,
                onAddClick = onAddClick,
            )
        }
    }
}

@Preview
@Composable
private fun ShoppingCartItemBodyPreview() {
    ShoppingCartItemBody(
        product = dummyProducts[0],
        onSubtractClick = {},
        onAddClick = {},
        sum = 30000,
        count = 5,
        modifier = Modifier.background(color = Color.White),
    )
}
