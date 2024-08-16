package nextstep.shoppingcart.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun AppBarIcon(
    imageVector: ImageVector,
    onClick: () -> Unit = {},
    contentDescription: String? = null,
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = imageVector,
            contentDescription = contentDescription,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AppBarIconPreview(
    @PreviewParameter(AppBarIconProvider::class) param: AppBarIconPreviewParameter,
) {
    ShoppingCartTheme {
        AppBarIcon(
            imageVector = param.imageVector,
            onClick = param.onClick,
            contentDescription = param.contentDescription,
        )
    }
}

private data class AppBarIconPreviewParameter(
    val imageVector: ImageVector,
    val contentDescription: String? = null,
    val onClick: () -> Unit = {},
)

private class AppBarIconProvider : PreviewParameterProvider<AppBarIconPreviewParameter> {
    override val values: Sequence<AppBarIconPreviewParameter> =
        sequenceOf(
            AppBarIconPreviewParameter(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Navigate back",
            ),
            AppBarIconPreviewParameter(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping Cart",
            ),
        )
}
