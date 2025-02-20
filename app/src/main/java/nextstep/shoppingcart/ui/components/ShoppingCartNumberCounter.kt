package nextstep.shoppingcart.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R

@Composable
fun NumberCounter(
    count: Int,
    onAddClick: () -> Unit,
    onRemoveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {
        IconButton(
            onClick = onRemoveClick,
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_remove),
                contentDescription = "빼기",
                modifier = Modifier.size(24.dp)
            )
        }

        Box(
            modifier = Modifier.size(42.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = count.toString(),
                fontSize = 22.sp
            )
        }
        IconButton(
            onClick = onAddClick,
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "추가",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemCounterPreview() {
    NumberCounter(
        count = 1,
        onAddClick = {},
        onRemoveClick = {}
    )
}