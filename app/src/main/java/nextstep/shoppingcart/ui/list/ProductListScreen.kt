package nextstep.shoppingcart.ui.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.designsystem.theme.ShoppingCartTheme
import nextstep.shoppingcart.designsystem.theme.TopBarTextColor
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.navigation.RouteType
import nextstep.shoppingcart.ui.list.component.ProductItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
    productList: List<Product> = emptyList(),
    onRoute: (RouteType) -> Unit = {}
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.product_list_title),
                        fontSize = 22.sp,
                        color = TopBarTextColor,
                        textAlign = TextAlign.Center,
                    )
                },
                actions = {
                    Image(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "shopping_cart_icon",
                        modifier = Modifier
                            .clickable { onRoute(RouteType.ToCart) }
                            .padding(16.dp)
                            .size(24.dp)
                    )
                }
            )
        },
        modifier = modifier.fillMaxSize()
    ) { contentPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = productList,
                key = { item -> item.id }
            ) { item ->
                ProductItem(
                    item = item,
                    onClick = { onRoute(RouteType.ToDetail(item)) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductListScreenPreview() {
    val products = listOf(
        Product(
            id = 1,
            name = "PET-보틀-정사각형정사각형정사각형정사각형1",
            price = 10000,
            imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20181030_239%2Fcomscience1_1540871845728YC8OA_JPEG%2F01.jpg&type=a340"
        ),
        Product(
            id = 2,
            name = "PET-보틀-정사각형정사각형정사각형정사각형2",
            price = 12000,
            imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20230902_289%2F16936282521341esBM_JPEG%2F43703789512310907_1701428045.jpg&type=a340"
        ),
        Product(
            id = 3,
            name = "PET-보틀-정사각형정사각형정사각형정사각형3",
            price = 10000,
            imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20240316_157%2F1710560166560p5Hns_JPEG%2F111696001378223548_958485840.jpg&type=a340"
        ),
        Product(
            id = 4,
            name = "PET-보틀-납작(1밀크티밀크티밀크티)",
            price = 15000,
            imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20230313_100%2F1678675973641Ps5y1_JPEG%2F79811808477513822_1202590274.jpg&type=a340"
        ),
    )

    ShoppingCartTheme {
        ProductListScreen(productList = products)
    }
}