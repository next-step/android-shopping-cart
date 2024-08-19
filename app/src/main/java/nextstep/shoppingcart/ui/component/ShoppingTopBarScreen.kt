package nextstep.shoppingcart.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun ShoppingTopBar(title: String, onBackClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.secondary
            )
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        }
    )
}

@Preview
@Composable
private fun ShoppingTopBarPreview() {
    ShoppingTopBar(title = "상품 상세") {

    }
}
