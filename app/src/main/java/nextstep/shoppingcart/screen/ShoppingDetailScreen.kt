package nextstep.shoppingcart.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.ShoppingTextButton
import nextstep.shoppingcart.component.topbar.ShoppingTopBarWithBack
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.productList
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.util.Cart

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingDetailScreen(
    productId: Int,
    onClickCart: () -> Unit,
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val product = remember(productId) {
        productList.find { it.id == productId }
    }
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingTopBarWithBack(
                title = stringResource(id = R.string.shopping_detail_title),
                onClickBack = onClickBack
            )
        }
    ) { innerPadding ->
        if (product == null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "해당 상품을 조회할 수 없습니다.")
            }
        } else {
            ShoppingDetailContent(
                modifier = Modifier.padding(innerPadding),
                product = product,
                onClickCart = {
                    Cart.addOne(product)
                    onClickCart()
                }
            )
        }
    }
}

@Composable
fun ShoppingDetailContent(
    product: Product,
    onClickCart: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        ShoppingDetailContentImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            product = product
        )

        Text(
            modifier = Modifier.padding(18.dp),
            text = product.name,
            style = MaterialTheme.typography.headlineSmall.copy(
                lineHeight = 28.sp
            ),
            fontWeight = FontWeight.Bold
        )

        Divider()
        ShoppingDetailContentPrice(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            product = product
        )

        Spacer(modifier = Modifier.weight(1f))

        ShoppingTextButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.shopping_detail_cart_button),
            onClick = onClickCart
        )
    }
}

@Composable
fun ShoppingDetailContentImage(
    product: Product,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        modifier = modifier,
        model = product.imageUrl,
        contentDescription = product.name,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ShoppingDetailContentPrice(
    product: Product,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .weight(1f),
            text = stringResource(id = R.string.shopping_detail_price_title),
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = stringResource(id = R.string.shopping_list_price_korean, product.price),
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview(name = "ShoppingDetailScreen")
@Composable
private fun Preview1() {
    ShoppingCartTheme {
        ShoppingDetailScreen(
            productId = 1,
            onClickCart = {},
            onClickBack = {}
        )
    }
}