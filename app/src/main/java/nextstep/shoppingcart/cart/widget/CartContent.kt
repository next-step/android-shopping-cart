package nextstep.shoppingcart.cart.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.cart.component.CartOrderButton

@Composable
fun CartContent(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        CartOrderButton(
            price = 0,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
        )
    }
}

@Preview
@Composable
private fun CartContentPreview() {
    CartContent()
}
