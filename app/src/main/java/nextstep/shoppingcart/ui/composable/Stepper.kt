package nextstep.shoppingcart.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Stepper(
    count: Int,
    onCountChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clickable { onCountChange(count - 1) },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "-",
                fontWeight = FontWeight.W700,
                fontSize = 22.sp,
                color = Color.Black,
            )
        }
        Text(
            modifier = Modifier
                .defaultMinSize(minWidth = 42.dp),
            text = count.toString(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W400,
            fontSize = 22.sp,
            color = Color.Black,
        )
        Box(
            modifier = Modifier
                .size(42.dp)
                .clickable { onCountChange(count + 1) },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "+",
                fontWeight = FontWeight.W700,
                fontSize = 22.sp,
                color = Color.Black,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StepperPreview() {
    var count by remember { mutableIntStateOf(0) }
    Stepper(count, { count = it })
}
