package nextstep.shoppingcart.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.components.ShoppingCartTopBar
import nextstep.shoppingcart.components.ShoppingCartTopBarActionType
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun MainScreen(onActionClick: () -> Unit) {
    Scaffold(
        topBar = {
            ShoppingCartTopBar(
                title = R.string.item_list_top_bar_title,
                action = ShoppingCartTopBarActionType.CART,
                onActionClick = onActionClick,
            )
        },
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        ItemListScreen(modifier = Modifier.padding(paddingValues))
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    ShoppingCartTheme {
        MainScreen(
            onActionClick = {},
        )
    }
}
