package nextstep.shoppingcart.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun BasicIconButton(
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BasicIconButtonPreview(
    @PreviewParameter(BasicIconButtonProvider::class) param: BasicIconButtonPreviewParameter,
) {
    ShoppingCartTheme {
        BasicIconButton(
            imageVector = param.imageVector,
            onClick = param.onClick,
            contentDescription = param.contentDescription,
        )
    }
}

private data class BasicIconButtonPreviewParameter(
    val imageVector: ImageVector,
    val contentDescription: String? = null,
    val onClick: () -> Unit = {},
)

private class BasicIconButtonProvider : PreviewParameterProvider<BasicIconButtonPreviewParameter> {
    override val values: Sequence<BasicIconButtonPreviewParameter> =
        sequenceOf(
            BasicIconButtonPreviewParameter(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Navigate back",
            ),
            BasicIconButtonPreviewParameter(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping Cart",
            ),
        )
}
