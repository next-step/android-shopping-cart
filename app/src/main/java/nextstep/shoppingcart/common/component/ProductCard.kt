package nextstep.shoppingcart.common.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.model.Product
import nextstep.shoppingcart.common.model.dummyProducts
import nextstep.shoppingcart.common.theme.NextStepTheme

@Composable
internal fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(product.imageUrl)
            .crossfade(true)  // 페이드 인 애니메이션
            .error(R.drawable.ic_outline_image_not_supported_24)  // 로드 실패 시 표시할 이미지
            .placeholder(R.drawable.ic_outline_image_search_24)  // 로딩 중에 표시할 이미지
            .build(),
        contentDescription = product.name
    )
}

@Composable
@Preview
private fun ProductCardPreview() {
    NextStepTheme {
        ProductCard(
            product = dummyProducts.first(),
            modifier = Modifier.aspectRatio(1f)
        )
    }
}