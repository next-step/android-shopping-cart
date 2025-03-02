package nextstep.shoppingcart.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import nextstep.shoppingcart.model.CartCount

@Composable
fun ShoppingCartCounter(
    counter: CartCount,
    onAddClick: () -> Unit,
    onRemoveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.clip(shape = RoundedCornerShape(4.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {

        ShoppingCartCounterIconButton(
            icon = painterResource(id = R.drawable.ic_remove),
            onClick = onRemoveClick,
            contentDescription = "빼기",
        )

        Text(
            text = counter.value.toString(),
            fontSize = 22.sp,
            modifier = Modifier
                .size(42.dp)
                .wrapContentSize(Alignment.Center)
        )

        ShoppingCartCounterIconButton(
            icon = painterResource(id = R.drawable.ic_add),
            onClick = onAddClick,
            contentDescription = "더하기",
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun ShoppingCartCounterPreview() {
    ShoppingCartCounter(
        counter = CartCount.INIT_COUNT,
        onAddClick = {},
        onRemoveClick = {},
    )
}

