package nextstep.shoppingcart.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.productList
import nextstep.shoppingcart.ui.theme.Gray10

@Composable
fun CartItemComponent(
    cartItem: CartItem,
    onPlusClick : () -> Unit,
    onMinusClick : () -> Unit,
    onCloseClick : () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(4.dp),
    borderStroke: BorderStroke = BorderStroke(width = 1.dp, color = Gray10)
) {
    Column(
        modifier = modifier
            .border(
                border = borderStroke,
                shape = shape
            )
            .padding(18.dp)
    ) {
        CartItemHeader(
            product = cartItem.product,
            onCloseClick = onCloseClick
        )
        Row(
            modifier = Modifier.padding(top = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(26.dp)
        ) {
            CartItemImage(
                modifier = Modifier
                    .height(84.dp)
                    .width(136.dp),
                product = cartItem.product
            )

            Column(
                modifier = Modifier.fillMaxWidth().height(84.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                CartItemPrice(
                    product = cartItem.product
                )
                CartItemCount(
                    count = cartItem.count,
                    onPlusClick = onPlusClick,
                    onMinusClick = onMinusClick
                )
            }
        }


    }
}

@Composable
fun CartItemHeader(
    product: Product,
    onCloseClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f),
            text = product.name,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Image(
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    onCloseClick()
                },
            imageVector = Icons.Default.Close,
            contentDescription = "close"
        )
    }
}

@Composable
fun CartItemImage(
    product: Product,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        modifier = modifier,
        model = product.imageUrl,
        contentDescription = product.name,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun CartItemPrice(
    product: Product,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = stringResource(id = R.string.shopping_list_price_korean, product.price),
        style = MaterialTheme.typography.bodyLarge.copy(
            lineHeight = 20.sp
        )
    )
}

@Composable
fun CartItemCount(
    count: Int,
    onPlusClick : () -> Unit,
    onMinusClick : () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onMinusClick
        ) {
            Text(
                text = "-",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Text(
            modifier = Modifier.width(30.dp),
            text = "$count",
            style = MaterialTheme.typography.titleLarge.copy(
                lineHeight = 20.sp
            ),
            maxLines = 1,
            textAlign = TextAlign.Center
        )
        IconButton(
            onClick = onPlusClick
        ) {
            Text(
                text = "+",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}

@Preview(name = "CartItemPreview")
@Composable
private fun Preview1() {
    CartItemComponent(
        cartItem = CartItem(
            product = productList.get(0),
            count = 0
        ),
        onPlusClick = {},
        onMinusClick = {},
        onCloseClick = {}
    )
}
