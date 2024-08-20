package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.data.cart.CartItem
import nextstep.shoppingcart.data.goods.Product
import nextstep.shoppingcart.ui.component.QuantitySelector
import nextstep.shoppingcart.ui.theme.cartTitleStyle

@Composable
fun CartProduct(
    item: CartItem,
    onRemoveClick: () -> Unit,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit
) {
    val product = item.product

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        border = BorderStroke(1.dp, Color.Gray),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            CartProductTitle(product, onRemoveClick)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = product.imageUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .width(136.dp)
                        .height(84.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.End
                ) {
                    Spacer(modifier = Modifier.height(18.dp))
                    Text(
                        text = "${product.price}원",
                        style = MaterialTheme.typography.titleMedium
                    )
                    QuantitySelector(
                        item.count,
                        onMinusClick,
                        onPlusClick
                    )
                }
            }
        }
    }
}

@Composable
private fun CartProductTitle(
    product: Product,
    onRemoveClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f),
            text = product.name,
            fontWeight = FontWeight.Bold,
            style = cartTitleStyle,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        IconButton(
            onClick = onRemoveClick,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                Icons.Default.Close,
                contentDescription = "Remove:${product.productId}"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CartProductPreview() {
    val cardItem = CartItem(
        Product(
            productId = 1,
            imageUrl = "https://picsum.photos/156/158",
            name = "상품 이름을 테스트해보겠습니다 말줄입이 되나요",
            price = 1200000000
        ), 1
    )
    CartProduct(
        cardItem,
        onRemoveClick = {},
        onMinusClick = {},
        onPlusClick = {}
    )
}