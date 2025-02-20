package nextstep.shoppingcart.ui.screen.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BackIconButton(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    IconButton(
        modifier = modifier,
        onClick = onBackClick,
    ) {
        Icon(Icons.Filled.ArrowBack, contentDescription = "Back Button")
    }
}

@Preview(showBackground = true)
@Composable
private fun BackIconButtonPreview() {
    BackIconButton(onBackClick = { })
}