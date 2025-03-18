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
import nextstep.shoppingcart.productlist.model.ProductWithCartInfo
import nextstep.shoppingcart.ui.component.CrossButton
import nextstep.shoppingcart.ui.component.QuantityControl
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductQuantityControl(
    item: ProductWithCartInfo,
    onDecreaseProductQuantity: (Product) -> Unit,
    onIncreaseProductQuantity: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    when {
        item.cartCount == 0 -> {
            CrossButton(
                onClick = { onIncreaseProductQuantity(item.product) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
        }

        item.cartCount > 0 -> {
            QuantityControl(
                item = item.product,
                count = item.cartCount,
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
            modifier = Modifier,
            onDecreaseProductQuantity = {},
            onIncreaseProductQuantity = {},
            item = ProductWithCartInfo(
                product = Product(
                    name = "Geraldine Jones",
                    imageUrl = "http://www.bing.com/search?q=utamur",
                    price = 5771,
                    productId = "pulvinar"
                ), cartCount = 0
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuantityNotZero0Preview() {
    ShoppingCartTheme {
        ProductQuantityControl(
            modifier = Modifier,
            onDecreaseProductQuantity = {},
            onIncreaseProductQuantity = {},
            item = ProductWithCartInfo(
                product = Product(
                    name = "Jody Patton",
                    imageUrl = "http://www.bing.com/search?q=dictas",
                    price = 8521,
                    productId = "decore"
                ), cartCount = 8656
            ),
        )
    }
}
