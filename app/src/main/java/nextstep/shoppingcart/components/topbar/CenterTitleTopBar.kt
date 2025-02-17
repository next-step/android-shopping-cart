@file:OptIn(ExperimentalMaterial3Api::class)

package nextstep.shoppingcart.components.topbar

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
@OptIn(ExperimentalMaterial3Api::class)
internal fun CenterTitleTopBar(
    title: String,
    action: TopBarActionType,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = title)
        },
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
        colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Color.White),
        scrollBehavior = scrollBehavior,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun CenterTitleTopBarPreview() {
    ShoppingCartTheme {
        CenterTitleTopBar(
            title = "상품 목록",
            action = TopBarActionType.CART,
            onActionClick = {},
        )
    }
}
