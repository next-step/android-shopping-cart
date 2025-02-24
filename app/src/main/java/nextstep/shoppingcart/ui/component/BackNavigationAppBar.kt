package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BackNavigationAppBar(
    title: String,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFF1D1B20),
            )
        },
        navigationIcon = {
            IconButton(
                modifier = Modifier
                    .size(48.dp)
                    .testTag("back_navigation"),
                onClick = onBackButtonClick
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun BackNavigationAppBarPreview(
    @PreviewParameter(PreviewProvider::class) title: String,
) {
    ShoppingCartTheme {
        BackNavigationAppBar(
            title = title,
            onBackButtonClick = {}
        )
    }
}

private class PreviewProvider : CollectionPreviewParameterProvider<String>(
    listOf(
        "상품 상세",
        "장바구니"
    )
)
