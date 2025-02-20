package nextstep.shoppingcart.features.productlist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.components.ItemCounter
import nextstep.shoppingcart.components.ProductImage
import nextstep.shoppingcart.components.buttons.ShoppingCartFloatingActionButton
import nextstep.shoppingcart.components.buttons.ShoppingCartFloatingActionButtonType
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductListItem(
    product: Product,
    count: Int?,
    onAddOneClick: () -> Unit,
    onRemoveOneClick: () -> Unit,
    onProductClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.clickable(onClick = onProductClick),
    ) {
        ProductImageAndCounter(
            product = product,
            count = count,
            onAddOneClick = onAddOneClick,
            onRemoveOneClick = onRemoveOneClick,
        )
        Spacer(Modifier.height(8.dp))
        ProductTitle(
            title = product.name,
            modifier = Modifier.padding(start = 4.dp),
        )
        ProductPrice(
            price = product.price.value,
            modifier = Modifier.padding(start = 4.dp),
        )
    }
}

@Composable
private fun ProductImageAndCounter(
    product: Product,
    count: Int?,
    onAddOneClick: () -> Unit,
    onRemoveOneClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        ProductImage(
            imageUrl = product.imageUrl,
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 1f)
        )
        if (count == null) {
            ShoppingCartFloatingActionButton(
                buttonType = ShoppingCartFloatingActionButtonType.ADD,
                onClick = onAddOneClick,
                modifier = Modifier
                    .padding(
                        end = 12.dp,
                        bottom = 12.dp,
                    )
                    .align(Alignment.BottomEnd),
            )
        } else {
            ItemCounter(
                count = count,
                onRemoveOneClick = onRemoveOneClick,
                onAddOneClick = onAddOneClick,
                modifier = Modifier
                    .padding(horizontal = 15.dp)
                    .padding(bottom = 12.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(4.dp))
                    .align(Alignment.BottomEnd),
            )
        }
    }
}

@Composable
private fun ProductTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier,
    )
}

@Composable
private fun ProductPrice(price: Int, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.price_format, price),
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductWithCountZeroPreview() {
    ShoppingCartTheme {
        Column {
            ProductListItem(
                product = FakeProductRepository.getFirstProduct(),
                count = null,
                onAddOneClick = {},
                onRemoveOneClick = {},
                onProductClick = {},
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductWithCountOnePreview() {
    ShoppingCartTheme {
        Column {
            ProductListItem(
                product = FakeProductRepository.getFirstProduct(),
                count = 2,
                onAddOneClick = {},
                onRemoveOneClick = {},
                onProductClick = {},
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductImageAndCounterPreview() {
    ShoppingCartTheme {
        Column {
            ProductImageAndCounter(
                product = FakeProductRepository.getFirstProduct(),
                count = null,
                onAddOneClick = {},
                onRemoveOneClick = {},
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductTitlePreview() {
    ShoppingCartTheme {
        ProductTitle(title = "Wireless Mouse")
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductPricePreview() {
    ShoppingCartTheme {
        ProductPrice(price = 10000)
    }
}
