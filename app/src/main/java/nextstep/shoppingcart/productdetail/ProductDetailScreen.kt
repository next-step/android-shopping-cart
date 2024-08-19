package nextstep.shoppingcart.productdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.NextStepTopAppBar
import nextstep.shoppingcart.model.Product
import java.text.NumberFormat
import java.util.Locale
import java.util.UUID

@Composable
internal fun ProductDetailScreen(
    product: Product,
    onAddToCartClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            NextStepTopAppBar(
                title = stringResource(R.string.product_details),
                onBackClick = onBackClick,
            )
        },
        content = { paddingValues ->
            ProductDetailContent(
                product = product,
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
            )
        },
        bottomBar = { ProductDetailBottomBar() }
    )
}

@Composable
private fun ProductDetailContent(
    product: Product,
    modifier: Modifier,
) {
    Column(
        modifier = modifier.verticalScroll(state = rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    drawLine(
                        color = Color(0xFFAAAAAA),
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = 1.dp.toPx(),
                    )
                }
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.imageUrl)
                    .crossfade(true)  // 페이드 인 애니메이션
                    .error(R.drawable.ic_outline_image_not_supported_24)  // 로드 실패 시 표시할 이미지
                    .placeholder(R.drawable.ic_outline_image_search_24)  // 로딩 중에 표시할 이미지
                    .build(),
                contentDescription = product.name
            )

            Text(
                text = product.name,
                style = TextStyle(
                    fontWeight = FontWeight.W700,
                    fontSize = 24.sp,
                    lineHeight = 28.sp,
                    letterSpacing = 0.5.sp,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextStyle(
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.W400,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
            ).let { style ->
                Text(
                    text = stringResource(R.string.amount_of_money),
                    style = style
                )

                Text(
                    text = stringResource(
                        R.string.amount_of_money_right,
                        NumberFormat.getNumberInstance(Locale.KOREA).format(product.price)
                    ),
                    style = style,
                )
            }
        }
    }
}

@Composable
private fun ProductDetailBottomBar() {
    Surface(
        shadowElevation = 4.dp,
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFF2196F3),
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.put_in_shopping_cart),
                modifier = Modifier.padding(vertical = 15.dp),
                style = TextStyle(
                    fontWeight = FontWeight.W700,
                    fontSize = 20.sp,
                    lineHeight = 23.44.sp,
                ),
                color = Color.White,
            )
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        product = Product(
            id = UUID.randomUUID().toString(),
            name = "PET보틀-원형(500ml)",
            price = 42_200,
            imageUrl = "https://picsum.photos/500",
        ),
        onBackClick = {},
        onAddToCartClick = {},
    )
}