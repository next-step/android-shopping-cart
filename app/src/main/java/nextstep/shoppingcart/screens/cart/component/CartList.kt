package nextstep.shoppingcart.screens.cart.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import nextstep.shoppingcart.R
import nextstep.shoppingcart.components.ItemCounter
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Count
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.theme.GrayAAAAAA
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
internal fun CartList(
    cart: Cart,
    onAddOneClick: (Product) -> Unit,
    onRemoveOneClick: (Product) -> Unit,
    onRemoveAllClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier,
    ) {
        items(key = { it.product.id }, items = cart.items) { cartItem ->
            CartItem(
                cartItem = cartItem,
                onAddOneClick = { onAddOneClick(cartItem.product) },
                onRemoveOneClick = { onRemoveOneClick(cartItem.product) },
                onRemoveAllClick = { onRemoveAllClick(cartItem.product) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp),
            )
        }
    }
}

@Composable
private fun CartItem(
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
        CartItemHeader(
            title = cartItem.product.name,
            onRemoveAllClick = onRemoveAllClick,
            modifier = Modifier.fillMaxWidth(),
        )
        Row {
            CartItemImage(
                product = cartItem.product,
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1.6f),
            )
            Spacer(Modifier.width(26.dp))
            Column(modifier = Modifier.weight(1f)) {
                Spacer(Modifier.height(24.dp))
                Text(
                    text = stringResource(R.string.price_format, cartItem.product.price.value),
                    textAlign = TextAlign.End,
                    style = Typography.bodyLarge,
                    modifier = Modifier.fillMaxWidth()
                )
                ItemCounter(
                    count = cartItem.count.value,
                    onRemoveOneClick = onRemoveOneClick,
                    onAddOneClick = onAddOneClick,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
    }
}

@Composable
private fun CartItemHeader(
    title: String,
    onRemoveAllClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
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
@OptIn(ExperimentalGlideComposeApi::class)
private fun CartItemImage(product: Product, modifier: Modifier = Modifier) {
    GlideImage(
        model = product.imageUrl,
        contentDescription = product.name,
        loading = placeholder(R.drawable.ic_launcher_background),
        failure = placeholder(ColorPainter(GrayAAAAAA)),
        contentScale = ContentScale.Crop,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun CartListPreview() {
    ShoppingCartTheme {
        CartList(
            cart = Cart(
                initialItems = FakeProductRepository
                    .getAllProducts()
                    .value
                    .map { CartItem(it) }
            ),
            onAddOneClick = {},
            onRemoveOneClick = {},
            onRemoveAllClick = {},
        )
    }
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
