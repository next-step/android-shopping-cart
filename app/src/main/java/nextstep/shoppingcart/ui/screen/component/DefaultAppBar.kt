package nextstep.shoppingcart.ui.screen.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar(
    title: String,
    navigationIcon: @Composable (() -> Unit)?,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(title)
        },
        modifier = modifier,
        navigationIcon = { navigationIcon }
    )
}

@Preview(showBackground = true)
@Composable
private fun DefaultAppBarPreview() {
    DefaultAppBar(
        title = "상품 상세",
        navigationIcon = { }
    )
}