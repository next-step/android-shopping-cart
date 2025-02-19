package nextstep.shoppingcart.ui.screen.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.CartItem
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.theme.Gray10
import nextstep.shoppingcart.ui.utils.formatter.DefaultMoneyFormatter
import nextstep.shoppingcart.ui.utils.formatter.MoneyFormatter

@Composable
fun CartItemContainer(
    cartItem: CartItem,
    onCartItemDelete: () -> Unit,
    onMinusCartItem: () -> Unit,
    onPlusCartItem: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .border(1.dp, Gray10)
            .clip(RoundedCornerShape(4.dp))
            .padding(18.dp)
    ) {
        Column {
            CartItemTopSector(
                title = cartItem.product.title,
                onCartItemDelete = onCartItemDelete,
            )
            Spacer(modifier = Modifier.height(6.dp))
            CartItemBottomSector(
                imageUrl = cartItem.product.imageUrl,
                price = cartItem.totalPrice,
                count = cartItem.count,
                onMinusCartItem = onMinusCartItem,
                onPlusCartItem = onPlusCartItem,
            )
        }
    }
}

@Composable
private fun CartItemTopSector(
    title: String,
    onCartItemDelete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.W700,
            fontSize = 20.sp,
        )
        IconButton(
            onClick = onCartItemDelete
        ) {
            Icon(Icons.Filled.Close, contentDescription = "Remove Button")
        }
    }
}

@Composable
private fun CartItemBottomSector(
    imageUrl: String,
    price: Int,
    count: Int,
    onMinusCartItem: () -> Unit,
    onPlusCartItem: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ProductImage(
            imageUrl = imageUrl,
            contentDescription = "Cart Product Image",
            modifier = modifier
                .weight(1f)
                .aspectRatio(136 / 84f)
        )
        Spacer(modifier = Modifier.width(26.dp))
        CartItemInfo(
            price = price,
            count = count,
            onMinusCartItem = onMinusCartItem,
            onPlusCartItem = onPlusCartItem,
            modifier = modifier
                .weight(1f)
                .padding(end = 10.dp)
        )
    }
}

@Composable
private fun CartItemInfo(
    price: Int,
    count: Int,
    onMinusCartItem: () -> Unit,
    onPlusCartItem: () -> Unit,
    formatter: MoneyFormatter = DefaultMoneyFormatter,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "${formatter.format(price)}원",
            fontSize = 16.sp,
            fontWeight = FontWeight.W400
        )
        CartQuantitySector(
            count = count,
            onMinusCartItem = onMinusCartItem,
            onPlusCartItem = onPlusCartItem,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun CartQuantitySector(
    count: Int,
    onMinusCartItem: () -> Unit,
    onPlusCartItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        QuantityAdjusButton(
            buttonTitle = stringResource(id = R.string.cart_minus_item_button),
            onClick = onMinusCartItem,
        )
        Text(
            text = count.toString(),
            fontSize = 22.sp,
            fontWeight = FontWeight.W400,
        )
        QuantityAdjusButton(
            buttonTitle = stringResource(id = R.string.cart_plus_item_button),
            onClick = onPlusCartItem,
        )
    }
}

@Composable
private fun QuantityAdjusButton(
    buttonTitle: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .padding(4.dp)
    ) {
        Text(
            text = buttonTitle,
            fontSize = 16.sp,
            fontWeight = FontWeight.W700,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemInfoPreview() {
    CartItemInfo(
        price = 10000,
        count = 2,
        onMinusCartItem = {

        },
        onPlusCartItem = {

        },
    )
}

@Preview(showBackground = true)
@Composable
private fun CartQuantitySectorPreview() {
    CartQuantitySector(
        count = 2,
        onMinusCartItem = {

        },
        onPlusCartItem = {

        },
    )
}

@Preview(showBackground = true)
@Composable
private fun QuantityAdjusButtonPreview() {
    QuantityAdjusButton(
        buttonTitle = "+",
        onClick = {

        },
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductTopSectorPreview() {
    CartItemTopSector(
        title = "상품 이름",
        onCartItemDelete = {

        },
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductBottomSectorPreview() {
    CartItemBottomSector(
        imageUrl = "https://www.picsum.photos/200",
        price = 10000,
        count = 2,
        onMinusCartItem = {

        },
        onPlusCartItem = {

        },
    )
}

@Preview(showBackground = true)
@Composable
private fun CartItemBoxPreview() {
    CartItemContainer(
        cartItem = CartItem(
            product = Product(
                imageUrl = "https://www.picsum.photos/200",
                title = "상품 이름",
                price = 10000,
            ),
            count = 2,
        ),
        onCartItemDelete = {

        },
        onMinusCartItem = {

        },
        onPlusCartItem = {

        },
    )
}