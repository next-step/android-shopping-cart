package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.component.preview.ActionButtonParameterProvider
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 8.dp),
        onClick = onClick,
        shape = RectangleShape,
        enabled = enabled,
    ) {
        Text(
            text = text,
            style = Typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ActionButtonPreview(
    @PreviewParameter(ActionButtonParameterProvider::class) text: String,
) {
    ShoppingCartTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter,
        ) {
            ActionButton(
                text = text,
                onClick = {},
            )
        }
    }
}