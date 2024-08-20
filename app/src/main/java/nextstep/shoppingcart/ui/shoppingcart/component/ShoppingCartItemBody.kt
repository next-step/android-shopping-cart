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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    removeItem: (productId: Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth(),
    ) {
        var count by remember { mutableIntStateOf(0) }
        val sum by remember { derivedStateOf { product.price * count } }

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
                onSubtractClick = { if (count <= 0) removeItem(product.id) else count -= 1 },
                onAddClick = { count += 1 },
            )
        }
    }
}

@Preview
@Composable
private fun ShoppingCartItemBodyPreview() {
    ShoppingCartItemBody(
        product = dummyProducts[0],
        removeItem = {},
        modifier = Modifier.background(color = Color.White),
    )
}
