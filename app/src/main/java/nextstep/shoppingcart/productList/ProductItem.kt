package nextstep.shoppingcart.productList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.component.ProductImage
import nextstep.shoppingcart.component.ProductName
import nextstep.shoppingcart.component.ProductPrice
import nextstep.shoppingcart.component.QuantityController
import nextstep.shoppingcart.data.DummyProduct
import nextstep.shoppingcart.data.Product


@Composable
fun ProductItem(
    product: Product,
    onClick: () -> Unit,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        color = Color.White,
        onClick = onClick,
    ) {
        Column {
            Box {
                ProductImage(
                    imageUrl = product.imageUrl,
                    ratio = (156.0f / 158),
                    modifier = Modifier
                        .fillMaxWidth(),
                )
                if (product.count > 0) {
                    QuantityController(
                        count = product.count,
                        onMinusClick = onMinusClick,
                        onPlusClick = onPlusClick,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .padding(bottom = 12.dp)
                            .background(
                                shape = RoundedCornerShape(corner = CornerSize(5.dp)),
                                color = Color.White
                            )
                    )
                } else {
                    IconButton(
                        onClick = onPlusClick,
                        modifier = Modifier
                            .testTag("product_add_button")
                            .padding(bottom = 12.dp, end = 12.dp)
                            .clip(shape = CircleShape)
                            .size(42.dp)
                            .background(color = Color.White)
                            .align(Alignment.BottomEnd),
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Filled.Add,
                            contentDescription = "product_add_button",
                            tint = Color.Black,
                        )
                    }
                }
            }
            ProductName(
                name = product.name,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .padding(horizontal = 4.dp)
                    .fillMaxWidth(),
                fontSize = 16.sp,
            )
            ProductPrice(
                price = product.price,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .fillMaxWidth(),
                fontSize = 16.sp,
            )
        }
    }
}

private class ProductItemPreviewParameterProvider : PreviewParameterProvider<Product> {
    val product1 = DummyProduct.product1
    val product2 = DummyProduct.product2.apply { count = 1 }

    override val values = sequenceOf(
        product1,
        product2
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview(
    @PreviewParameter(ProductItemPreviewParameterProvider::class) product: Product,
) {
    ProductItem(
        product = product,
        onClick = {},
        onPlusClick = {},
        onMinusClick = {},
    )
}