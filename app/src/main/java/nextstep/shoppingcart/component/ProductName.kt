package nextstep.shoppingcart.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import nextstep.shoppingcart.ui.theme.Black33

@Composable
fun ProductName(
    name: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    Text(
        text = name,
        modifier = modifier,
        color = Black33,
        fontSize = fontSize,
        fontWeight = FontWeight.W700,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductNamePreview() {
    ProductName("상품이름")
}