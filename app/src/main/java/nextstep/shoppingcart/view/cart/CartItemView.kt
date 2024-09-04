package nextstep.shoppingcart.view.cart

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.CartItem
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CartItemView(
    product: Product,
    onItemRemoved: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .border(
                width = dimensionResource(id = R.dimen.cart_item_border),
                color = Color.Gray,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.cart_item_border_corner_radius))
            )
            .padding(dimensionResource(id = R.dimen.cart_item_border_padding)),
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(id = R.dimen.cart_item_name_size).value.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.weight(1f),
                )
                IconButton(
                    onClick = {
                        onItemRemoved()
                    },
                ) {
                    Icon(
                        Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.cart_delete) + " ${product.name}"
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                GlideImage(
                    model = product.imageUrl,
                    contentDescription = product.name,
                    loading = placeholder(R.drawable.ic_launcher_foreground),
                    modifier = Modifier.size(dimensionResource(id = R.dimen.cart_item_image_size))
                )

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.product_item_currency_unit,
                            product.price
                        ),
                        fontSize = dimensionResource(id = R.dimen.cart_item_price_size).value.sp,
                    )
                    content()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemPreview(
    @PreviewParameter(CartItemPreviewParameterProvider::class) cartItem: CartItem
) {
    ShoppingCartTheme {
        CartItemView(
            product = cartItem.product,
            onItemRemoved = {},
            content = {
                CartItemCountButton(
                    product = cartItem.product,
                    itemCount = cartItem.count,
                    onAddClicked = {},
                    onRemoveClicked = {},
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(id = R.dimen.cart_item_quantity_padding_start),
                            dimensionResource(id = R.dimen.cart_item_quantity_padding)
                        )
                )
            }
        )
    }
}

class CartItemPreviewParameterProvider : PreviewParameterProvider<CartItem> {
    override val values = sequenceOf(
        CartItem(product = dummyProducts.first(), count = 1, isShowCountButton = false),
        CartItem(
            product = Product("[최고심] 이건이름이매우긴상품이야살사람은사고말사람은말어", "http://www.abc.com", 1_000_000),
            count = 100,
            isShowCountButton = false
        ),
    )
}
