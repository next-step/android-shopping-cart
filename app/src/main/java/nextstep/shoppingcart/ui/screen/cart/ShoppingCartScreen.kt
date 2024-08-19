package nextstep.shoppingcart.ui.screen.cart

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.component.ProductImage
import nextstep.shoppingcart.ui.component.SoppingCartButton
import nextstep.shoppingcart.ui.screen.products.model.ProductModel
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.utils.ThemePreviews

@Composable
fun ShoppingCartRoute(
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit,
) {
    var cartItems by remember { mutableStateOf(Cart.items) }
    val totalPrice by remember { derivedStateOf { cartItems.sumOf { it.totalPrice } } }
    val onClearClick = remember { { item: ProductModel -> cartItems = Cart.removeAll(item) } }
    val onMinusClick = remember { { item: ProductModel -> cartItems = Cart.removeOne(item) } }
    val onPlusClick = remember { { item: ProductModel -> cartItems = Cart.addOne(item) } }

    ShoppingCartScreen(
        carItems = cartItems.toPersistentList(),
        totalPrice = totalPrice,
        onNavigationClick = onNavigationClick,
        onClearClick = onClearClick,
        onMinusClick = onMinusClick,
        onPlusClick = onPlusClick,
        onOrderClick = { /* TODO */ },
        modifier = modifier,
    )
}

@Composable
private fun ShoppingCartScreen(
    carItems: PersistentList<CartItem>,
    totalPrice: Int,
    onClearClick: (ProductModel) -> Unit,
    onMinusClick: (ProductModel) -> Unit,
    onPlusClick: (ProductModel) -> Unit,
    onOrderClick: () -> Unit,
    onNavigationClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ShoppingCartTopAppBar(onNavigationClick = onNavigationClick)
        },
        bottomBar = {
            SoppingCartButton(
                text = stringResource(id = R.string.shopping_cart_order_with_total_price, totalPrice)
            ) {
                onOrderClick()
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            items(
                items = carItems,
                key = { it.product.id },
            ) {
                ShoppingCartItem(
                    name = it.product.name,
                    price = it.product.price,
                    imageUrl = it.product.imageUrl,
                    count = it.count,
                    onClearClick = { onClearClick(it.product) },
                    onMinusClick = { onMinusClick(it.product) },
                    onPlusClick = { onPlusClick(it.product) }
                )
            }
        }
    }
}

@Composable
private fun ShoppingCartItem(
    modifier: Modifier = Modifier,
    name: String,
    price: Int,
    count: Int,
    imageUrl: String,
    onClearClick: () -> Unit,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(vertical = 16.dp, horizontal = 18.dp)
            .fillMaxWidth()
            .height(150.dp)
            .border(1.dp, MaterialTheme.colorScheme.onSurface)
            .padding(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = name, style = MaterialTheme.typography.headlineSmall)
            Icon(
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onClearClick() },
                imageVector = Icons.Filled.Clear,
                contentDescription = stringResource(R.string.shopping_cart_clear_button)
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 6.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            ProductImage(
                modifier = Modifier.size(136.dp, 84.dp),
                productName = name,
                imageUrl = imageUrl
            )

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(text = stringResource(id = R.string.product_price, price))

                ShoppingCartItemCounter(
                    count = count,
                    onMinusClick = onMinusClick,
                    onPlusClick = onPlusClick
                )
            }
        }
    }
}

@Composable
private fun ShoppingCartItemCounter(
    count: Int,
    onMinusClick: () -> Unit,
    onPlusClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CounterTextButton(onClick = onMinusClick, text = "-")
        Text(text = count.toString(), style = MaterialTheme.typography.titleLarge)
        CounterTextButton(onClick = onPlusClick, text = "+")
    }
}

@Composable
private fun CounterTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .size(42.dp)
            .clickable { onClick() }, contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ShoppingCartTopAppBar(
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit,
) {
    TopAppBar(modifier = modifier, title = {
        Text(
            text = stringResource(R.string.shopping_cart_app_bar_title), style = MaterialTheme.typography.titleLarge
        )
    }, navigationIcon = {
        IconButton(onClick = onNavigationClick) {
            Icon(
                imageVector = Icons.Filled.ArrowBack, contentDescription = stringResource(R.string.back_button_navigation_icon_description)
            )
        }
    })
}

@ThemePreviews
@Composable
private fun ShoppingCartItemCounterPreview() {
    ShoppingCartTheme {
        ShoppingCartItemCounter(
            count = 200,
            onMinusClick = {},
            onPlusClick = {}
        )
    }
}

@ThemePreviews
@Composable
private fun ShoppingCartItemPreview() {
    ShoppingCartTheme {
        ShoppingCartItem(
            name = "iPhone 15 Pro Max",
            price = 190000,
            count = 2,
            onClearClick = {},
            onMinusClick = {},
            onPlusClick = {},
            imageUrl = ""
        )
    }
}

@ThemePreviews
@Composable
private fun ShoppingCartScreenPreview() {
    ShoppingCartScreen(
        carItems = persistentListOf(
            CartItem(
                product = ProductModel(
                    name = "iPhone 15 Pro Max",
                    imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                    price = 1_900_000
                ),
                count = 2
            ),
            CartItem(
                product = ProductModel(
                    name = "iPhone 15 Pro Max",
                    imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                    price = 1_900_000
                ),
                count = 2
            ),
            CartItem(
                product = ProductModel(
                    name = "iPhone 15 Pro Max",
                    imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                    price = 1_900_000
                ),
                count = 2
            ),
            CartItem(
                product = ProductModel(
                    name = "iPhone 15 Pro Max",
                    imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
                    price = 1_900_000
                ),
                count = 2
            ),
        ),
        totalPrice = 268600,
        onClearClick = {},
        onMinusClick = {},
        onPlusClick = {},
        onOrderClick = {},
        onNavigationClick = {},
    )
}
