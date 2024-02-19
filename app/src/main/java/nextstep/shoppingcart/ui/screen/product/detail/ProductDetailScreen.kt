package nextstep.shoppingcart.ui.screen.product.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.component.PriceText
import nextstep.shoppingcart.ui.component.ProductImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    productId: Long,
    onClickBack: () -> Unit
) {
    val product = Product.fixture.find { it.id == productId } ?: return
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
            Text(
                modifier = Modifier.padding(all = 18.dp),
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Divider(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = Modifier
                    .padding(all = 18.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "금액",
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.weight(weight = 1f))
                PriceText(price = product.price, fontSize = 20.sp)
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ProductDetailScreen(
        productId = 1,
        onClickBack = {}
    )
}
