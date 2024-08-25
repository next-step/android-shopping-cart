package nextstep.shoppingcart.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartActionsTopBar(
    title: String,
    onActionClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = title)
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = stringResource(id = R.string.content_description_shopping_cart)
                )
            }
        }
    )
}

@Preview
@Composable
private fun ShoppingCartActionsTopBarPreview() {
    ShoppingCartActionsTopBar(
        title = "상품 목록",
        onActionClick = { }
    )

}