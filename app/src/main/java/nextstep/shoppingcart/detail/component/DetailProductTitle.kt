package nextstep.shoppingcart.detail.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.ui.theme.TypoTokens.Bold24

@Composable
fun DetailProductTitle(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = name,
        style = Bold24,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun DetailProductTitlePreview() {
    DetailProductTitle("상품 이름")
}
