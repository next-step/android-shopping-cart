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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.common.CommonTopAppBar
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
        topBar = {
            CommonTopAppBar(
                title = stringResource(R.string.product_detail_app_bar_title),
                onBackButtonClick = onBackButtonClick
            )
        },
        bottomBar = {
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
            ) {
                Text(
                    text = stringResource(R.string.product_detail_btn_add_product_in_cart),
                    fontSize = 20.sp,
                    fontWeight = W700,
                )
            }
        }
    ) { innerPadding ->
        ProductDetailContent(
            product = product,
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .verticalScroll(rememberScrollState())
        )
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
        ProductPriceContent(price = product.price, modifier = Modifier.padding(18.dp))
    }
}

@Composable
private fun ProductPriceContent(price: Long, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Text(
            text = stringResource(R.string.product_detail_price_title),
            fontSize = 20.sp,
            modifier = Modifier
                .weight(1f)
        )
        Text(
            text = stringResource(R.string.all_price_format, price),
            fontSize = 20.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .weight(3f)
        )
    }
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
