package nextstep.shoppingcart.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import nextstep.shoppingcart.R
import nextstep.shoppingcart.view.DefaultNavigationBackTopBar

@Composable
fun CartScreen(
    onClickBack: () -> Unit,
) {
    Scaffold(
        topBar = {
            DefaultNavigationBackTopBar(
                title = stringResource(id = R.string.cart_top_bar_title),
                onClickBack = onClickBack
            )
        }
    ) { paddingValues ->
        CartContent(
            modifier = Modifier
                .padding(paddingValues)
        )
    }
}

@Composable
private fun CartContent(
    modifier: Modifier = Modifier,
) {

}