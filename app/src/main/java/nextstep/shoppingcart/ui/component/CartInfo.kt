package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.CartItem
import nextstep.shoppingcart.Product
import nextstep.shoppingcart.R

@Composable
fun CartInfo(
    cartItem: CartItem,
    onRemoveClick: () -> Unit,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(size = 4.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Color.Gray
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(18.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
            ) {
                Text(
                    text = cartItem.product.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxHeight(),
                )
                IconButton(
                    onClick = onRemoveClick,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.content_description_remove_item, cartItem.product.name)
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AsyncImage(
                    model = cartItem.product.imageUrl,
                    contentDescription = cartItem.product.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(136.dp)
                        .height(84.dp),
                )
                Column(
                    modifier = Modifier.padding(
                        start = 26.dp,
                        top = 24.dp
                    ),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = stringResource(id = R.string.price_format, cartItem.totalPrice),
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.End,
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        IconButton(
                            onClick = onMinusClick,
                            modifier = Modifier.size(42.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.minus),
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                        Text(
                            text = cartItem.count.toString(),
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(horizontal = 14.dp)
                        )
                        IconButton(
                            onClick = onPlusClick,
                            modifier = Modifier.size(42.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.plus),
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CartInfoPreview() {
    val product = Product(
        imageUrl = "https://image.msscdn.net/images/goods_img/20240516/4135365/4135365_17161647453804_500.jpg",
        name = "링클 체크 박시 오버핏 롤업 하프 셔츠 블루",
        price = 37400
    )
    val cartItem = CartItem(
        product = product,
        count = 1
    )
    CartInfo(
        cartItem = cartItem,
        onRemoveClick = { },
        onMinusClick = { },
        onPlusClick = { }
    )
}