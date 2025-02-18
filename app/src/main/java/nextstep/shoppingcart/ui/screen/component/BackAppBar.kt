package nextstep.shoppingcart.ui.screen.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackAppBar(
    title: String,
    navigationIcon: @Composable (() -> Unit),
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(title)
        },
        modifier = modifier,
        navigationIcon = navigationIcon
    )
}