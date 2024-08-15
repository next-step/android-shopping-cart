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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.model.CartItem

@Composable
internal fun CartItemCard(
    cartItem: CartItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.1f),
            model = cartItem.imageUrl,
            contentDescription = cartItem.name
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(horizontal = 4.dp)
        ) {
            Text(
                text = cartItem.name,
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
                text = "${cartItem.price}원",
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
private fun CartItemCardPreview() {
    MaterialTheme {
        CartItemCard(
            cartItem = CartItem(
                name = "PET보틀-정사각형처럼 보이는 예쁜 보틀을 팔아요",
                price = 10000f,
                imageUrl = "https://picsum.photos/500",
            ),
            modifier = Modifier.width(156.dp)
        )
    }
}