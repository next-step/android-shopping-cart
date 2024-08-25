package nextstep.shoppingcart.ui.productlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.component.ShoppingCartActionsTopBar

@Composable
fun ProductListScreen(
    products: List<Product>,
    onActionClick: () -> Unit,
    onProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    val cartItems by Cart.items.collectAsState()

    val onMinusClick = { item: Product ->
        Cart.removeOne(item)
    }

    val onPlusClick = { item: Product ->
        Cart.addOne(item)
    }

    ProductListScreen(
        products = products,
        cartItems = cartItems,
        onActionClick = onActionClick,
        onProductClick = onProductClick,
        onMinusClick = onMinusClick,
        onPlusClick = onPlusClick,
        modifier = modifier
    )
}

@Composable
private fun ProductListScreen(
    products: List<Product>,
    cartItems: List<CartItem>,
    onActionClick: () -> Unit,
    onProductClick: (Product) -> Unit,
    onMinusClick: (Product) -> Unit,
    onPlusClick: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ShoppingCartActionsTopBar(
                title = stringResource(id = R.string.tob_bar_product_list_title),
                onActionClick = onActionClick
            )
        },
        modifier = modifier
            .fillMaxSize()
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    start = 18.dp,
                    end = 18.dp
                )
        ) {
            items(
                items = products,
                key = { product -> product.id }
            ) { product ->
                ProductInfo(
                    product = product,
                    count = cartItems.find { it.product == product }?.count ?: 0,
                    onProductClick = onProductClick,
                    onMinusClick = onMinusClick,
                    onPlusClick = onPlusClick
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    val products: List<Product> = listOf(
        Product(
            id = 1,
            imageUrl = "https://image.msscdn.net/images/goods_img/20230425/3257548/3257548_16823548430020_500.jpg",
            name = "루바토 브이넥 반팔 티셔츠 네이비",
            price = 16371
        ),
        Product(
            id = 2,
            imageUrl = "https://image.msscdn.net/images/goods_img/20240404/4022896/4022896_17132431505458_500.jpg",
            name = "TCM starfish backpack (black)",
            price = 87200
        ),
        Product(
            id = 3,
            imageUrl = "https://image.msscdn.net/images/goods_img/20240206/3848632/3848632_17090115351739_500.jpg",
            name = "Starfish Damage Ball Cap(BLUE)",
            price = 59000
        ),
        Product(
            id = 4,
            imageUrl = "https://image.msscdn.net/images/goods_img/20240516/4135365/4135365_17161647453804_500.jpg",
            name = "링클 체크 박시 오버핏 롤업 하프 셔츠 블루",
            price = 37400
        ),
        Product(
            id = 5,
            imageUrl = "https://image.msscdn.net/images/goods_img/20240201/3840937/3840937_17083068789627_500.jpg",
            name = "Cut Off Curved Denim Pants - Black",
            price = 69000
        )
    )
    ProductListScreen(
        products = products,
        onActionClick = { },
        onProductClick = { }
    )
}