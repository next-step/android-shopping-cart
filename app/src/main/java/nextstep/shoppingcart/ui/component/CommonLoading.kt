package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CommonLoading(modifier: Modifier = Modifier.fillMaxSize()) {
    Box(modifier = modifier.testTag("CommonLoading"), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
private fun CommonLoadingPreview() {
    ShoppingCartTheme {
        CommonLoading()
    }
}
