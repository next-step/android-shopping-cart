package nextstep.shoppingcart.ui.product.list.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.cart.Cart
import nextstep.shoppingcart.data.cart.Cart.containProduct
import nextstep.shoppingcart.data.cart.CartItem
import nextstep.shoppingcart.ui.cart.component.InteractiveQuantity

@Composable
fun InteractiveProductImage(
    product: Product,
    items: List<CartItem>,
    modifier: Modifier = Modifier,
    onClickPlus: () -> Unit = {},
    onClickMinus: () -> Unit = {},
    onClickFab: () -> Unit = {}
) {

    Box(modifier = Modifier) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = product.imgUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = ColorPainter(Color.Black)
        )

        if (items.containProduct(product)) {
            InteractiveQuantity(
                modifier = Modifier.align(Alignment.BottomEnd),
                cartItem = items.find { it.product == product }!!,
                onClickMinus = { onClickMinus() },
                onClickPlus = { onClickPlus() }
            )
        } else {
            SmallFloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(26.dp)
                    .testTag(stringResource(id = R.string.test_tag_add_fab, product.name)),
                onClick = { onClickFab() },
                containerColor = Color.White,
                shape = CircleShape,
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Floating action button."
                )
            }
        }
    }
}

@Preview
@Composable
private fun InteractiveProductImageFabPreview() {
    InteractiveProductImage(
        product = Product(
            id = 1,
            name = "Product Name",
            price = 1000,
            imgUrl = "https://www.example.com/image.jpg"
        ),
        items = Cart.items,
        Modifier,
        onClickPlus = {},
        onClickMinus = {},
        onClickFab = {}
    )
}

@Preview
@Composable
private fun InteractiveProductImageQuantityPreview() {
    Cart.addOne(
        Product(
            id = 1,
            name = "Product Name",
            price = 1000,
            imgUrl = "https://www.example.com/image.jpg"
        )
    )
    InteractiveProductImage(
        product = Product(
            id = 1,
            name = "Product Name",
            price = 1000,
            imgUrl = "https://www.example.com/image.jpg"
        ),
        items = Cart.items,
        modifier = Modifier,
        onClickPlus = {},
        onClickMinus = {},
        onClickFab = {}
    )
}