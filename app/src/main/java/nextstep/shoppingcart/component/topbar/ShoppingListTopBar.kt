package nextstep.shoppingcart.component.topbar

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListTopBar(
    title: String,
    onClickCart : () -> Unit,
    modifier: Modifier = Modifier
) {
    ShoppingCenterAlignedTopBar(
        modifier = modifier,
        title = title,
        leftActionButtons = {
            Spacer(modifier = Modifier.size(48.dp))
        },
        rightActionButtons = {
            IconButton(
                onClick = onClickCart
            ) {
                Icon(
                    modifier = Modifier
                        .size(20.dp),
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "ShoppingCart"
                )
            }
        }
    )
}

@Preview(name = "ShoppingListTopBar", showBackground = true)
@Composable
private fun Preview1() {
    ShoppingListTopBar(
        modifier = Modifier.fillMaxWidth(),
        title = "상품 목록",
        onClickCart = {}
    )
}