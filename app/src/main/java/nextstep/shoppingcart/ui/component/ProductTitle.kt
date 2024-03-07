package nextstep.shoppingcart.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@Composable
fun ProductTitle(
    modifier: Modifier,
    title: String,
    fontSize: TextUnit
) {
    Text(
        modifier = modifier,
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = fontSize,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}
