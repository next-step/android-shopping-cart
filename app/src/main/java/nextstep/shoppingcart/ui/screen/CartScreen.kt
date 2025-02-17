package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.BackNavigationTopBar

@Composable
fun CartScreen(
    onBackPressed: () -> Unit,
) {
    Scaffold(
        topBar = {
            BackNavigationTopBar(
                title = stringResource(id = R.string.product_cart_title),
                onBackPressed = onBackPressed,
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    CartScreen(
        onBackPressed = {},
    )
}