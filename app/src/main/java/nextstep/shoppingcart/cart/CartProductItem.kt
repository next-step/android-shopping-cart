package nextstep.shoppingcart.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.ProductImage
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.dummyCartItem
import nextstep.shoppingcart.ui.theme.Gray10
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartProductItem(
    cartItem: CartItem,
    onCloseClick: () -> Unit,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = Color.White, shape = RoundedCornerShape(4.dp))
            .border(width = 1.dp, color = Gray10, shape = RoundedCornerShape(4.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = cartItem.product.name,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            IconButton(
                modifier = Modifier
                    .size(24.dp)
                    .testTag(stringResource(R.string.delete)),
                onClick = onCloseClick
            ) {
                Icon(
                    modifier = Modifier.size(14.dp),
                    imageVector = Icons.Filled.Close,
                    contentDescription = stringResource(R.string.delete)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            ProductImage(
                modifier = Modifier
                    .weight(1f)
                    .height(84.dp),
                imageUrl = cartItem.product.imageUrl,
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.Bottom)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(stringResource(R.string.product_price)),
                    text = stringResource(R.string.format_price_won, cartItem.totalPrice),
                    textAlign = TextAlign.End
                )

                CounterButton(
                    modifier = Modifier.align(Alignment.End),
                    quantity = cartItem.count,
                    onPlusClick = onPlusClick,
                    onMinusClick = onMinusClick
                )
            }
        }
    }
}

@Composable
private fun CounterButton(
    quantity: Int,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.background(color = Color.White, shape = RoundedCornerShape(4.dp))
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clickable(onClick = onMinusClick)
                .testTag(stringResource(R.string.minus))
            ,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.minus),
                style = MaterialTheme.typography.titleLarge
            )
        }

        Box(
            modifier = Modifier
                .size(42.dp)
                .testTag(stringResource(R.string.product_count)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = quantity.toString(),
                style = MaterialTheme.typography.titleLarge
            )
        }

        Box(
            modifier = Modifier
                .size(42.dp)
                .clickable(onClick = onPlusClick)
                .testTag(stringResource(R.string.plus)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.plus),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemPreview() {
    ShoppingCartTheme {
        CartProductItem(
            cartItem = dummyCartItem,
            onCloseClick = {},
            onPlusClick = {},
            onMinusClick = {}
        )
    }
}

@Preview
@Composable
private fun CounterButtonPreview() {
    ShoppingCartTheme {
        CounterButton(
            quantity = 1,
            onPlusClick = {},
            onMinusClick = {}
        )
    }
}