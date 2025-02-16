package nextstep.shoppingcart.ui.productdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.blue50

@Composable
fun ProductDetailScreen(
    product: Product,
    onAddProductClick: () -> Unit,
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .statusBarsPadding(),
        topBar = { ProductDetailTopAppBar(onBackButtonClick = onBackButtonClick) }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            ProductDetailContent(
                product = product,
                modifier = Modifier.padding(paddingValues = innerPadding)
            )
            Button(
                onClick = onAddProductClick,
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = blue50,
                    contentColor = Color.White
                ),
                shape = RectangleShape,
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = stringResource(R.string.product_detail_btn_add_product_in_cart),
                    fontSize = 20.sp,
                    fontWeight = W700,
                )
            }
        }
    }
}

@Composable
private fun ProductDetailContent(
    product: Product,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "상품 상세 이미지",
            error = painterResource(id = R.drawable.ic_launcher_background),
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        Text(
            text = product.name,
            fontSize = 24.sp,
            fontWeight = W700,
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        )
        HorizontalDivider()
        Row(Modifier.padding(18.dp)) {
            Text(
                text = stringResource(R.string.product_detail_price_title),
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1f)
            )
            Text(
                text = stringResource(R.string.all_price_format, product.price),
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(3f),
                textAlign = TextAlign.End
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailTopAppBar(
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = "상품 상세") },
        navigationIcon = {
            IconButton(onClick = onBackButtonClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "상품 상세 뒤로가기"
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showSystemUi = true)
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            product = Product(
                id = 1,
                name = "PET보틀-원형(500ml)",
                price = 10000L,
                imageUrl = "https://picsum.photos/200",
            ),
            onAddProductClick = {},
            onBackButtonClick = {}
        )
    }
}