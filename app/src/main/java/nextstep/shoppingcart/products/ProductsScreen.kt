package nextstep.shoppingcart.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.grey10
import nextstep.shoppingcart.ui.theme.grey40

@Composable
fun ProductsScreen(
    products: List<Product>,
    onProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        topBar = { ProductsTopAppBar() }) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            items(products) { product ->
                ProductItem(
                    product = product,
                    onClick = { onProductClick(product) },
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductsTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.products_top_bar_title),
                color = grey10,
                fontWeight = FontWeight.W400,
                style = MaterialTheme.typography.bodyLarge,
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_shopping_cart),
                contentDescription = "장바구니",
                modifier = Modifier
                    .clickable(onClick = {})
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
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "상품 이미지",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clickable(onClick = onClick),
            placeholder = painterResource(R.drawable.ic_launcher_background),
            error = painterResource(R.drawable.ic_launcher_background)
        )
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
            onProductClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsTopBarPreview() {
    ProductsTopAppBar()
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
        modifier = Modifier.width(200.dp)
    )
}
