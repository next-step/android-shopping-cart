package nextstep.shoppingcart.common.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.common.theme.NextStepTheme

@Composable
internal fun QuantitySelector(
    count: Int,
    onCountAddClick: () -> Unit,
    onCountMinusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            QuantityAdjustButton(
                text = "-",
                onClick = onCountMinusClick
            )
            Text(
                text = count.toString(),
                style = NextStepTheme.typography.roboto22N
            )
            QuantityAdjustButton(
                text = "+",
                onClick = onCountAddClick
            )
        }
    }
}

@Composable
private fun QuantityAdjustButton(
    text: String,
    onClick: () -> Unit,
) {
    Surface(
        modifier = Modifier.size(48.dp),
        onClick = onClick,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = NextStepTheme.typography.roboto22B,
            )
        }
    }
}

@Preview
@Composable
fun PreviewQuantitySelector() {
    var count by remember { mutableIntStateOf(1) }

    NextStepTheme {
        QuantitySelector(
            count = count,
            onCountAddClick = { count += 1 },
            onCountMinusClick = { count -= 1 },
            modifier = Modifier
        )
    }
}