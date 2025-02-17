package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.CartProductModel
import nextstep.shoppingcart.model.ProductModel
import nextstep.shoppingcart.ui.theme.Gray10
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.Typography

@Composable
fun CartProduct(
    model: CartProductModel,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .border(
                color = Gray10,
                shape = RoundedCornerShape(4.dp),
                width = 1.dp
            )
            .padding(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = model.name,
                style = Typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .clickable { Cart.removeAll(model.product) },
                imageVector = Icons.Filled.Clear,
                contentDescription = stringResource(R.string.clear),
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
        ) {
            Thumbnail(
                id = model.id,
                imageUrl = model.product.imageUrl,
                name = model.name,
                modifier = Modifier
                    .width(136.dp)
                    .height(84.dp),
            )
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom,
            ) {
                PriceText(
                    price = model.product.price,
                    style = Typography.bodyMedium,
                )
                CountControlButton(
                    count = model.count,
                    onAddClick = { Cart.addOne(model.product) },
                    onRemoveClick = { Cart.removeOne(model.product) },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartProductPreview() {
    val model = CartProductModel(
        product = ProductModel(
            id = 2399L,
            imageUrl = "Jamaal",
            name = "초코우유",
            price = 2_500
        ),
        count = 1,
    )

    ShoppingCartTheme {
        CartProduct(model = model)
    }
}