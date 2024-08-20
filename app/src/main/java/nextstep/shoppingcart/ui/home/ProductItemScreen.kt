package nextstep.shoppingcart.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.data.goods.Product
import nextstep.shoppingcart.ui.component.QuantitySelector
import nextstep.shoppingcart.ui.theme.productTitleStyle
import java.text.NumberFormat
import java.util.Locale

@Composable
fun ProductItem(
    product: Product,
    onClickItem: () -> Unit,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    itemCount: Int = 0
) {
    Column(
        modifier = Modifier
            .wrapContentWidth()
            .clickable(onClick = onClickItem)
    ) {
        Box(contentAlignment = Alignment.BottomEnd) {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )

            if (itemCount == 0) {
                AddProductButton(
                    onClick = onPlusClick,
                    Modifier.padding(12.dp)
                )
            } else {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(12.dp)
                ) {
                    QuantitySelector(
                        quantity = itemCount,
                        onMinusClick = onMinusClick,
                        onPlusClick = onPlusClick
                    )
                }
            }
        }

        Column(
            modifier = Modifier.padding(top = 4.dp, start = 4.dp)

        ) {
            Text(
                text = product.name,
                style = productTitleStyle,
                color = MaterialTheme.colorScheme.secondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${formatPrice(product.price)}원",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun AddProductButton(onClick: () -> Unit, modifier: Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(),
        modifier = modifier
            .size(42.dp)
    ) {
        IconButton(
            onClick = onClick, modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                imageVector = Icons.Filled.Add,
                contentDescription = "장바구니추가",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    val product = Product(
        productId = 1,
        imageUrl = "https://picsum.photos/156/158",
        name = "상품 이름을 테스트해보겠습니다 말줄입이 되나요",
        price = 1200000000
    )
    ProductItem(product, {}, {}, {}, 0)
}

fun formatPrice(price: Int): String {
    val format = NumberFormat.getNumberInstance(Locale.KOREA)
    format.maximumFractionDigits = 0  // 소수점 이하를 표시하지 않음
    return format.format(price)
}