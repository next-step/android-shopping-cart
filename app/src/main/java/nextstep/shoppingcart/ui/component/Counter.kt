package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Counter(
    onClickDecrease: () -> Unit,
    onClickIncrease: () -> Unit,
    count: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .width(126.dp)
            .height(42.dp)
            .clip(RoundedCornerShape(4.dp))
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(4.dp))
            .shadow(10.dp)
            .background(Color.White),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CounterButton("−", onClickDecrease)
        Text(
            text = "$count",
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentSize(Alignment.Center)
        )
        CounterButton("+", onClickIncrease)
    }
}

@Composable
fun CounterButton(title: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.size(42.dp)
    ) {
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .wrapContentHeight(Alignment.CenterVertically)
        )
    }
}

@Preview()
@Composable
fun CounterPreview() {
    Counter(
        onClickDecrease = {},
        onClickIncrease = {},
        count = 1
    )
}
