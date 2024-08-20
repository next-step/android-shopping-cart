package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R.drawable.ic_add
import nextstep.shoppingcart.R.drawable.ic_subtract
import nextstep.shoppingcart.R.string.shopping_count_bar_add_icon
import nextstep.shoppingcart.R.string.shopping_count_bar_count
import nextstep.shoppingcart.R.string.shopping_count_bar_subtract_icon
import nextstep.shoppingcart.R.string.shopping_count_bar_total_count
import nextstep.shoppingcart.ui.theme.RobotoRegular

@Composable
fun ShoppingCountBar(
    count: Int,
    onSubtractClick: () -> Unit,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shoppingCountBarSubtractIcon = stringResource(id = shopping_count_bar_subtract_icon)
    val shoppingCountBarAddIcon = stringResource(id = shopping_count_bar_add_icon)
    val shoppingCountBarTotalCount = stringResource(id = shopping_count_bar_total_count)

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.background(color = Color.White),
    ) {
        Icon(
            painter = painterResource(id = ic_subtract),
            contentDescription = shoppingCountBarSubtractIcon,
            modifier = Modifier
                .padding(all = 16.dp)
                .size(size = 16.dp)
                .clickable { onSubtractClick() }
                .semantics { contentDescription = shoppingCountBarSubtractIcon },
        )
        Text(
            text = stringResource(id = shopping_count_bar_count, count),
            fontSize = 22.sp,
            fontFamily = RobotoRegular,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(all = 16.dp)
                .width(width = 20.dp)
                .semantics { contentDescription = shoppingCountBarTotalCount },
        )
        Icon(
            painter = painterResource(id = ic_add),
            contentDescription = shoppingCountBarAddIcon,
            modifier = Modifier
                .padding(all = 16.dp)
                .size(size = 16.dp)
                .clickable { onAddClick() }
                .semantics { contentDescription = shoppingCountBarAddIcon },
        )
    }
}

@Preview
@Composable
private fun ShoppingCountBarPreview() {
    var count by remember { mutableIntStateOf(0) }

    ShoppingCountBar(
        count = count,
        onSubtractClick = { count -= 1 },
        onAddClick = { count += 1 },
    )
}
