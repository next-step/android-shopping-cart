package nextstep.shoppingcart.ui.shoppinglist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.Products.dummyProducts
import nextstep.shoppingcart.ui.component.ShoppingCountBar
import nextstep.shoppingcart.ui.component.ShoppingProductImage
import nextstep.shoppingcart.ui.shoppinglist.model.Product

@Composable
fun ShoppingProductHeader(
    product: Product,
    isContained: Boolean,
    onAddClick: (productId: Long) -> Unit,
) {
    Box(contentAlignment = Alignment.BottomEnd) {
        ShoppingProductImage(
            product = product,
            modifier = Modifier
                .size(size = 156.dp)
                .background(Color.Black),
        )
        when (isContained) {
            true -> ShoppingCountBar(
                count = 0,
                onSubtractClick = { /*TODO*/ },
                onAddClick = { /*TODO*/ }
            )

            false -> ShoppingProductAddButton(onAddButton = { onAddClick(product.id) })
        }
    }
}

@Preview
@Composable
private fun ShoppingProductHeaderPreview() {
    ShoppingProductHeader(
        product = dummyProducts[0],
        isContained = false,
        onAddClick = {},
    )
}
