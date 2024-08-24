package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.screen.products.model.ProductModel
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun Product(
    productModel: ProductModel,
    count: Int,
    onAddClick: (id: String) -> Unit,
    onPlusClick: (id: String) -> Unit,
    onMinusClick: (id: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val isShowCounter = count >= 1
    Column(modifier = modifier) {
        Box {
            ProductImage(
                modifier = Modifier.aspectRatio(1f),
                productName = productModel.name,
                imageUrl = productModel.imageUrl
            )


            if (isShowCounter) {
                ShoppingCartItemCounter(
                    count = count,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp, bottom = 12.dp)
                        .background(Color.White),
                    onMinusClick = { onMinusClick(productModel.id) },
                    onPlusClick = { onPlusClick(productModel.id) }
                )
            } else {
                IconButton(
                    onClick = { onAddClick(productModel.id) },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 12.dp, end = 12.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "${productModel.id} add button"
                    )
                }
            }
        }
        Text(
            text = productModel.name,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = stringResource(R.string.product_price, productModel.price),
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview(showBackground = true, name = "장바구니 수량 버튼 안보일때")
@Composable
private fun CartItemPreview() {
    ShoppingCartTheme {
        Product(
            productModel = ProductModel(
                name = "iPhone 15 Pro Max",
                imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                price = 1_900_000
            ),
            count = 0,
            onAddClick = {},
            onPlusClick = {},
            onMinusClick = {},
        )
    }
}

@Preview(showBackground = true, name = "장바구니 수량 버튼 보일때")
@Composable
private fun CartItemWithCartCounterPreview() {
    ShoppingCartTheme {
        Product(
            productModel = ProductModel(
                name = "iPhone 15 Pro Max",
                imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                price = 1_900_000,
            ),
            count = 10,
            onAddClick = {},
            onPlusClick = {},
            onMinusClick = {},
        )
    }
}
