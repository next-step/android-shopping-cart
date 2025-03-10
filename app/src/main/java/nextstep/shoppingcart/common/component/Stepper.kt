package nextstep.shoppingcart.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

private const val STEP = 1

private object StepperDefaults {
    val buttonSize = 42.dp
    val fontSize = 22.sp
    val lineHeight = 18.67.sp
    val letterSpacing = 0.5.sp
    val roundedRadius = 4.dp
}

@Composable
fun Stepper(
    count: Int,
    onChangeCount: (Int) -> Unit,
    minimum: Int,
    maximum: Int,
    modifier: Modifier = Modifier,
    step: Int = STEP,
) {
    Row(
        modifier = modifier
    ) {
        StepperButton(
            label = stringResource(R.string.minus),
            onClick = {
                if (count - step >= minimum) onChangeCount(count - STEP)
            },
            modifier = Modifier
                .size(StepperDefaults.buttonSize)
                .clip(
                    RoundedCornerShape(
                        topStart = StepperDefaults.roundedRadius,
                        bottomStart = StepperDefaults.roundedRadius
                    )
                )
                .background(Color.White)
        )
        Box(
            modifier = Modifier
                .size(StepperDefaults.buttonSize)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            StepperText(
                text = count.toString(),
                fontWeight = FontWeight.W400,
            )
        }
        StepperButton(
            modifier = Modifier
                .size(StepperDefaults.buttonSize)
                .clip(
                    RoundedCornerShape(
                        topEnd = StepperDefaults.roundedRadius,
                        bottomEnd = StepperDefaults.roundedRadius
                    )
                )
                .background(Color.White),
            label = stringResource(R.string.plus),
            onClick = {
                if (count + step <= maximum) onChangeCount(count + STEP)
            },
        )
    }
}

@Composable
private fun StepperButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        StepperText(
            text = label,
            fontWeight = FontWeight.W700,
        )
    }
}

@Composable
private fun StepperText(
    text: String,
    fontWeight: FontWeight,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontWeight = fontWeight,
            fontSize = StepperDefaults.fontSize,
            lineHeight = StepperDefaults.lineHeight,
            letterSpacing = StepperDefaults.letterSpacing,
        ),
        color = Color.Black
    )
}

@Preview
@Composable
private fun StepperPreview() {
    val count = remember { mutableIntStateOf(1) }
    ShoppingCartTheme {
        Stepper(
            count = count.intValue,
            onChangeCount = { count.intValue = it },
            minimum = 0,
            maximum = 999,
            modifier = Modifier
        )
    }
}
