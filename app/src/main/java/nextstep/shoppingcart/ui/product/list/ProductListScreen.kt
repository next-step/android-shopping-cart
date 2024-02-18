package nextstep.shoppingcart.ui.product.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.R
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.navigation.Navigation
import nextstep.shoppingcart.ui.product.list.component.ProductItem

private val Products = listOf(
    Product(
        id = "1",
        name = "PET보틀-정사각(500ml)",
        price = 44200,
        imageUrl = "https://image.homeplus.kr/td/ab85fa98-8309-4042-a54f-e7d2e5999002"
    ),
    Product(
        id = "2",
        name = "[든든] 동원 스위트콘]",
        price = 1980,
        imageUrl = "https://image.homeplus.kr/td/1081f890-d3e1-413a-b47d-d916174456fb"
    ),
    Product(
        id = "3",
        name = "새벽딸기 500G(팩)",
        price = 7490,
        imageUrl = "https://image.homeplus.kr/td/87aa8eae-9a4b-4194-8dcd-d3f5767f259d"
    ),
    Product(
        id = "4",
        name = "서울우유 2.3L",
        price = 6080,
        imageUrl = "https://image.homeplus.kr/td/558df50f-b1da-428e-8f6c-cdb85975bfc0"
    ),
    Product(
        id = "5",
        name = "팔도진미 강원도 춘천식 닭갈비 800G",
        price = 10990,
        imageUrl = "https://image.homeplus.kr/td/38b43a49-c8b2-4290-9cd1-9140078a6184"
    ),
    Product(
        id = "6",
        name = "보먹돼 단풍상회 레트로 냉삼겹살(냉동) 700G(팩)/돼지고기",
        price = 9900,
        imageUrl = "https://image.homeplus.kr/td/2bf08f30-42e0-4174-9e9b-e7d4202a010c"
    ),
)

@Composable
internal fun ProductListScreen(
    navHostController: NavHostController,
) {
    ProductListScreen(
        products = Products,
        onCartClick = {
            navHostController.navigate(Navigation.Cart.route)
        },
        onProductAddClick = { /* TODO */ },
        onProductItemClick = { /* TODO */ },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ProductListScreen(
    products: List<Product>,
    onCartClick: () -> Unit,
    onProductAddClick: (Product) -> Unit,
    onProductItemClick: (Product) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.product_list_title)) },
                actions = {
                    IconButton(onClick = onCartClick) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "장바구니",
                        )
                    }
                },
            )
        },
        content = { innerPadding ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(vertical = 4.dp, horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(innerPadding),
            ) {
                items(products) { product ->
                    ProductItem(
                        product = product,
                        onAddClick = { onProductAddClick(product) },
                        onItemClick = { onProductItemClick(product) },
                    )
                }
            }
        },
    )
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    MaterialTheme {
        ProductListScreen(navHostController = rememberNavController())
    }
}
