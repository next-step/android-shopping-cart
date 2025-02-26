package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CommonEmptyScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = "텅", fontSize = 50.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
private fun CommonEmptyScreenPreview() {
    ShoppingCartTheme {
        CommonEmptyScreen()
    }
}
