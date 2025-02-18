package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.model.CartItem
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.data.repository.ProductRepository
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme


@Composable
internal fun ProductCartItem(
    cartItem: CartItem,
    onRemoveClick: (Product) -> Unit,
    onIncreaseClick: (Product) -> Unit,
    onDecreaseClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color(0xFFAAAAAA),
                shape = ShapeDefaults.ExtraSmall
            )
            .padding(18.dp)
            .testTag("ProductCartItem"),
    ) {
        ProductCartItemTitle(
            modifier = Modifier.fillMaxWidth(),
            cartItem = cartItem,
            onRemoveClick = { onRemoveClick(cartItem.product) },
        )
        Row(
            modifier = Modifier
                .padding(top = 6.dp)
        ) {
            ProductImage(
                url = cartItem.productImageUrl,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(136.dp)
                    .height(84.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    modifier = Modifier.padding(top = 24.dp),
                    text = stringResource(R.string.price_format, cartItem.totalPrice),
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        lineHeight = 26.67.sp,
                        letterSpacing = 0.5.sp,
                    )
                )
                ProductCounter(
                    cartItem = cartItem,
                    onIncreaseClick = { onIncreaseClick(cartItem.product) },
                    onDecreaseClick = { onDecreaseClick(cartItem.product) },
                )
            }
        }
    }
}

@Composable
private fun ProductCartItemTitle(
    cartItem: CartItem,
    onRemoveClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = cartItem.productName,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp
            )
        )
        IconButton(
            modifier = Modifier
                .size(24.dp)
                .testTag("${cartItem.productName}_remove_button"),
            onClick = { onRemoveClick(cartItem.product) }
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "장바구니 항목 제거",
            )
        }
    }
}

@Composable
private fun ProductCounter(
    cartItem: CartItem,
    onIncreaseClick: (Product) -> Unit,
    onDecreaseClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    val textStyle = remember {
        TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            lineHeight = 18.67.sp,
            letterSpacing = 0.5.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
    val buttonSize = 42.dp
    Row(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(buttonSize)
                .testTag("${cartItem.productName}_decrease_button")
                .clickable {
                    onDecreaseClick(cartItem.product)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.decrease_symbol),
                style = textStyle
            )
        }
        Box(
            modifier = Modifier.sizeIn(minWidth = buttonSize, minHeight = buttonSize)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .testTag("${cartItem.productName}_count"),
                style = textStyle,
                fontWeight = FontWeight.Normal,
                text = cartItem.count.toString(),
            )
        }
        Box(
            modifier = Modifier
                .size(buttonSize)
                .testTag("${cartItem.productName}_increase_button")
                .clickable { onIncreaseClick(cartItem.product) },
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = stringResource(R.string.increase_symbol),
                style = textStyle
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ProductCartItemPreview() {
    var cartItem by remember {
        mutableStateOf(
            CartItem(
                product = ProductRepository.getProductById(1),
                count = 2,
            )
        )
    }
    ShoppingCartTheme {
        ProductCartItem(
            cartItem = cartItem,
            onRemoveClick = {},
            onIncreaseClick = { cartItem = cartItem.copy(count = cartItem.count.inc()) },
            onDecreaseClick = { cartItem = cartItem.copy(count = cartItem.count.dec()) },
        )
    }
}
