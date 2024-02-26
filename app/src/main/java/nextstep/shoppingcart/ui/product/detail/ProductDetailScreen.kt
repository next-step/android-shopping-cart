package nextstep.shoppingcart.ui.product.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.CartRepository
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.component.CartButton
import nextstep.shoppingcart.ui.component.ProductImage

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
            onProductAddClick = {
                CartRepository.addToCart(product)
            },
            modifier = Modifier.testTag("상품상세")
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProductDetailScreen(
    product: Product,
    onBackClick: () -> Unit,
    onProductAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(id = R.string.product_detail_title)) },
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
            ProductDetailContent(
                product = product,
                onProductAddClick = onProductAddClick,
                modifier = Modifier.padding(innerPadding),
            )
        },
        modifier = modifier,
    )
}

@Composable
private fun ProductDetailContent(
    product: Product,
    onProductAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = ButtonDefaults.MinHeight)
        ) {
            ProductImage(
                imageUrl = product.imageUrl,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(Color(0xFFE9E9E9)),
                contentScale = ContentScale.Crop,
            )
            ProductNameText(product.name, modifier = Modifier.padding(16.dp))
            Divider()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                ProductDetailItem(
                    label = stringResource(id = R.string.product_detail_price),
                    text = stringResource(id = R.string.product_detail_price_fmt, product.price)
                )
            }
        }
        CartButton(
            text = stringResource(id = R.string.product_detail_button),
            onClick = onProductAddClick,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}

@Composable
private fun ProductNameText(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier,
        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
    )
}

@Composable
private fun ProductDetailItem(label: String, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = text, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    MaterialTheme {
        ProductDetailScreen(
            product = Products[0],
            onBackClick = { },
            onProductAddClick = { },
        )
    }
}
