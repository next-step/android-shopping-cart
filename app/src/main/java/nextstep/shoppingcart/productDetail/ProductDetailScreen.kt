package nextstep.shoppingcart.productDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.CtaButton
import nextstep.shoppingcart.component.ProductImage
import nextstep.shoppingcart.component.ProductName
import nextstep.shoppingcart.component.ProductPrice
import nextstep.shoppingcart.data.DummyProduct
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.theme.Black33
import nextstep.shoppingcart.ui.theme.Gray40


@Composable
fun ProductDetailScreen(
    product: Product,
    onBackButtonClick: () -> Unit,
    onAddCartClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        containerColor = Color.White,
        topBar = {
            ProductDetailTopAppBar(onBackButtonClick = onBackButtonClick)
        },
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding),
        ) {
            ProductImage(
                imageUrl = product.imageUrl,
                ratio = 1f,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            ProductName(
                name = product.name,
                modifier = Modifier
                    .padding(18.dp)
                    .fillMaxWidth(),
                fontSize = 24.sp
            )
            HorizontalDivider(
                color = Gray40,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = stringResource(R.string.price_label),
                    fontSize = 20.sp,
                    color = Black33,
                    fontWeight = FontWeight.W400,
                )
                ProductPrice(
                    price = product.price,
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            CtaButton(
                text = "장바구니 담기",
                onClick = { onAddCartClick(product) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPreview() {
    val product = DummyProduct.product1

    ProductDetailScreen(
        product = product,
        onBackButtonClick = {},
        onAddCartClick = {},
    )
}