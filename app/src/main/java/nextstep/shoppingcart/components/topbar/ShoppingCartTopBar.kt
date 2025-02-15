package nextstep.shoppingcart.components.topbar

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ShoppingCartTopBar(
    title: String,
    modifier: Modifier = Modifier,
    topBarType: TopBarType = TopBarType.CENTER,
    navigationType: TopBarNavigationType? = null,
    onNavigationClick: () -> Unit = {},
    action: TopBarActionType? = null,
    onActionClick: () -> Unit = {},
) {
    when (topBarType) {
        TopBarType.START -> {
            StartTitleTopBar(
                title = title,
                modifier = modifier,
                navigationType = navigationType,
                onNavigationClick = onNavigationClick,
                action = action,
                onActionClick = onActionClick,
            )
        }

        TopBarType.CENTER -> {
            CenterTitleTopBar(
                title = title,
                modifier = modifier,
                navigationType = navigationType,
                onNavigationClick = onNavigationClick,
                action = action,
                onActionClick = onActionClick
            )
        }
    }
}

internal enum class TopBarActionType(
    val icon: ImageVector,
    @StringRes val contentDescription: Int,
) {
    CART(
        icon = Icons.Filled.ShoppingCart,
        contentDescription = R.string.product_list_top_bar_action_cart,
    ),
}

internal enum class TopBarNavigationType(
    val icon: ImageVector,
    @StringRes val contentDescription: Int,
) {
    BACK(
        icon = Icons.AutoMirrored.Filled.ArrowBack,
        contentDescription = R.string.navigate_back,
    ),
}

internal enum class TopBarType {
    CENTER,
    START,
}

@Preview
@Composable
private fun ShoppingCartTopBarCenterTitlePreview() {
    ShoppingCartTheme {
        ShoppingCartTopBar(
            title = "상품 목록",
            topBarType = TopBarType.CENTER,
        )
    }
}

@Preview
@Composable
private fun ShoppingCartTopBarStartTitlePreview() {
    ShoppingCartTheme {
        ShoppingCartTopBar(
            title = "상품 목록",
            topBarType = TopBarType.START,
        )
    }
}
