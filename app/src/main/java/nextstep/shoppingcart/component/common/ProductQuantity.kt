package nextstep.shoppingcart.component.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.component.IconPack
import nextstep.shoppingcart.component.iconpack.Remove

@Composable
fun ProductQuantity(
    name: String,
    count: Int,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 26.dp)
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(
            onClick = onMinusClick,
        ) {
            Icon(
                imageVector = IconPack.Remove,
                contentDescription = "$name minus"
            )
        }
        Text(
            text = count.toString(),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        IconButton(
            onClick = onPlusClick,
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "$name plus"
            )
        }
    }
}

@Preview
@Composable
private fun ProductQuantityComponentPreview() {
    ProductQuantity(
        name = "test",
        count = 1,
        onPlusClick = {},
        onMinusClick = {}
    )
}