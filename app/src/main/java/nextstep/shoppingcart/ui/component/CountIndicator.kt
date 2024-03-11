package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R

@Composable
fun CountIndicator(
    modifier: Modifier = Modifier,
    count: Int,
    onClickInc: () -> Unit,
    onClickDec: () -> Unit
) {
    Row(
        modifier = modifier
            .width(width = 126.dp)
            .background(color = Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .weight(weight = 1f)
                .fillMaxHeight()
                .clickable {
                    onClickDec()
                },
            imageVector = Icons.Filled.KeyboardArrowDown,
            contentDescription = stringResource(R.string.minus)
        )
        Text(
            modifier = Modifier
                .weight(weight = 1f)
                .fillMaxHeight()
                .semantics {
                    contentDescription = "Count"
                },
            text = count.toString(),
            textAlign = TextAlign.Center,
            fontSize = 22.sp
        )
        Image(
            modifier = Modifier
                .weight(weight = 1f)
                .fillMaxHeight()
                .clickable {
                    onClickInc()
                },
            imageVector = Icons.Filled.KeyboardArrowUp,
            contentDescription = stringResource(R.string.plus)
        )
    }
}

@Preview(
    showBackground = true,
    heightDp = 42
)
@Composable
private fun CountIndicatorPreview() {
    var count by remember {
        mutableIntStateOf(1)
    }
    CountIndicator(
        count = count,
        onClickInc = { count++ },
        onClickDec = { count--}
    )
}
