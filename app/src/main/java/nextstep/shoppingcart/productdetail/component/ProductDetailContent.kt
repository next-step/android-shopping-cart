package nextstep.shoppingcart.productdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.component.ProductBottomButton
import nextstep.shoppingcart.ui.component.ProductImage
import nextstep.shoppingcart.util.translateNumberMoneyFormat

@Composable
fun ProductDetailContent(
    product: Product,
    onAddToCartButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            ProductImage(
                imageUrl = product.imageUrl,
                contentDescription = "${product.name} 이미지",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Text(
                product.name,
                modifier = Modifier.padding(18.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            HorizontalDivider(thickness = 1.dp, color = Color(0xFFAAAAAA))
            ProductInfoTowText(
                modifier = Modifier.padding(18.dp),
                leftText = "금액",
                rightText = translateNumberMoneyFormat(product.price)
            )

        }
        ProductBottomButton(
            buttonText = "장바구니 담기",
            onClick = { onAddToCartButtonClick() },
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .background(Color(0xFF2196F3))
                .aspectRatio(360f / 54f)
                .align(alignment = Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailContentPreview() {
    ProductDetailContent(
        product = Product(
            name = "PET 보틀 - 음료수,정사각형 음료수,정사각형 음료수,정사각형 음료수",
            imageUrl = "https://i.namu.wiki/i/rwoGbf-OhaV1A1I77FtQEWojKsa-i9J0HZ0E3tFfr4gdi7fCHRh7DwaqLkLzKdruftxpu_twLfkhwgMxc3QrvgY9HhwbwB7W_YPGbkjpCIxFO9abcyQSLgM8NVUkKJ6WPegKkT35ukb0NXXRHeMW1zGcxZz_9zx63o9Pnat6I3Q.webp",
            price = 10000,
            productId = "id1"
        ), {}
    )
}
