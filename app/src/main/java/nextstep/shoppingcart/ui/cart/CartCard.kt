package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.component.BasicIconButton
import nextstep.shoppingcart.ui.component.ProductImage
import nextstep.shoppingcart.ui.component.QuantitySelector
import nextstep.shoppingcart.ui.theme.Gray10
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartCard(
    cartItem: CartItem,
    onCancel: () -> Unit,
    onAddQuantityClick: () -> Unit,
    onRemoveQuantityClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier =
            modifier
                .border(
                    width = 1.dp,
                    color = Gray10,
                    shape = RoundedCornerShape(4.dp),
                ).padding(18.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = cartItem.product.name,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier =
                    Modifier
                        .weight(1f)
                        .testTag(stringResource(id = R.string.test_tag_cart_card_product_name)),
            )

            BasicIconButton(
                imageVector = Icons.Filled.Clear,
                onClick = onCancel,
                modifier =
                    Modifier
                        .size(24.dp)
                        .testTag(stringResource(id = R.string.test_tag_cart_card_cancel)),
            )
        }
        Row {
            ProductImage(
                imgUrl = cartItem.product.imgUrl,
                modifier =
                    Modifier
                        .weight(1f)
                        .height(84.dp),
            )
            Spacer(modifier = Modifier.width(26.dp))
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.weight(1f),
            ) {
                Text(
                    text = stringResource(id = R.string.product_price, cartItem.totalPrice),
                    fontSize = 16.sp,
                    modifier = Modifier.testTag(stringResource(id = R.string.test_tag_cart_card_price)),
                )
                QuantitySelector(
                    quantity = cartItem.quantity,
                    onAddClick = onAddQuantityClick,
                    onRemoveClick = onRemoveQuantityClick,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartCardPreview() {
    ShoppingCartTheme {
        val product =
            Product(
                id = 1,
                name = "M3 MacBook Air",
                price = 2000,
                imgUrl =
                    "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-macbook-air-m2-m3-202402?wid=1400&hei=1000&fmt=p-jpg&qlt=95&.v=1707259317253",
            )
        val cartItem = CartItem(product = product, quantity = 1)
        CartCard(
            cartItem = cartItem,
            onCancel = {},
            onAddQuantityClick = {},
            onRemoveQuantityClick = {},
        )
    }
}
