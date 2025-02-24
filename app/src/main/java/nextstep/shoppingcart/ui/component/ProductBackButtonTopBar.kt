package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductBackButtonTopBar(
    title: String,
    onBackButtonClick: () -> Unit,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            Icon(
                modifier = modifier
                    .clickable { onBackButtonClick() }
                    .padding(16.dp),
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = contentDescription
            )
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductBackButtonTopBarPreview() {
    ShoppingCartTheme {
        ProductBackButtonTopBar(
            title = "상품 상세",
            onBackButtonClick = {},
            contentDescription = "상품 상세 뒤로가기 버튼"
        )
    }
}
