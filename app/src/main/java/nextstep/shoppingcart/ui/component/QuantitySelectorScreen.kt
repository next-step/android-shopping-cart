package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.theme.cartTitleStyle

@Composable
fun QuantitySelector(
    initQuantity: Int,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.wrapContentWidth()
    ) {
        var quantity by remember { mutableStateOf(initQuantity) }
        IconButton(
            onClick = {
                onMinusClick()
                if (quantity > 1) quantity--
            },
            modifier = Modifier.size(42.dp)
        ) {
            Text("-", style = MaterialTheme.typography.titleLarge)
        }
        Text(
            text = "$quantity",
            modifier = Modifier.padding(horizontal = 14.dp),
            style = cartTitleStyle
        )
        IconButton(
            onClick = {
                onPlusClick()
                quantity++
            },
            modifier = Modifier.size(42.dp)
        ) {
            Text("+", style = MaterialTheme.typography.titleLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun QuantitySelectorPreview() {
    QuantitySelector(
        1,
        onMinusClick = {},
        onPlusClick = {}
    )

}