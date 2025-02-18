package nextstep.shoppingcart.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.TypoTokens.Bold20

@Composable
fun DetailOrderButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(Color.Blue)
            .padding(vertical = 15.dp)
    ) {
        Text(
            stringResource(R.string.detail_put_in_cart),
            style = Bold20.copy(color = Color.White),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun DetailOrderButtonPreview() {
    DetailOrderButton()
}
