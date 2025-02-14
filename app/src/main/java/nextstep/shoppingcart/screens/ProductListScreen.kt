package nextstep.shoppingcart.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.FakeProductRepository
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.domain.model.Products
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun ProductListScreen(
    products: Products,
    onProductClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier.padding(vertical = 12.dp, horizontal = 18.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            key = { it.id },
            items = products.value
        ) { product ->
            Product(
                imageUrl = product.imageUrl,
                name = product.name,
                price = product.price.value,
                onProductClick = { onProductClick(product) }
            )
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
internal fun Product(
    imageUrl: String,
    name: String,
    price: Int,
    onProductClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.clickable(onClick = onProductClick),
    ) {
        GlideImage(
            model = imageUrl,
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.0f),
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(start = 4.dp),
        )
        Text(
            text = stringResource(R.string.price_format, price),
            modifier = Modifier.padding(start = 4.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(
            products = FakeProductRepository.getAllProducts(),
            onProductClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductPreview() {
    ShoppingCartTheme {
        val product = FakeProductRepository.getFirstProduct()
        Product(
            imageUrl = product.imageUrl,
            name = product.name,
            price = product.price.value,
            onProductClick = {},
        )
    }
}
