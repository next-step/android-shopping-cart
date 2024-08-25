package nextstep.shoppingcart.component.cart

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.component.common.ProductImage
import nextstep.shoppingcart.component.common.ProductQuantity
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import java.text.NumberFormat
import java.util.Locale


@Composable
fun CartProductItem(
    cartItem: CartItem,
    onCloseClick: () -> Unit,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.gray),
                shape = RoundedCornerShape(4.dp)
            ),
        colors = CardDefaults.cardColors(
            colorResource(id = R.color.white)
        ),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = cartItem.product.name,
                    style = MaterialTheme.typography.headlineSmall
                )

                IconButton(
                    onClick = onCloseClick
                ) {
                    Icon(
                        modifier = Modifier.fillMaxSize(),
                        imageVector = Icons.Default.Close,
                        contentDescription = "${cartItem.product.name} close"
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom

                ) {
                ProductImage(
                    modifier = Modifier.size(
                        width = 136.dp,
                        height = 84.dp
                    ),
                    imageUrl = cartItem.product.imageUrl,
                    contentDescription = cartItem.product.name,
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = NumberFormat
                            .getNumberInstance(Locale.KOREA)
                            .format(cartItem.product.price) + "원",
                        fontSize = 16.sp
                    )
                    ProductQuantity(
                        name = cartItem.product.name,
                        count = cartItem.count,
                        onPlusClick = onPlusClick,
                        onMinusClick = onMinusClick
                    )
                }

            }

        }
    }
}


@Preview
@Composable
private fun CartProductPreview() {
    CartProductItem(
        cartItem = CartItem(
            product = Product(
                name = "iPhone 15 Pro Max",
                imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                price = 1900000,
            ),
            count = 1
        ),
        onCloseClick = {},
        onMinusClick = {},
        onPlusClick = {},
    )
}