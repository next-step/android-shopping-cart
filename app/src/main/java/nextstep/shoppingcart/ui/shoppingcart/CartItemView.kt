package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.Gray10
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartItemView(
    item: CartItem,
    modifier: Modifier = Modifier,
    onAdd: (Product) -> Unit = {},
    onRemove: (Product) -> Unit = {},
    onDelete: (Product) -> Unit = {},
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Gray10),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Column(
            modifier = modifier.padding(18.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = item.product.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)

                // 닫기 버튼
                IconButton(onClick = {
                    onDelete(item.product)
                }) {
                    Icon(Icons.Default.Close, contentDescription = "삭제")
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                AsyncImage(
                    modifier = Modifier.size(width = 136.dp, height = 84.dp),
                    model = item.product.imageUrl,
                    placeholder = painterResource(R.drawable.ic_photo),
                    error = painterResource(R.drawable.ic_photo),
                    contentDescription = item.product.name,
                    contentScale = ContentScale.Fit
                )

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = item.product.getFormattedPrice(),
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        IconButton(onClick = { onRemove(item.product) }) {
                            Icon(
                                painter = painterResource(R.drawable.ic_remove),
                                contentDescription = "빼기"
                            )
                        }
                        Text(
                            text = item.count.toString(),
                            fontSize = 23.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                        IconButton(onClick = { onAdd(item.product) }) {
                            Icon(Icons.Filled.Add, contentDescription = "추가")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CartItemPreview() {
    ShoppingCartTheme {
        CartItemView(
            item = CartItem(
                product = Product(
                    imageUrl = "https://s3-alpha-sig.figma.com/img/fd20/b2b8/827d18cb936f84b3d7ab156b54952df7?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=mV~26532GM~FVWvuulYCjYZTlP9AhkSmZT7aeIbznHveYv5e0Vq8wh0FK6Ja7JvuV5Z7ixdE5KKw5J1B1rIG6i0ySx545Wft3ujyRHafo264bPrkohy6mDoaJx03my9weXbRtBZ0lygdiSwg9VJgBNSZDK7zWK6fawbfZNmy1ULnZznFzfgAe~GgSGBeOxkT6Fj13Gg8wiAXFLNy577pWqVGAEUTq-IZ-iL6513UJ-dYVCajNeA4158pmaEse7MzKg~bNUr6qoYEJ9fHUBHmuCNKSTnX3H2ojNDzJ~dYmcM30V44FoB-0wL~hUA4Iz-tl1GgAc4QbKXqqzpbEU~-0g__",
                    name = "[든든] 동원 스위트콘",
                    price = 99800
                ),
                count = 1
            ),
        )
    }
}