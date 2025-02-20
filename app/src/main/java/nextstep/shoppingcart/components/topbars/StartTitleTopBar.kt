package nextstep.shoppingcart.components.topbars

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
    title: String,
    navigationType: TopBarNavigationType,
    onNavigationClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = navigationType.icon,
                    contentDescription = stringResource(navigationType.contentDescription),
                )
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
        StartTitleTopBar(
            title = "장바구니",
            navigationType = TopBarNavigationType.BACK,
            onNavigationClick = {},
        )
    }
}
