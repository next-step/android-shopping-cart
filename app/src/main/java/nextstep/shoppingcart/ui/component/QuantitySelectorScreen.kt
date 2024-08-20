package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.theme.cartTitleStyle

@Composable
fun QuantitySelector(
    quantity: Int,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextButton(
            onClick = onMinusClick,
            modifier = Modifier.size(42.dp)
        ) {
            Text("-", style = MaterialTheme.typography.titleLarge)
        }
        Text(
            text = "$quantity",
            modifier = Modifier.padding(horizontal = 14.dp),
            style = cartTitleStyle
        )
        TextButton(
            onClick = onPlusClick,
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