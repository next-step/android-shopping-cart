package nextstep.shoppingcart.detail.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.BottomLargeButton

@Composable
fun DetailOrderButton(
    onClickButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BottomLargeButton(
        text = stringResource(R.string.detail_put_in_cart),
        onClickButton = onClickButton,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun DetailOrderButtonPreview() {
    DetailOrderButton({})
}
