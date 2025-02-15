package nextstep.shoppingcart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.theme.Blue2196F3
import nextstep.shoppingcart.ui.theme.GrayAAAAAA
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
internal fun MainButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .defaultMinSize(minWidth = 100.dp, minHeight = 54.dp)
            .background(color = if (enabled) Blue2196F3 else GrayAAAAAA)
            .clickable(
                enabled = enabled,
                onClick = onClick,
                role = Role.Button,
            )
            .then(modifier),
    ) {
        Text(
            text = text,
            style = Typography.titleLarge.copy(fontWeight = FontWeight.W700),
            color = Color.White,
        )
    }
}

@Preview
@Composable
private fun MainButtonPreview() {
    ShoppingCartTheme {
        MainButton(
            text = "장바구니",
            onClick = {},
            modifier = Modifier,
        )
    }
}

@Preview
@Composable
private fun MainButtonCustomSizePreview() {
    ShoppingCartTheme {
        MainButton(
            text = "장바구니 담기",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
        )
    }
}

@Preview
@Composable
private fun MainButtonDisabledPreview() {
    ShoppingCartTheme {
        MainButton(
            text = "장바구니",
            onClick = {},
            enabled = false,
        )
    }
}


