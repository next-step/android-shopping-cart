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
            buttonType = StepperButtonType.LEFT,
            modifier = Modifier.size(StepperDefaults.buttonSize)
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
            label = stringResource(R.string.plus),
            onClick = {
                if (count + step <= maximum) onChangeCount(count + STEP)
            },
            buttonType = StepperButtonType.RIGHT,
            modifier = Modifier.size(StepperDefaults.buttonSize)
        )
    }
}

private enum class StepperButtonType(
    val topStart: Int,
    val topEnd: Int,
    val bottomStart: Int,
    val bottomEnd: Int
) {
    RIGHT(
        topStart = 0,
        topEnd = 4,
        bottomStart = 0,
        bottomEnd = 4
    ),
    LEFT(
        topStart = 4,
        topEnd = 0,
        bottomStart = 4,
        bottomEnd = 0
    )
}

@Composable
private fun StepperButton(
    label: String,
    onClick: () -> Unit,
    buttonType: StepperButtonType,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    topStart = buttonType.topStart.dp,
                    topEnd = buttonType.topEnd.dp,
                    bottomStart = buttonType.bottomStart.dp,
                    bottomEnd = buttonType.bottomEnd.dp
                )
            )
            .background(Color.White)
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
