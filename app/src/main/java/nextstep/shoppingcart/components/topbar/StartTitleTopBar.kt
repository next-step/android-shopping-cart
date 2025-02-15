package nextstep.shoppingcart.components.topbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun StartTitleTopBar(
    modifier: Modifier = Modifier,
    title: String = "",
    navigationType: TopBarNavigationType? = null,
    onNavigationClick: () -> Unit = {},
    action: TopBarActionType? = null,
    onActionClick: () -> Unit = {},
) {
    TopAppBar(
        title = {
            if (title.isNotEmpty()) {
                Text(text = title)
            }
        },
        navigationIcon = {
            navigationType?.let {
                IconButton(onClick = onNavigationClick) {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = stringResource(it.contentDescription),
                    )
                }
            }
        },
        actions = {
            action?.let {
                IconButton(onClick = onActionClick) {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = stringResource(it.contentDescription),
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = Color.White),
        modifier = modifier,
    )
}

@Preview
@Composable
private fun StartTitleTopBarPreview() {
    ShoppingCartTheme {
        StartTitleTopBar()
    }
}

@Preview
@Composable
private fun StartTitleTopBarWithTitlePreview() {
    ShoppingCartTheme {
        StartTitleTopBar(
            title = "상품 상세"
        )
    }
}

@Preview
@Composable
private fun StartTitleTopBarWithNavigationBackPreview() {
    ShoppingCartTheme {
        StartTitleTopBar(
            title = "장바구니",
            navigationType = TopBarNavigationType.BACK,
        )
    }
}

@Preview
@Composable
private fun StartTitleTopBarWithActionCartPreview() {
    ShoppingCartTheme {
        StartTitleTopBar(
            title = "상품 상세",
            action = TopBarActionType.CART,
        )
    }
}

@Preview
@Composable
private fun StartTitleTopBarWithNavigationBackAndActionCartPreview() {
    ShoppingCartTheme {
        StartTitleTopBar(
            title = "상품 상세",
            navigationType = TopBarNavigationType.BACK,
            action = TopBarActionType.CART,
        )
    }
}
