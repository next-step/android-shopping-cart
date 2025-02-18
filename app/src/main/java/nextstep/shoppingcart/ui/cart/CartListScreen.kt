package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.designsystem.theme.Blue50
import nextstep.shoppingcart.ext.getFormattedPrice
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.ui.cart.component.CartItem


@Composable
fun CartListScreen(
    items: List<Cart>,
    modifier: Modifier = Modifier,
    onDelete: (Cart) -> Unit = {},
    onAdd: (Cart) -> Unit = {},
    onRemove: (Cart) -> Unit = {},
    onOrder : () -> Unit = {}
) {
    Column(modifier = modifier) {
        LazyColumn(
            Modifier
                .padding(horizontal = 18.dp, vertical = 16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items, key = { item -> item.product.id }) { item ->
                CartItem(item = item, onDelete = onDelete, onAdd = onAdd, onRemove = onRemove)
            }
        }
        TextButton(
            onClick = onOrder,
            modifier = Modifier
                .fillMaxWidth()
                .background(Blue50)
                .height(56.dp),
        ) {
            Text(
                text = stringResource(
                    R.string.cart_order,
                    items.sumOf { it.totalPrice }.getFormattedPrice()
                ),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}