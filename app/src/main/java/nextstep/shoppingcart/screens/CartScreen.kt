package nextstep.shoppingcart.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.components.topbar.StartTitleTopBar
import nextstep.shoppingcart.components.topbar.TopBarNavigationType
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun CartScreen(
    onBackClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            StartTitleTopBar(
                title = stringResource(R.string.cart_top_bar_title),
                navigationType = TopBarNavigationType.BACK,
                onNavigationClick = onBackClick,
            )
        },
        containerColor = Color.White,
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Cart(modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun Cart(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        // TODO: 장바구니 화면 구현 (3단계 미션)
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen(
            onBackClick = {},
        )
    }
}
