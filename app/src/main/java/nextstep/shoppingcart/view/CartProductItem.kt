package nextstep.shoppingcart.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.model.CartItem

@Composable
fun CartProductItem(
    cartItem: CartItem,
    modifier: Modifier = Modifier,
    onClickRemoveAll: () -> Unit = { },
    onClickAddOne: () -> Unit = { },
    onClickRemoveOne: () -> Unit = { }
) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .fillMaxWidth(),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContainerColor = Color.White,
            disabledContentColor = Color.Black
        ),
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = cartItem.product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                IconButton(
                    onClick = onClickRemoveAll,
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(Icons.Filled.Close, null)
                }
            }

            Spacer(
                modifier = Modifier.size(6.dp)
            )

            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                AsyncImage(
                    model = cartItem.product.imageUrl,
                    contentDescription = "product image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(width = 136.dp, height = 84.dp)
                        .align(Alignment.TopStart)
                )

                Text(
                    text = cartItem.product.formattedPrice,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 18.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.align(Alignment.BottomEnd)
                ) {
                    IconButton(
                        onClick = onClickRemoveOne,
                        modifier = Modifier.size(42.dp)
                    ) {
                        Text(
                            text = "-",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = cartItem.count.toString(),
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 18.dp)
                    )
                    IconButton(
                        onClick = onClickAddOne,
                        modifier = Modifier.size(42.dp)
                    ) {
                        Text(
                            text = "+",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartProductItemPreview() {
    CartProductItem(
        cartItem = CartItem(
            product = nextstep.shoppingcart.model.Product.mock,
            count = 2
        )
    )
}