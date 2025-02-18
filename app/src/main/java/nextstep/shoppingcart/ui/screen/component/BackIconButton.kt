package nextstep.shoppingcart.ui.screen.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BackIconButton(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onBackClick,
        modifier = modifier,
    ) {
        Icon(Icons.Filled.ArrowBack, contentDescription = "Back Button")
    }
}