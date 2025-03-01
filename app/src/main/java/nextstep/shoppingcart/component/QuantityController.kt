package nextstep.shoppingcart.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuantityController(
    count: Int,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        TextButton(
            onClick = onMinusClick,
            modifier = Modifier.size(42.dp).testTag("minus_button"),
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.Black,
            ),
        ) {
            Text(
                text = "-",
                fontSize = 22.sp,
                fontWeight = FontWeight.W700,
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(42.dp),
        ) {
            Text(
                text = count.toString(),
                fontSize = 20.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.testTag("quantity_text"),
            )
        }
        TextButton(
            onClick = onPlusClick,
            modifier = Modifier.size(42.dp).testTag("plus_button"),
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.Black,
            ),
        ) {
            Text(
                text = "+",
                fontSize = 22.sp,
                fontWeight = FontWeight.W700,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun QuantityControllerPreview() {
    var count by remember { mutableIntStateOf(0) }

    QuantityController(
        count = count,
        onMinusClick = {
            count--
        },
        onPlusClick = {
            count++
        },
    )
}
