package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
    onTopBarButtonClick: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            ProductListTopAppBar(
                onClickButton = onTopBarButtonClick
            )
        },
        content = { _ -> }
    )
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ProductListScreen {}
}
