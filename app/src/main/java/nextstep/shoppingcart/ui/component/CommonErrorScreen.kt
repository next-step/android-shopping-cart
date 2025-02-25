package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CommonErrorScreen(onRetryButtonClick: () -> Unit, modifier: Modifier = Modifier.fillMaxSize()) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Button(onClick = onRetryButtonClick) { Text("다시 시도") }
    }
}

@Preview
@Composable
private fun CommonEmptyScreenPreview() {
    ShoppingCartTheme {
        CommonErrorScreen(onRetryButtonClick = {})
    }
}
