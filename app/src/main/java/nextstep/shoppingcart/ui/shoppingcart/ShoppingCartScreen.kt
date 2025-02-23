package nextstep.shoppingcart.ui.shoppingcart

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.components.ShoppingCartButton
import nextstep.shoppingcart.ui.components.CommonTopAppBar
import nextstep.shoppingcart.ui.components.ShoppingCartNumberCounter
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingCartScreen(
    cartItems: List<CartItem>,
    totalPrice: Long,
    onBackButtonClick: () -> Unit,
    onAddProductClick: (Product) -> Unit,
    onRemoveProductClick: (Product) -> Unit,
    onRemoveAllProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .statusBarsPadding(),
        topBar = {
            CommonTopAppBar(
                title = stringResource(R.string.shopping_cart_app_bar_title),
                onBackButtonClick = onBackButtonClick
            )
        },
        bottomBar = {
            ShoppingCartButton(
                text = stringResource(
                    R.string.shopping_cart_bottom_bar_total_price_format,
                    totalPrice
                ),
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 18.dp)
        ) {
            items(cartItems) { cartItem ->
                CartItemCard(
                    cartItem = cartItem,
                    onAddProductClick = { onAddProductClick(cartItem.product) },
                    onRemoveProductClick = { onRemoveProductClick(cartItem.product) },
                    onRemoveAllProductClick = { onRemoveAllProductClick(cartItem.product) },
                )
            }

        }
    }
}

@Composable
private fun CartItemCard(
    cartItem: CartItem,
    onAddProductClick: () -> Unit,
    onRemoveProductClick: () -> Unit,
    onRemoveAllProductClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        CartItemTitleSection(
            title = cartItem.product.name,
            onRemoveAllProductClick = onRemoveAllProductClick,
        )
        Spacer(modifier = Modifier.height(8.dp))
        CartItemDetailsSection(
            cartItem = cartItem,
            onAddProductClick = onAddProductClick,
            onRemoveProductClick = onRemoveProductClick
        )
    }
}

@Composable
private fun CartItemDetailsSection(
    cartItem: CartItem,
    onAddProductClick: () -> Unit,
    onRemoveProductClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.Bottom, modifier = modifier) {
        AsyncImage(
            model = cartItem.product.imageUrl,
            contentDescription = "상품 상세 이미지",
            error = painterResource(id = R.drawable.ic_launcher_background),
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(84.dp)
                .weight(1f)
        )
        Spacer(modifier = Modifier.width(26.dp))
        Column(horizontalAlignment = Alignment.End, modifier = Modifier.weight(1f)) {
            Text(
                stringResource(R.string.all_price_format, cartItem.product.price),
                fontSize = 16.sp,
                textAlign = TextAlign.End,
            )
            Spacer(modifier = Modifier.height(8.dp))
            ShoppingCartNumberCounter(
                count = cartItem.count,
                onAddClick = onAddProductClick,
                onRemoveClick = onRemoveProductClick
            )
        }
    }
}

@Composable
fun CartItemTitleSection(
    title: String,
    onRemoveAllProductClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = CenterVertically) {
        Text(
            text = title,
            fontWeight = W700,
            fontSize = 20.sp,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = "장바구니에서 상품 제거하기",
            modifier = Modifier.clickable(onClick = onRemoveAllProductClick)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemPreview() {
    CartItemCard(
        cartItem = CartItem(
            Product(
                1L,
                "[든든] 동원 스위트콘",
                99_800L,
                imageUrl = "https://picsum.photos/200"
            ), 1
        ),
        onAddProductClick = {},
        onRemoveProductClick = {},
        onRemoveAllProductClick = {})
}

@Preview
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartTheme {
        ShoppingCartScreen(
            onBackButtonClick = {},
            cartItems = List(10) {
                CartItem(
                    Product(
                        it.toLong(),
                        "[든든] 동원 스위트콘",
                        99_800L,
                        imageUrl = "https://picsum.photos/200"
                    ), 1
                )
            },
            onAddProductClick = {},
            onRemoveProductClick = {},
            onRemoveAllProductClick = {},
            totalPrice = 99800L
        )
    }
}

