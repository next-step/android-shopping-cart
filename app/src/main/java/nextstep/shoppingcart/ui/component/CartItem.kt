package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.CartItemInfo
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.Grey10

@Composable
fun CartItem(
    cartItemInfo: CartItemInfo,
    onClickIncrease: (Product) -> Unit,
    onClickDecrease: (Product) -> Unit,
    onClickDelete: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(size = 4.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Grey10
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = cartItemInfo.product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1
                )
                IconButton(
                    onClick = { onClickDelete(cartItemInfo.product) },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "뒤로 가기",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                AsyncImage(
                    model = cartItemInfo.product.imageUrl,
                    contentDescription = cartItemInfo.product.name,
                    modifier = Modifier
                        .size(width = 136.dp, height = 84.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    PriceLabel(
                        price = cartItemInfo.product.price,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Row(
                        modifier = Modifier.height(42.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        CounterButton("−") { onClickDecrease(cartItemInfo.product) }
                        Text(
                            text = "${cartItemInfo.count}",
                            modifier = Modifier
                                .fillMaxHeight()
                                .wrapContentSize(Alignment.Center)
                        )
                        CounterButton("+") { onClickIncrease(cartItemInfo.product) }
                    }
                }
            }
        }
    }
}

@Composable
fun CounterButton(title: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.size(42.dp)
    ) {
        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartItemPreview() {
    val product =  Product(name = "[든든] 동원 스위트콘", imageUrl = "", price = 99800)
    CartItem(
        cartItemInfo = CartItemInfo(
            product = product,
            count = 1
        ),
        onClickIncrease = { },
        onClickDecrease = { },
        onClickDelete = { }
    )
}
