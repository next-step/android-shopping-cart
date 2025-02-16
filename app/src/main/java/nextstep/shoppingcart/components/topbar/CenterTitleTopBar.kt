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
    modifier: Modifier = Modifier,
    title: String = "",
    navigationType: TopBarNavigationType? = null,
    onNavigationClick: () -> Unit = {},
    action: TopBarActionType? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = {
            if (title.isNotEmpty()) {
                Text(text = title)
            }
        },
        navigationIcon = {
            navigationType?.let {
                IconButton(
                    onClick = onNavigationClick,
                ) {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = stringResource(it.contentDescription),
                    )
                }
            }
        },
        actions = {
            action?.let {
                IconButton(
                    onClick = onActionClick,
                ) {
                    Icon(
                        imageVector = action.icon,
                        contentDescription = stringResource(action.contentDescription),
                    )
                }
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
        CenterTitleTopBar()
    }
}

@Preview
@Composable
private fun CenterTitleTopBarWithTitlePreview() {
    ShoppingCartTheme {
        CenterTitleTopBar(
            title = "상품 목록"
        )
    }
}

@Preview
@Composable
private fun CenterTitleTopBarWithNavigationBackPreview() {
    ShoppingCartTheme {
        CenterTitleTopBar(
            title = "상품 목록",
            navigationType = TopBarNavigationType.BACK,
        )
    }
}

@Preview
@Composable
private fun CenterTitleTopBarWithActionCartPreview() {
    ShoppingCartTheme {
        CenterTitleTopBar(
            title = "상품 목록",
            action = TopBarActionType.CART,
        )
    }
}

@Preview
@Composable
private fun CenterTitleTopBarWithNavigationBackAndActionCartPreview() {
    ShoppingCartTheme {
        CenterTitleTopBar(
            title = "상품 목록",
            navigationType = TopBarNavigationType.BACK,
            action = TopBarActionType.CART,
        )
    }
}
