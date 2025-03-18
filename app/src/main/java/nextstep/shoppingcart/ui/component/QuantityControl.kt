package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun QuantityControl(
    item: Product,
    count: Int,
    onDecreaseProductQuantity: (Product) -> Unit,
    onIncreaseProductQuantity: (Product) -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .testTag("onRemoveOneFromCart ${item.name}")
                .clickable {
                    onDecreaseProductQuantity(item)
                }, contentAlignment = Alignment.Center
        ) {
            Text(
                text = "−",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            text = count.toString(),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier
                .size(42.dp)
                .testTag("addOneToCart ${item.name}")
                .clickable {
                    onIncreaseProductQuantity(item)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "+",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun QuantityControlPreview() {
    ShoppingCartTheme {
        QuantityControl(
            onDecreaseProductQuantity = {},
            onIncreaseProductQuantity = {},
            modifier = Modifier,
            item = Product(
                name = "Willa Garcia",
                imageUrl = "https://search.yahoo.com/search?p=minim",
                price = 8167,
                productId = "hac"
            ),
            count = 9856
        )
    }
}
