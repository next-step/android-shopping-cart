package nextstep.shoppingcart.ui.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.ProductImage
import nextstep.shoppingcart.ui.screen.cart.Cart
import nextstep.shoppingcart.ui.screen.products.model.dummyProductModels
import nextstep.shoppingcart.ui.theme.Blue50
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.utils.ThemePreviews

@Composable
fun ProductDetailRoute(
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit,
    onCartClick: (id: String) -> Unit,
    id: String,
) {
    val product = remember { dummyProductModels.find { it.id == id } }
    if (product != null) {
        ProductDetailScreen(
            modifier = modifier,
            price = product.price,
            itemName = product.name,
            itemImageUrl = product.imageUrl,
            onNavigationClick = onNavigationClick,
            onCartClick = {
                Cart.addOne(product)
                onCartClick(id)
            },
        )
    }
}

@Composable
private fun ProductDetailScreen(
    price: Int,
    itemName: String,
    itemImageUrl: String,
    onNavigationClick: () -> Unit,
    onCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = { ProductDetailTopAppBar { onNavigationClick() } }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState()),
        ) {
            ProductImage(
                modifier = Modifier.aspectRatio(1f),
                productName = itemName,
                imageUrl = itemImageUrl
            )

            Text(
                text = itemName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(18.dp)
            )

            Divider()

            ProductDetailPrice(price)

            Spacer(modifier = Modifier.weight(1f))

            SoppingCartButton { onCartClick() }
        }
    }
}

@Composable
private fun SoppingCartButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue50,
            contentColor = Color.White
        )
    ) {
        Text(
            text = stringResource(R.string.product_detail_shopping_cart),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun ProductDetailPrice(
    price: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(18.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.product_detail_price),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = stringResource(id = R.string.product_price, price),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProductDetailTopAppBar(
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = stringResource(R.string.product_detail_app_bar_title),
                style = MaterialTheme.typography.titleLarge
            )
        },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button_navigation_icon_description)
                )
            }
        }
    )
}

@ThemePreviews
@Composable
private fun SoppingCartButtonPreview() {
    ShoppingCartTheme {
        SoppingCartButton {}
    }
}

@ThemePreviews
@Composable
private fun ProductDetailPricePreview() {
    ShoppingCartTheme {
        ProductDetailPrice(
            price = 1_900_000
        )
    }
}


@ThemePreviews
@Composable
private fun ProductDetailTopAppBarPreview() {
    ShoppingCartTheme {
        ProductDetailTopAppBar {}
    }
}

@ThemePreviews
@Composable
private fun ProductDetailScreenPreview() {
    ShoppingCartTheme {
        ProductDetailScreen(
            price = 1_900_000,
            itemName = "iPhone 15 Pro Max",
            itemImageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
            onNavigationClick = {},
            onCartClick = {}
        )
    }
}
