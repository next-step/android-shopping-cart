package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.FakeData
import nextstep.shoppingcart.data.Product

@Composable
fun ProductScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar()
        },
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            val fakeItemList = FakeData.products
            Column {
                ProductList(products = fakeItemList)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.appbar_product_title))
        },
        actions = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Cart",
                    tint = Color.Black
                )
            }
        }
    )
}

@Composable
fun ProductList(
    modifier: Modifier = Modifier,
    products: List<Product>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize().padding(horizontal = 18.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(vertical = 13.dp),
    ) {
        items(products.size) {index ->
            ProductItem(
                imageUrl = products[index].imageUrl,
                title = products[index].title,
                price = products[index].price
            )
        }
    }
}

@Composable
fun ProductItem(
    title: String,
    price: Int,
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Product Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(78f / 79f)
        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.W700,
        )
        Text(
            text = "${price}원",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppbarPreview() {
    TopAppBar()
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {
    ProductItem(
        imageUrl = "https://www.picsum.photos/200",
        title = "상품 이름",
        price = 10000
    )
}

@Preview(showBackground = true)
@Composable
fun ProductListPreview() {
    val fakeItemList = FakeData.products
    ProductList(
        products = fakeItemList
    )
}