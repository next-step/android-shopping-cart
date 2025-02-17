package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.dummyCartProductList
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
fun CountControlButton(
    count: Int,
    onAddClick: () -> Unit,
    onRemoveClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(size = 4.dp))
            .background(color = Color.White)
            .then(modifier),

        verticalAlignment = Alignment.CenterVertically,
    ) {
        val iconSize = 42.dp
        val iconPadding = 11.dp
        Icon(
            modifier = Modifier
                .size(iconSize)
                .clickable {
                    onRemoveClick.invoke()
                }
                .padding(iconPadding),
            painter = painterResource(R.drawable.ic_remove),
            contentDescription = stringResource(R.string.remove),
        )

        Text(
            modifier = Modifier.width(iconSize),
            text = count.toString(),
            style = Typography.bodyLarge,
            textAlign = TextAlign.Center,
        )

        Icon(
            modifier = Modifier
                .size(iconSize)
                .clickable {
                    onAddClick.invoke()
                }
                .padding(iconPadding),
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add),
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF9A9999)
@Composable
private fun CountControlButtonPreview() {
    ShoppingCartTheme {
        val model = dummyCartProductList.first()
        Box(
            modifier = Modifier.padding(10.dp),
            contentAlignment = Alignment.Center,
        ) {
            CountControlButton(
                count = 3,
                onAddClick = {},
                onRemoveClick = {},
            )
        }
    }
}