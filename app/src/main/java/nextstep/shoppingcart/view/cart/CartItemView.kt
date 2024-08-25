package nextstep.shoppingcart.view.cart

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CartItemView(
    product: Product,
    itemCount: String,
    onItemRemoved: () -> Unit,
    onAddClicked: () -> Unit,
    onRemoveClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(
                dimensionResource(id = R.dimen.cart_item_border),
                Color.Gray,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.cart_item_border_corner_radius))
            )
            .padding(dimensionResource(id = R.dimen.cart_item_border_padding)),
    ) {
        Column {
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(id = R.dimen.cart_item_name_size).value.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
                IconButton(
                    onClick = {
                        onItemRemoved()
                    },
                ) {
                    Icon(
                        Icons.Filled.Close,
                        contentDescription = stringResource(id = R.string.cart_delete)
                    )
                }
            }
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                GlideImage(
                    model = product.imageUrl,
                    contentDescription = product.name,
                    loading = placeholder(R.drawable.ic_launcher_foreground),
                    modifier = modifier.size(dimensionResource(id = R.dimen.cart_item_image_size))
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
                        modifier = modifier
                    )
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(
                                start = dimensionResource(id = R.dimen.cart_item_quantity_padding_start),
                                dimensionResource(id = R.dimen.cart_item_quantity_padding)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                onRemoveClicked()
                            },
                            modifier = modifier.size(dimensionResource(id = R.dimen.cart_item_add_icon_size)),
                        ) {
                            Icon(
                                Icons.Filled.KeyboardArrowDown,
                                contentDescription = stringResource(id = R.string.cart_remove)
                            )
                        }
                        Text(
                            text = itemCount,
                            fontSize = dimensionResource(id = R.dimen.cart_item_quantity_text_size).value.sp,
                            modifier = modifier
                        )
                        IconButton(
                            onClick = {
                                onAddClicked()
                            },
                            modifier = modifier.size(dimensionResource(id = R.dimen.cart_item_remove_icon_size)),
                        ) {
                            Icon(
                                Icons.Filled.KeyboardArrowUp,
                                contentDescription = stringResource(id = R.string.cart_add)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemPreview() {
    ShoppingCartTheme {
        CartItemView(
            product = dummyProducts.first(),
            itemCount = "1",
            onItemRemoved = {},
            onAddClicked = {},
            onRemoveClicked = {}
        )
    }
}
