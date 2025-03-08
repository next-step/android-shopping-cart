package nextstep.shoppingcart.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.common.component.BackTitleAppBar
import nextstep.shoppingcart.common.component.ProductImage
import nextstep.shoppingcart.detail.component.AddToCartButton
import nextstep.shoppingcart.detail.component.ProductPriceText
import nextstep.shoppingcart.detail.component.ProductTitleText
import nextstep.shoppingcart.list.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailScreen(
    product: Product,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Scaffold(
        modifier = modifier,
        topBar = {
            BackTitleAppBar(
                title = stringResource(R.string.product_detail),
                onBack = onBack
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            ProductImage(
                modifier = Modifier
                    .fillMaxWidth(),
                imageUrl = product.imageUrl,
                contentDescription = product.name
            )
            ProductTitleText(
                title = product.name,
                modifier = Modifier.padding(18.dp)
            )
            HorizontalDivider(
                color = Color(0xFFAAAAAA)
            )
            ProductPriceText(
                price = product.price,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
                    .weight(1f)
            )
            AddToCartButton(
                label = stringResource(R.string.add_to_cart),
                onClick = {
                    context.startActivity(CartActivity.intent(context))
                },
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
            onBack = {}
        )
    }
}
