package nextstep.shoppingcart.cart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CartScreen(
    onBackButtonClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            CartTopAppBar(onBackButtonClick = onBackButtonClick)
        },
        containerColor = Color.White,
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPreview() {
    CartScreen()
}