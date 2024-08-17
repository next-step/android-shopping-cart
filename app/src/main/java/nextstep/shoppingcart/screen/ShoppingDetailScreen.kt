package nextstep.shoppingcart.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.ShoppingDetailTopBar
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.productList
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingDetailScreen(
    product: Product,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingDetailTopBar(
                title = stringResource(id = R.string.shopping_detail_title),
                onClickBack = {

                }
            )
        }
    ) { innerPadding ->
        ShoppingDetailContent(
            modifier = Modifier.padding(innerPadding),
            product = product
        )
    }
}

@Composable
fun ShoppingDetailContent(
    product: Product,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            model = product.imageUrl,
            contentDescription = product.name,
            contentScale = ContentScale.Crop
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                text = stringResource(id = R.string.shopping_list_price_korean, product.price),
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = stringResource(id = R.string.shopping_list_price_korean, product.price),
                style = MaterialTheme.typography.titleSmall
            )
        }

    }
}

@Preview
@Composable
private fun ShoppingDetailScreen() {
    ShoppingCartTheme {
        ShoppingDetailScreen(product = productList[1])
    }
}