package nextstep.shoppingcart.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import java.util.UUID

@Composable
internal fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.1f),
            model = ImageRequest.Builder(LocalContext.current)
                .data(product.imageUrl)
                .crossfade(true)  // 페이드 인 애니메이션
                .error(R.drawable.ic_outline_image_not_supported_24)  // 로드 실패 시 표시할 이미지
                .placeholder(R.drawable.ic_outline_image_search_24)  // 로딩 중에 표시할 이미지
                .build(),
            contentDescription = product.name
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(horizontal = 4.dp)
        ) {
            Text(
                text = product.name,
                style = TextStyle(
                    fontWeight = FontWeight.W700,
                    fontSize = 16.sp,
                    lineHeight = 14.sp,
                    letterSpacing = 0.5.sp,
                ),
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = stringResource(R.string.won_unit, product.price),
                style = TextStyle(
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    letterSpacing = 0.5.sp
                ),
            )
        }
    }
}

@Preview
@Composable
private fun ProductCardPreview() {
    MaterialTheme {
        ProductCard(
            product = Product(
                id = UUID.randomUUID().toString(),
                name = "PET보틀-정사각형처럼 보이는 예쁜 보틀을 팔아요",
                price = 10000,
                imageUrl = "https://picsum.photos/500",
            ),
            modifier = Modifier.width(156.dp)
        )
    }
}