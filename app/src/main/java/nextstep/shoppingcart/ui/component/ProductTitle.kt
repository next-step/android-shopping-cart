package nextstep.shoppingcart.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProductTitle(
    title: String,
    style: TextStyle,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = style,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun ProductTitlePreview() {
    ProductTitle(
        title = "Cut Off Curved Denim Pants - Black",
        style = MaterialTheme.typography.titleMedium
    )
}