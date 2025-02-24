package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductCartCounter(
    count: Int,
    onIncreaseClick: () -> Unit,
    onDecreaseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val textStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 18.67.sp,
        letterSpacing = 0.5.sp,
        color = Color.Black,
        textAlign = TextAlign.Center
    )
    val buttonSize = 42.dp
    Row(
        modifier = modifier
            .background(
                color = Color.White,
                shape = ShapeDefaults.ExtraSmall
            )
    ) {
        CounterButton(
            modifier = Modifier
                .size(buttonSize)
                .testTag("decrease_button"),
            text = stringResource(R.string.decrease_symbol),
            onClick = onDecreaseClick,
            textStyle = textStyle
        )
        Box(
            modifier = Modifier.sizeIn(minWidth = buttonSize, minHeight = buttonSize)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .testTag("count"),
                style = textStyle,
                fontWeight = FontWeight.Normal,
                text = count.toString(),
            )
        }
        CounterButton(
            modifier = Modifier
                .size(buttonSize)
                .testTag("increase_button"),
            text = stringResource(R.string.increase_symbol),
            onClick = onIncreaseClick,
            textStyle = textStyle
        )
    }
}

@Composable
private fun CounterButton(
    text: String,
    textStyle: TextStyle,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}


@Preview
@Composable
private fun ProductCartCounterPreview() {
    var count by remember { mutableStateOf(1000) }
    ShoppingCartTheme {
        ProductCartCounter(
            count = count,
            onIncreaseClick = { count++ },
            onDecreaseClick = { count-- }
        )
    }
}

