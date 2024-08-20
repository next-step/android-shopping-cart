package nextstep.shoppingcart.ui.product.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.product.detail.component.PriceText
import nextstep.shoppingcart.ui.product.detail.component.ShoppingCartButton
import nextstep.shoppingcart.ui.theme.Black10
import nextstep.shoppingcart.ui.theme.Gray10

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    product: Product,
    onBack: () -> Unit,
    onShowShoppingCart: () -> Unit,
) {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.product_detail)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "backDetail",
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            Column(modifier = Modifier) {
                AsyncImage(
                    model = ImageRequest.Builder(context).data(product.imageUrl).crossfade(true)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "productImage",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                )

                Text(
                    text = product.name,
                    color = Black10,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(18.dp),
                )

                Divider(thickness = 1.dp, color = Gray10, modifier = Modifier.fillMaxWidth())

                PriceText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(18.dp),
                    price = product.price,
                )

                ShoppingCartButton(onShowShoppingCart = onShowShoppingCart)
            }
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview(
    @PreviewParameter(ProductDetailScreenPreviewParameterProvider::class) param: Product,
) {
    ProductDetailScreen(product = param, onBack = {}, onShowShoppingCart = {})
}

private class ProductDetailScreenPreviewParameterProvider : PreviewParameterProvider<Product> {
    override val values: Sequence<Product> = sequenceOf(
        Product(
            name = "iPhone 15 Pro Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        ),
        Product(
            name = "iPhone 15 Pro Max / MacBook Pro 16 M3 Max",
            imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            price = 1_900_000,
        ),
    )
}
