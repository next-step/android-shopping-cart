package nextstep.shoppingcart.ui.product.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.domain.model.Product

@Composable
internal fun ProductDetailScreen(
    productId: String,
    onBackClick: () -> Unit,
) {
    val product = Products.find { it.id == productId }

    if (product != null) {
        ProductDetailScreen(
            product = product,
            onBackClick = onBackClick,
            modifier = Modifier.testTag("상품상세")
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProductDetailScreen(
    product: Product,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "상품 상세") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로가기",
                        )
                    }
                },
            )
        },
        content = { innerPadding ->
            Text("상품 상세", modifier = Modifier.padding(innerPadding))
        },
        modifier = modifier,
    )
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    MaterialTheme {
        ProductDetailScreen(
            product = Products[0],
            onBackClick = { },
        )
    }
}
