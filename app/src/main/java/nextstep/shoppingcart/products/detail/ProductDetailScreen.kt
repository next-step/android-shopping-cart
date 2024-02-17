package nextstep.shoppingcart.products.detail

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import nextstep.shoppingcart.products.ProductItemUiState
import nextstep.shoppingcart.products.detail.component.ProductDetailScreenTopBar
import nextstep.shoppingcart.products.detail.component.ProductName
import nextstep.shoppingcart.products.detail.component.ProductPrice
import nextstep.shoppingcart.products.detail.component.PutInCartButton
import nextstep.shoppingcart.products.formatter.DefaultPriceFormatter
import nextstep.shoppingcart.products.formatter.PriceFormatter

@Composable
fun ProductDetailScreen(
    navController: NavHostController,
    productItemUiState: ProductItemUiState,
    onPutInCartButtonClick: () -> Unit,
    priceFormatter: PriceFormatter = DefaultPriceFormatter,
) {
    Scaffold(
        topBar = {
            ProductDetailScreenTopBar(navController)
        },
        bottomBar = {
            PutInCartButton(
                onClick = onPutInCartButtonClick,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .scrollable(
                    state = rememberScrollState(),
                    orientation = Orientation.Horizontal,
                ),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            AsyncImage(
                modifier = Modifier.aspectRatio(1f),
                model = productItemUiState.productImageUrl,
                contentDescription = null,
            )

            ProductName(
                modifier = Modifier.padding(horizontal = 18.dp),
                productName = productItemUiState.productName,
            )

            Divider()

            ProductPrice(
                modifier = Modifier.padding(horizontal = 18.dp),
                productPrice = productItemUiState.productPrice,
                priceFormatter = priceFormatter,
            )
        }
    }
}

@Preview
@Composable
fun ProductDetailScreenPreview() {
    ProductDetailScreen(
        navController = rememberNavController(),
        productItemUiState = ProductItemUiState(
            productName = "치즈",
            productPrice = 13_500,
            productImageUrl = "대충 치즈냥이 URL인것",
        ),
        onPutInCartButtonClick = {},
    )
}
