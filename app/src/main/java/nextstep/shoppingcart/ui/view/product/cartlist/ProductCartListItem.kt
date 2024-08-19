package nextstep.shoppingcart.ui.view.product.cartlist

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.composable.Stepper
import nextstep.shoppingcart.ui.model.Product

private const val PRODUCT_CART_LIST_ITEM_IMAGE_RATIO = 136f / 84f

@Composable
fun ProductCartListItem(
    product: Product,
    quantity: Int,
    onQuantityChange: (Int) -> Unit,
    onClearClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xffaaaaaa),
                shape = RoundedCornerShape(4.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = product.name,
                fontWeight = FontWeight.W700,
                fontSize = 20.sp,
                color = Color.Black
            )

            Icon(
                modifier = Modifier.clickable {
                    onClearClick()
                },
                imageVector = Icons.Filled.Close,
                contentDescription = stringResource(R.string.product_cart_list_clear_button_content_description)
            )
        }

        Spacer(modifier = Modifier.size(6.dp))

        Row {
            AsyncImage(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(PRODUCT_CART_LIST_ITEM_IMAGE_RATIO),
                model = product.imageUrl,
                contentDescription = stringResource(R.string.product_cart_list_product_item_image_content_description)
            )
            Spacer(modifier = Modifier.size(26.dp))
            Column(
                modifier = Modifier.align(Alignment.Bottom)
            ) {
                Text(
                    modifier = Modifier.align(Alignment.End),
                    text = stringResource(
                        id = R.string.product_cart_list_product_item_price_fmt,
                        product.price * quantity
                    ),
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Stepper(
                    count = quantity,
                    onCountChange = onQuantityChange
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCartListItemPreview() {
    ProductCartListItem(
        modifier = Modifier.padding(16.dp),
        product = Product(
            name = "MacBook Pro",
            price = 2399000,
            imageUrl = "https://cdn.pixabay.com/photo/2014/05/02/21/50/laptop-336378_960_720.jpg"
        ),
        quantity = 3,
        onQuantityChange = {},
        onClearClick = {},
    )
}
