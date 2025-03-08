package nextstep.shoppingcart.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.cart.CartActivity
import nextstep.shoppingcart.common.component.BackTitleAppBar
import nextstep.shoppingcart.common.component.ProductImage
import nextstep.shoppingcart.list.model.Product
import nextstep.shoppingcart.ui.theme.Blue50
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
                    .weight(1f)
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "금액",
                    style = TextStyle(
                        fontWeight = FontWeight.W400,
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        letterSpacing = 0.5.sp
                    ),
                    color = Color(0xFF333333)
                )
                Text(
                    text = stringResource(R.string.price_format, product.price),
                    style = TextStyle(
                        fontWeight = FontWeight.W400,
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                        letterSpacing = 0.5.sp
                    ),
                    color = Color(0xFF333333)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Blue50)
                    .clickable {
                        context.startActivity(CartActivity.intent(context))
                    }
                    .padding(vertical = 15.dp)
                ,
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.add_to_cart),
                    style = TextStyle(
                        fontWeight = FontWeight.W700,
                        fontSize = 20.sp
                    ),
                    color = Color.White
                )
            }
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
