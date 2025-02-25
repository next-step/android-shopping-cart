package nextstep.shoppingcart.ui.products

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.components.ShoppingCartCounter
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.grey10
import nextstep.shoppingcart.ui.theme.grey40

@Composable
fun ProductsScreen(
    products: List<Product>,
    cartItems: List<CartItem>,
    onProductClick: (Product) -> Unit,
    onProductAddClick: (Product) -> Unit,
    onProductRemoveClick: (Product) -> Unit,
    onShoppingCartActionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        topBar = { ProductsTopAppBar(onShoppingCartActionClick) }) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            items(products) { product ->
                val count = cartItems.find { it.product == product }?.count ?: 0
                if (count == 0) {
                    ProductItem(
                        product = product,
                        onAddClick = { onProductAddClick(product) },
                        onClick = { onProductClick(product) },
                    )
                } else {
                    ProductItem(
                        product = product,
                        cartCount = count,
                        onAddClick = { onProductAddClick(product) },
                        onRemoveClick = { onProductRemoveClick(product) },
                        onClick = { onProductClick(product) },
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductsTopAppBar(
    onShoppingCartActionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.products_top_bar_title),
                color = grey10,
                fontWeight = FontWeight.W400,
                fontSize = 22.sp,
                style = MaterialTheme.typography.bodyLarge,
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_shopping_cart),
                contentDescription = "장바구니",
                modifier = Modifier
                    .clickable(onClick = onShoppingCartActionClick)
                    .padding(12.dp)
                    .size(24.dp),
            )
        },
        modifier = modifier
    )
}

@Composable
private fun ProductItem(
    product: Product,
    onAddClick: () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Box {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = "상품 이미지",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                error = painterResource(R.drawable.ic_launcher_background)
            )
            Icon(
                painter = painterResource(R.drawable.ic_add),
                contentDescription = "상품 추가",
                modifier = Modifier
                    .padding(12.dp)
                    .size(42.dp)
                    .background(color = White, shape = CircleShape)
                    .clickable(onClick = onAddClick)
                    .padding(8.dp)
                    .align(Alignment.BottomEnd)
            )
        }
        Text(
            text = product.name,
            color = grey40,
            fontSize = 16.sp,
            maxLines = 1,
            fontWeight = FontWeight.W700,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = stringResource(R.string.all_price_format).format(product.price),
            color = grey40,
            fontSize = 16.sp,
            maxLines = 1,
            fontWeight = FontWeight.W400,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun ProductItem(
    product: Product,
    cartCount: Int,
    onAddClick: () -> Unit,
    onRemoveClick: () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Box {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = "상품 이미지",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                placeholder = painterResource(R.drawable.ic_launcher_background),
                error = painterResource(R.drawable.ic_launcher_background)
            )
            ShoppingCartCounter(
                count = cartCount,
                onAddClick = onAddClick,
                onRemoveClick = onRemoveClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 12.dp, start = 12.dp, end = 12.dp)
                    .background(color = White, shape = RoundedCornerShape(4.dp))
            )
        }
        Text(
            text = product.name,
            color = grey40,
            fontSize = 16.sp,
            maxLines = 1,
            fontWeight = FontWeight.W700,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = stringResource(R.string.all_price_format).format(product.price),
            color = grey40,
            fontSize = 16.sp,
            maxLines = 1,
            fontWeight = FontWeight.W400,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsScreenPreview() {
    ShoppingCartTheme {
        ProductsScreen(
            products = List(10) {
                Product(
                    id = it.toLong(),
                    name = "상품$it",
                    price = 10000L,
                    imageUrl = "https://picsum.photos/200",
                )
            },
            onProductClick = {},
            onShoppingCartActionClick = {},
            cartItems = listOf(CartItem(Product(1L, "상품1", 10000L, ""), 1)),
            onProductAddClick = {},
            onProductRemoveClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsTopBarPreview() {
    ProductsTopAppBar(onShoppingCartActionClick = {})
}

class ProductItemParameterProvider : PreviewParameterProvider<String> {
    override val values = sequenceOf(
        "너무 너무 맛있는 엽떡과 허니콤보",
        "하이디라오 훠궈"
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview(
    @PreviewParameter(ProductItemParameterProvider::class) productName: String
) {
    ProductItem(
        Product(
            id = 1L,
            name = productName,
            price = 10000L,
            imageUrl = "https://picsum.photos/200",
        ),
        onClick = {},
        onAddClick = {},
        modifier = Modifier.width(200.dp)
    )
}


@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    ProductItem(
        Product(
            id = 1L,
            name = "상품",
            price = 10000L,
            imageUrl = "https://picsum.photos/200",
        ),
        onClick = {},
        onAddClick = {},
        cartCount = 5,
        onRemoveClick = {},
        modifier = Modifier.width(200.dp)
    )
}

