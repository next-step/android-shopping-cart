package nextstep.shoppingcart.view.product

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.view.ItemCountButton
import nextstep.shoppingcart.view.resource.ShoppingCartTheme

const val productNameMaxLine = 1

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductItem(
    product: Product,
    onItemClick: (Product) -> Unit,
    onItemButtonClick: (Product) -> Unit,
    onAddClicked: (Product) -> Unit,
    onRemoveClicked: (Product) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.clickable { onItemClick(product) }) {
        Box {
            GlideImage(
                model = product.imageUrl,
                contentDescription = product.name,
                loading = placeholder(R.drawable.ic_launcher_foreground),
            )
            if (Cart.getButtonStateByProductName(product.name)) {
                ItemCountButton(
                    product = product,
                    itemCount = Cart.getCountByProductName(product.name),
                    onAddClicked = { onAddClicked(product) },
                    onRemoveClicked = { onRemoveClicked(product) },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(dimensionResource(id = R.dimen.product_item_circular_add_button_padding))
                        .background(
                            MaterialTheme.colorScheme.background
                        )
                )

            } else {
                CircularAddButton(
                    onClick = { onItemButtonClick(product) },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(dimensionResource(id = R.dimen.product_item_circular_add_button_padding))
                )
            }
        }
        Text(
            text = product.name,
            modifier = modifier.padding(bottom = dimensionResource(id = R.dimen.product_name_bottom_padding)),
            maxLines = productNameMaxLine,
            fontSize = dimensionResource(id = R.dimen.product_name_size).value.sp,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.product_item_currency_unit, product.price),
            fontSize = dimensionResource(id = R.dimen.product_price_size).value.sp,
        )
    }
}

@Composable
fun CircularAddButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .size(dimensionResource(id = R.dimen.product_item_circular_add_button_size))
            .clip(CircleShape),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.product_item_circular_add_button_content_padding))
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.product_app_bar_cart_icon_description),
            tint = Color.Black,
            modifier = Modifier.size(dimensionResource(id = R.dimen.product_item_circular_add_button_icon_size))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemAddedPreview() {
    ShoppingCartTheme {
        ProductItem(
            product = dummyProducts.first(),
            onItemClick = {},
            onItemButtonClick = {},
            onAddClicked = {},
            onRemoveClicked = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductItemNotAddedPreview() {
    ShoppingCartTheme {
        ProductItem(product = dummyProducts.first(),
            onItemClick = {},
            onItemButtonClick = {},
            onAddClicked = {},
            onRemoveClicked = {}
        )
    }
}
