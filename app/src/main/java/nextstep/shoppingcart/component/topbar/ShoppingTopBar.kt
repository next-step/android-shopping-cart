package nextstep.shoppingcart.component.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingTopBar(
    modifier: Modifier = Modifier,
    title : String = "",
    titleTextAlign: TextAlign = TextAlign.Center,
    leftActionButtons: @Composable () -> Unit = {},
    rightActionButtons: @Composable () -> Unit = {},
) {
    Row(
        modifier = modifier
            .height(64.dp)
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        leftActionButtons()
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            style = MaterialTheme.typography.titleLarge,
            textAlign = titleTextAlign
        )
        rightActionButtons()
    }
}