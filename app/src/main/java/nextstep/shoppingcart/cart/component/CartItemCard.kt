package nextstep.shoppingcart.cart.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.component.ProductCard
import nextstep.shoppingcart.common.component.QuantitySelector
import nextstep.shoppingcart.common.model.CartItem
import nextstep.shoppingcart.common.model.Product
import nextstep.shoppingcart.common.model.dummyProducts
import nextstep.shoppingcart.common.theme.NextStepTheme
import java.text.NumberFormat
import java.util.Locale

@Composable
internal fun CartItemCard(
    cartItem: CartItem,
    onCloseClick: () -> Unit,
    onCountAddClick: () -> Unit,
    onCountMinusClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(size = 4.dp),
        border = BorderStroke(width = 1.dp, color = Color.Gray),
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            CartItemHeader(
                productName = cartItem.product.name,
                onCloseClick = onCloseClick
            )
            CartItemDetails(
                product = cartItem.product,
                count = cartItem.count,
                onCountAddClick = onCountAddClick,
                onCountMinusClick = onCountMinusClick
            )
        }
    }
}

@Composable
private fun CartItemHeader(
    productName: String,
    onCloseClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = productName,
            style = NextStepTheme.typography.roboto20B,
            maxLines = 1,
        )
        IconButton(
            onClick = onCloseClick,
            modifier = Modifier.size(24.dp),
        ) {
            Icon(imageVector = Icons.Outlined.Close, contentDescription = null)
        }
    }
}

@Composable
private fun CartItemDetails(
    product: Product,
    count: Int,
    onCountAddClick: () -> Unit,
    onCountMinusClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        ProductCard(
            product = product,
            modifier = Modifier.size(width = 134.dp, height = 84.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp)
        ) {
            Text(
                text = stringResource(
                    R.string.cart_item_card_won,
                    NumberFormat.getNumberInstance(Locale.KOREA).format(product.price)
                ),
                style = NextStepTheme.typography.roboto16N,
                textAlign = TextAlign.End,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )
            QuantitySelector(
                count = count,
                onCountAddClick = onCountAddClick,
                onCountMinusClick = onCountMinusClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun CartItemCardPreview() {
    NextStepTheme {
        CartItemCard(
            cartItem = CartItem(
                product = dummyProducts.first(),
                count = 1,
            ),
            onCloseClick = {},
            onCountAddClick = {},
            onCountMinusClick = {}
        )
    }
}
