package nextstep.shoppingcart.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Cart
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.domain.model.Products
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductListScreen(
    products: Products,
    cart: Cart,
    onAddOneClick: (Product) -> Unit,
    onRemoveOneClick: (Product) -> Unit,
    onProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier.padding(horizontal = 18.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            key = { it.id },
            items = products.value
        ) { product ->
            Product(
                product = product,
                count = cart.find(product)?.count?.value,
                onAddOneClick = { onAddOneClick(product) },
                onRemoveOneClick = { onRemoveOneClick(product) },
                onProductClick = { onProductClick(product) },
            )
        }
    }
}

@Composable
internal fun Product(
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
        Text(
            text = product.name,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(start = 4.dp),
        )
        Text(
            text = stringResource(R.string.price_format, product.price.value),
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
            FloatingActionButton(
                onClick = onAddOneClick,
                containerColor = Color.White,
                shape = CircleShape,
                modifier = Modifier
                    .padding(end = 12.dp, bottom = 12.dp)
                    .align(Alignment.BottomEnd),
            ) {
                Icon(Icons.Filled.Add, null)
            }
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


@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(
            products = FakeProductRepository.getAllProducts(),
            cart = Cart(),
            onAddOneClick = {},
            onRemoveOneClick = {},
            onProductClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductPreview() {
    ShoppingCartTheme {
        Product(
            product = FakeProductRepository.getFirstProduct(),
            count = 1,
            onAddOneClick = {},
            onRemoveOneClick = {},
            onProductClick = {},
        )
    }
}
