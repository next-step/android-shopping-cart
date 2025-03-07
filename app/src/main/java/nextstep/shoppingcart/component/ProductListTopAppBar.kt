package nextstep.shoppingcart.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListTopAppBar(
    title: String,
    actions: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF1D1B20)
            )
        },
        actions = actions
    )
}

@Preview
@Composable
private fun ProductListTopAppBarPreview() {
    ProductListTopAppBar(
        title = "상품 목록",
        actions = {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "장바구니",
                modifier = Modifier.padding(12.dp),
                tint = Color.Black
            )
        }
    )
}
