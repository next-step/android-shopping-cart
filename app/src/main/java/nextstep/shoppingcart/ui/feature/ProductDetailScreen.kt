package nextstep.shoppingcart.ui.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.domain.Product
import nextstep.shoppingcart.ui.feature.component.BottomActionButton
import nextstep.shoppingcart.ui.feature.component.PriceText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    productId: Int,
    onBackClick: () -> Unit,
    onAddCartClick: () -> Unit
) {
    val product = remember(productId) { Products.find { it.id == productId } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.product_detail_title)) },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.app_on_back_click)
                        )
                    }
                },
            )
        },
        bottomBar = {
            BottomActionButton(
                text = stringResource(id = R.string.product_detail_cart_button),
                onClick = { onAddCartClick() }
            )
        }
    ) { innerPadding ->
        if (product != null) {
            ProductDetail(
                product = product,
                modifier = Modifier.padding(innerPadding)
            )
        }

    }
}


@Composable
private fun ProductDetail(
    product: Product,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 1f),
            model = product.imageUrl,
            contentDescription = stringResource(id = R.string.product_image),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.padding(18.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            text = product.name,
            maxLines = 1
        )
        Divider()
        PricePairText(
            price = product.price,
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        )

    }
}

@Composable
private fun PricePairText(
    price: Int, modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.product_detail_price_label),
            fontSize = 20.sp
        )
        PriceText(price = price, fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview() {
    ProductDetailScreen(productId = Products.first().id, {}, {})
}
