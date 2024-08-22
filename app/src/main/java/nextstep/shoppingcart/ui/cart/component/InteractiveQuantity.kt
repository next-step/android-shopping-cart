package nextstep.shoppingcart.ui.cart.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.cart.CartItem
import nextstep.shoppingcart.ui.iconpack.IconPack
import nextstep.shoppingcart.ui.iconpack.iconpack.IcMinus
import nextstep.shoppingcart.ui.iconpack.iconpack.IcPlus

@Composable
fun InteractiveQuantity(
    cartItem: CartItem,
    modifier: Modifier = Modifier,
    onClickMinus: () -> Unit,
    onClickPlus: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)
            .testTag(stringResource(id = R.string.test_tag_interactive_quantity) + cartItem.product.name),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier.testTag(
                stringResource(
                    id = R.string.test_tag_minus_icon,
                    cartItem.product.name
                )
            ),
            onClick = onClickMinus
        ) {
            Icon(
                imageVector = IconPack.IcMinus,
                contentDescription = stringResource(id = R.string.text_minus_Icon_description)
            )
        }
        Text(
            text = cartItem.count.toString(),
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium
        )
        IconButton(
            modifier = Modifier.testTag(
                stringResource(
                    id = R.string.test_tag_plus_icon,
                    cartItem.product.name
                )
            ),
            onClick = onClickPlus
        ) {
            Icon(
                imageVector = IconPack.IcPlus,
                contentDescription = stringResource(id = R.string.text_plus_Icon_description)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InteractiveQuantityPreview() {
    InteractiveQuantity(
        cartItem = CartItem(
            product = Product(
                id = 1,
                name = "Product Name",
                price = 1000,
                imgUrl = "https://www.example.com/image.jpg"
            ),
            count = 1
        ),
        onClickMinus = {},
        onClickPlus = {}
    )
}