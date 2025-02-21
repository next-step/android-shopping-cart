package nextstep.shoppingcart.features.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.components.ItemCounter
import nextstep.shoppingcart.components.ProductImage
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Count
import nextstep.shoppingcart.ui.theme.GrayAAAAAA
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
internal fun CartItem(
    cartItem: CartItem,
    onAddOneClick: () -> Unit,
    onRemoveOneClick: () -> Unit,
    onRemoveAllClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(4.dp)

    Column(
        modifier = modifier
            .background(color = Color.White, shape = shape)
            .border(
                width = 1.dp,
                color = GrayAAAAAA,
                shape = shape,
            )
            .padding(18.dp),
    ) {
        CartItemTitle(
            title = cartItem.product.name,
            onRemoveAllClick = onRemoveAllClick,
        )
        CartItemContent(
            cartItem = cartItem,
            onRemoveOneClick = onRemoveOneClick,
            onAddOneClick = onAddOneClick,
        )
    }
}

@Composable
private fun CartItemTitle(
    title: String,
    onRemoveAllClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            text = title,
            style = Typography.titleLarge.copy(fontWeight = FontWeight.W700)
        )
        IconButton(onClick = onRemoveAllClick) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = stringResource(R.string.cart_item_remove_all_decription),
            )
        }
    }
}

@Composable
private fun CartItemContent(
    cartItem: CartItem,
    onRemoveOneClick: () -> Unit,
    onAddOneClick: () -> Unit,
) {
    Row {
        ProductImage(
            imageUrl = cartItem.product.imageUrl,
            contentDescription = cartItem.product.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1.6f),
        )
        Spacer(Modifier.width(26.dp))
        Column(modifier = Modifier.weight(1f)) {
            Spacer(Modifier.height(24.dp))
            CartItemPrice(price = cartItem.product.price.value)
            ItemCounter(
                count = cartItem.count.value,
                onRemoveOneClick = onRemoveOneClick,
                onAddOneClick = onAddOneClick,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun CartItemPrice(price: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.price_format, price),
        textAlign = TextAlign.End,
        style = Typography.bodyLarge,
        modifier = modifier.fillMaxWidth(),
    )
}

@Preview
@Composable
private fun CartItemPreview() {
    ShoppingCartTheme {
        CartItem(
            cartItem = CartItem(
                product = FakeProductRepository.getFirstProduct(),
                count = Count.ONE
            ),
            onAddOneClick = {},
            onRemoveAllClick = {},
            onRemoveOneClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemTitlePreview() {
    ShoppingCartTheme {
        CartItemTitle(
            title = "Wireless Mouse",
            onRemoveAllClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemContentPreview() {
    ShoppingCartTheme {
        CartItemContent(
            onAddOneClick = { },
            cartItem = CartItem(
                product = FakeProductRepository.getFirstProduct(),
                count = Count.ONE
            ),
            onRemoveOneClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemPricePreview() {
    ShoppingCartTheme {
        CartItemPrice(price = 10000)
    }
}
