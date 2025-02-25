package nextstep.shoppingcart.ui.screen.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CloseIconButton(
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(Icons.Filled.Close, contentDescription = contentDescription)
    }
}

@Preview
@Composable
private fun CloseIconButtonPreview() {
    CloseIconButton(
        onClick = { },
        contentDescription = "Close"
    )
}