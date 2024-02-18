package nextstep.shoppingcart.ui.product.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.domain.model.Product

@Composable
internal fun ProductDetailScreen(
    productId: String,
    onBackClick: () -> Unit,
    onProductAddClick: () -> Unit,
) {
    val product = Products.find { it.id == productId }

    if (product != null) {
        ProductDetailScreen(
            product = product,
            onBackClick = onBackClick,
            onProductAddClick = onProductAddClick,
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    AsyncImage(
                        model = product.imageUrl,
                        contentDescription = "상품 이미지",
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .background(Color(0xFFE9E9E9)),
                        contentScale = ContentScale.Crop,
                    )

                    Text(
                        text = product.name,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                    )

                    Divider()

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = ButtonDefaults.MinHeight)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = stringResource(id = R.string.product_detail_price),
                                style = MaterialTheme.typography.bodyMedium,
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = stringResource(
                                    id = R.string.product_detail_price_fmt,
                                    product.price
                                ),
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .background(Color(0xFF2196F3))
                        .fillMaxWidth()
                        .clickable(onClick = onProductAddClick)
                        .padding(12.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = stringResource(id = R.string.product_detail_button),
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                        color = Color.White,
                    )
                }
            }
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
            onProductAddClick = { },
        )
    }
}
