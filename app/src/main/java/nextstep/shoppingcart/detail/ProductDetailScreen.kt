package nextstep.shoppingcart.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.component.BackTitleAppBar
import nextstep.shoppingcart.common.component.ProductImage
import nextstep.shoppingcart.common.component.BottomButton
import nextstep.shoppingcart.detail.component.ProductPriceText
import nextstep.shoppingcart.list.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailScreen(
    product: Product,
    onBack: () -> Unit,
    onClickBottomButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            BackTitleAppBar(
                title = stringResource(R.string.product_detail),
                onBack = onBack
            )
        },
        bottomBar = {
            BottomButton(
                label = stringResource(R.string.add_to_cart),
                onClick = onClickBottomButton,
            )
        }
    ) { innerPadding ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(
                    state = scrollState,
                )
        ) {
            ProductImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                imageUrl = product.imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = product.name
            )
            Text(
                text = product.name,
                modifier = Modifier.padding(18.dp),
                style = TextStyle(
                    fontWeight = FontWeight.W700,
                    fontSize = 24.sp,
                    lineHeight = 28.sp,
                    letterSpacing = 0.5.sp
                )
            )
            HorizontalDivider(
                color = Color(0xFFAAAAAA)
            )
            ProductPriceText(
                price = product.price,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
            )
        }
    }
}

@Preview
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            product = Product(
                id = 0,
                imageUrl = "https://picsum.photos/id/1/300/300",
                name = "PET보틀-정사각형 어쩌구",
                price = 10000
            ),
            onBack = {},
            onClickBottomButton = {}
        )
    }
}
