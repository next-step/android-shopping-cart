package nextstep.shoppingcart.productDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.ProductImage
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.theme.Black33
import nextstep.shoppingcart.ui.theme.Blue50
import nextstep.shoppingcart.ui.theme.Gray40


@Composable
fun ProductDetailScreen(
    product: Product,
    onBackButtonClick: () -> Unit = {},
    onAddCartClick: (Product) -> Unit = {},
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
            Text(
                text = product.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.W700,
                color = Black33,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
            )
            HorizontalDivider(
                color = Gray40,
                thickness = 1.dp,
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
                Text(
                    text = stringResource(R.string.price_comma, product.price),
                    fontSize = 20.sp,
                    color = Black33,
                    fontWeight = FontWeight.W400,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { onAddCartClick(product) },
                shape = RectangleShape,
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Blue50,
                )
            ) {
                Text(
                    text = "장바구니 담기",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W700,
                    modifier = Modifier.padding(15.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailScreenPreview() {
    val product = Product(
        name = "PET보틀-원형(500ml)",
        price = 10000,
        imageUrl = "",
    )

    ProductDetailScreen(
        product = product,
    )
}