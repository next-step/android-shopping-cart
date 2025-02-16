package nextstep.shoppingcart.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailScreen(
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = { ProductDetailTopAppBar(onBackButtonClick = onBackButtonClick) }
    ) { innerPadding ->
        Column(Modifier.padding(paddingValues = innerPadding)) {
            Text(text = "상품 상세 화면")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailTopAppBar(
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = "상품 상세") },
        navigationIcon = {
            IconButton(onClick = onBackButtonClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "상품 상세 뒤로가기"
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showSystemUi = true)
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(onBackButtonClick = {})
    }
}