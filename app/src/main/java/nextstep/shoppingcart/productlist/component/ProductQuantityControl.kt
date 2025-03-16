package nextstep.shoppingcart.productlist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.component.CrossButton
import nextstep.shoppingcart.ui.component.QuantityControl
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductQuantityControl(
    item: Product,
    quantity: Int,
    onDecreaseProductQuantity: (Product) -> Unit,
    onIncreaseProductQuantity: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    when {
        quantity == 0 -> {
            CrossButton(
                onClick = { onIncreaseProductQuantity(item) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
        }

        quantity > 0 -> {
            QuantityControl(
                item = item,
                count = quantity,
                onDecreaseProductQuantity = onDecreaseProductQuantity,
                onIncreaseProductQuantity = onIncreaseProductQuantity,
                modifier = modifier
                    .padding(12.dp)
                    .background(Color.White)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun QuantityZero0Preview() {
    ShoppingCartTheme {
        ProductQuantityControl(
            item = Product(
                name = "Eileen Houston",
                imageUrl = "https://www.google.com/#q=luptatum",
                price = 2192,
                productId = "qualisque"

            ), quantity = 0, modifier = Modifier,
            onDecreaseProductQuantity = {},
            onIncreaseProductQuantity = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuantityNotZero0Preview() {
    ShoppingCartTheme {
        ProductQuantityControl(
            item = Product(
                name = "Gloria Donaldson",
                imageUrl = "https://search.yahoo.com/search?p=semper",
                price = 2567,
                productId = "suavitate"
            ),
            quantity = 2322, modifier = Modifier,
            onDecreaseProductQuantity = {},
            onIncreaseProductQuantity = {},
        )
    }
}
