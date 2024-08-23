package nextstep.shoppingcart.ui.view.product.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.composable.Stepper
import nextstep.shoppingcart.ui.model.CartItem
import nextstep.shoppingcart.ui.model.Product

@Composable
fun ProductListItem(
    product: Product,
    countInCart: Int,
    onClick: (Product) -> Unit,
    onQuantityChange: (CartItem, Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clickable { onClick(product) },
    ) {
        Box {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                model = product.imageUrl,
                contentDescription = product.name,
                loading = {
                    CircularProgressIndicator()
                },
                success = {
                    Image(painter = it.painter, contentDescription = "")
                }
            )

            if (countInCart == 0) {
                AddToCartButton(
                    product = product,
                    countInCart = countInCart,
                    onQuantityChange = onQuantityChange
                )
            } else {
                Stepper(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(size = 4.dp)
                        )
                        .padding(bottom = 12.dp),
                    count = countInCart,
                    onCountChange = {
                        onQuantityChange(
                            CartItem(product, countInCart),
                            it,
                        )
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = product.name,
            fontWeight = FontWeight(700),
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.product_list_product_item_price_fmt, product.price),
            fontWeight = FontWeight(400),
            fontSize = 16.sp,
        )
    }
}

@Composable
private fun BoxScope.AddToCartButton(
    product: Product,
    countInCart: Int,
    onQuantityChange: (CartItem, Int) -> Unit,
) {
    IconButton(
        modifier = Modifier.Companion
            .align(Alignment.BottomEnd)
            .size(42.dp)
            .background(
                color = Color.White,
                shape = CircleShape
            )
            .padding(9.dp),
        onClick = {
            onQuantityChange(
                CartItem(product, countInCart),
                countInCart + 1
            )
        },
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "",
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListItemPreview() {
    ProductListItem(
        product = Product(
            name = "Product Name",
            price = 1000,
            imageUrl = "https://example.com/image.jpg",
        ),
        countInCart = 0,
        onClick = {},
        onQuantityChange = { _, _ -> },
    )
}
