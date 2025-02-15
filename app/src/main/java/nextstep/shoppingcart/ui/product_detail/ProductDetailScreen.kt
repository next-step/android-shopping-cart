@file:OptIn(ExperimentalMaterial3Api::class)

package nextstep.shoppingcart.ui.product_detail

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailScreen(
    product: Product,
    modifier: Modifier = Modifier,
) {
    val state by remember {
        mutableStateOf(ProductDetailState(product = product))
    }

    ProductDetailScreen(
        productDetailState = state,
        modifier = modifier,
    )
}

@Composable
private fun ProductDetailScreen(
    productDetailState: ProductDetailState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            ProductDetailTopAppBar()
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier.padding(paddingValues),
        ) {
            item {

            }
        }
    }
}

@Composable
private fun ProductDetailTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(stringResource(R.string.product_detail))
        },
        navigationIcon = {
            Icon(
                modifier = Modifier.padding(horizontal = 8.dp),
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(R.string.navigation_back),
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors().copy(
            containerColor = Color.White,
        )
    )
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            product = Product(
                imageUrl = "",
                name = "PET-보틀-정사각형 정사각형 정사각형 ",
                price = 10_000
            ),
        )
    }
}
