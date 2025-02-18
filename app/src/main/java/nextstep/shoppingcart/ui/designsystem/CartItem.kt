package nextstep.shoppingcart.ui.designsystem

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun CartListItem(
    cartItem: CartItem,
    onRemoveCartItemClick: (CartItem) -> Unit,
    onIncreaseQuantityClick: (CartItem) -> Unit,
    onDecreaseQuantityClick: (CartItem) -> Unit,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
            )
            // IconButton에 의해 상단에 12dp( (48 - 24) / 2 )의 padding이 생기는데, 이것을 고려하여 top padding 18dp에서 12dp를 빼줬습니다.
            .padding(start = 18.dp, end = 18.dp, top = 6.dp, bottom = 18.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // 제목
            Text(
                text = cartItem.product.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f),
            )
            // 아이템 삭제
            IconButton(
                onClick = {
                    onRemoveCartItemClick(cartItem)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "${cartItem.product.name} ${stringResource(R.string.cart_list_item_remove)}"
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(26.dp),
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier.weight(1f),
                model = cartItem.product.imageUrl,
                contentDescription = "${cartItem.product.name} image",
                error = {
                    // 현재 preview 모드 인지 확인
                    if (LocalInspectionMode.current) {
                        Image(
                            painter = painterResource(R.drawable.dummy),
                            contentDescription = null,
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = null,
                            tint = Color.Red,
                        )
                    }
                }
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 18.dp),
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.product_price_format, cartItem.product.price),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.End,
                )
                QuantityHandler(
                    modifier = Modifier.fillMaxWidth(),
                    quantity = cartItem.count,
                    onIncreaseQuantityClick = {
                        onIncreaseQuantityClick(cartItem)
                    },
                    onDecreaseQuantityClick = {
                        onDecreaseQuantityClick(cartItem)
                    },
                )
            }
        }
    }
}


@Preview
@Composable
private fun CartListItemPreview() {
    ShoppingCartTheme {
        CartListItem(
            cartItem = CartItem(
                product = Product(
                    id = "Ronell",
                    imageUrl = "Stephani",
                    name = "[든든] 동원 스위트콘 스위트콘",
                    price = 999_999_999
                ), count = 999_999
            ),
            onRemoveCartItemClick = { },
            onIncreaseQuantityClick = { },
            onDecreaseQuantityClick = { },
        )
    }
}
