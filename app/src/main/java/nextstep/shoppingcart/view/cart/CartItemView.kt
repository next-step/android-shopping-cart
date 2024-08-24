package nextstep.shoppingcart.view.cart

import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CartItemView(
    product: Product,
    onItemRemoved: () -> Unit,
    onAddClicked: () -> Unit,
    onRemoveClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var itemCount by remember {
        mutableStateOf(
            Cart.getCountByProductName(product.name).toString()
        )
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(1.dp))
            .padding(18.dp),
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
                    fontSize = 20.sp,
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
                    modifier = modifier.size(135.dp)
                )

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.product_item_currency_unit,
                            product.price
                        ),
                        fontSize = 20.sp,
                        modifier = modifier
                    )
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(start = 41.dp, 11.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = {
                                Cart.removeOne(product)
                                val newCount = Cart.getCountByProductName(product.name)
                                if (newCount == 0) {
                                    onItemRemoved()
                                } else {
                                    itemCount = newCount.toString()
                                }
                                onRemoveClicked()
                            },
                            modifier = modifier.size(22.dp),
                        ) {
                            Icon(
                                Icons.Filled.KeyboardArrowDown,
                                contentDescription = stringResource(id = R.string.cart_add)
                            )
                        }
                        Text(
                            text = itemCount,
                            fontSize = 22.sp,
                            modifier = modifier
                        )
                        IconButton(
                            onClick = {
                                Cart.addOne(product)
                                itemCount = Cart.getCountByProductName(product.name).toString()
                                onAddClicked()
                            },
                            modifier = modifier.size(22.dp),
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
            onItemRemoved = {},
            onAddClicked = {},
            onRemoveClicked = {})
    }
}
