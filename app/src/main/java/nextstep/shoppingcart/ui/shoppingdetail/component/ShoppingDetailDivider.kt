package nextstep.shoppingcart.ui.shoppingdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingDetailDivider(
    modifier: Modifier = Modifier,
) {
    Divider(
        modifier = modifier
            .height(height = 2.dp)
            .background(color = Color.Gray),
    )
}

@Preview
@Composable
private fun ShoppingDetailDividerPreview() {
    ShoppingDetailDivider()
}
