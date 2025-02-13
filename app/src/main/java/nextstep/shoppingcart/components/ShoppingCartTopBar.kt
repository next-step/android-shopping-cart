package nextstep.shoppingcart.components

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ShoppingCartTopBar(
    @StringRes title: Int,
    action: ShoppingCartTopBarActionType,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(title)) },
        actions = {
            IconButton(
                onClick = onActionClick,
            ) {
                Icon(
                    imageVector = action.icon,
                    contentDescription = stringResource(action.contentDescription),
                )
            }
        },
        modifier = modifier,
    )
}

internal enum class ShoppingCartTopBarActionType(
    val icon: ImageVector,
    @StringRes val contentDescription: Int,
) {
    CART(
        icon = Icons.Filled.ShoppingCart,
        contentDescription = R.string.item_list_top_bar_action_cart,
    ),
}

@Preview
@Composable
private fun ShoppingCartTopBarPreview() {
    ShoppingCartTheme {
        ShoppingCartTopBar(
            title = R.string.item_list_top_bar_title,
            action = ShoppingCartTopBarActionType.CART,
            onActionClick = {},
        )
    }
}
