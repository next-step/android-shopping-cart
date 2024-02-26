package nextstep.shoppingcart.ui.screen.product.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.component.PriceText
import nextstep.shoppingcart.ui.component.ProductImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    productId: Long,
    onClickBack: () -> Unit
) {
    val product: Product = remember {
        Product.fixture.find { it.id == productId } ?: Product()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "상품 상세") },
                navigationIcon = {
                    IconButton(onClick = { onClickBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로가기"
                        )
                    }
                },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
        ) {
            ProductImage(product = product)
            ProductTitle(
                modifier = Modifier.padding(all = 18.dp),
                title = product.name
            )
            Divider(modifier = Modifier.fillMaxWidth())
            ProductPrice(
                modifier = Modifier.padding(all = 18.dp),
                price = product.price
            )
            Spacer(modifier = Modifier.weight(weight = 1f))
            BottomText(
                modifier = Modifier.padding(vertical = 15.dp),
                text = "장바구니 담기",
            )
        }
    }
}

@Composable
private fun BottomText(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(color = 0xFF2196F3))
            .clickable { },
        text = text,
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
    )
}

@Composable
private fun ProductPrice(
    modifier: Modifier,
    price: Int
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "금액",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.weight(weight = 1f))
        PriceText(price = price, fontSize = 20.sp)
    }
}

@Composable
private fun ProductTitle(
    modifier: Modifier,
    title: String
) {
    Text(
        modifier = modifier,
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Preview
@Composable
private fun Preview() {
    ProductDetailScreen(
        productId = 1,
        onClickBack = {}
    )
}

@Preview(
    name = "가로폭이 좁을 때",
    showBackground = true,
    widthDp = 100
)
@Composable
private fun Preview1() {
    ProductDetailScreen(
        productId = 1,
        onClickBack = {}
    )
}
