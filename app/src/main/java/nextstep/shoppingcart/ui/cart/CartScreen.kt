package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.domain.model.CartItem
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.component.BasicIconButton
import nextstep.shoppingcart.ui.theme.Blue50
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
internal fun CartRoute(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit = {},
) {
    var items by remember { mutableStateOf(Cart.items) }
    val totalPrice = remember(items) { Cart.totalPrice }

    CartScreen(
        items = items,
        totalPrice = totalPrice,
        navigateUp = onNavigateUp,
        onCancelClick = { item -> items = Cart.cancel(item) },
        onAddClick = { product -> items = Cart.add(product) },
        onRemoveClick = { product -> items = Cart.remove(product) },
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CartScreen(
    items: List<CartItem>,
    totalPrice: Int,
    navigateUp: () -> Unit,
    onCancelClick: (CartItem) -> Unit,
    onAddClick: (Product) -> Unit,
    onRemoveClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.cart_toolbar_title))
                },
                navigationIcon = {
                    BasicIconButton(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.navigate_back),
                        onClick = navigateUp,
                    )
                },
            )
        },
        bottomBar = {
            OrderButton(
                totalPrice = totalPrice,
                onClick = { /*TODO*/ },
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .testTag(stringResource(id = R.string.test_tag_order_btn)),
            )
        },
        modifier = modifier,
    ) { paddingValues ->
        CartContent(
            items = items,
            onCancelClick = onCancelClick,
            onAddClick = onAddClick,
            onRemoveClick = onRemoveClick,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(paddingValues),
        )
    }
}

@Composable
private fun CartContent(
    items: List<CartItem>,
    onCancelClick: (CartItem) -> Unit,
    onAddClick: (Product) -> Unit,
    onRemoveClick: (Product) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding =
            PaddingValues(
                horizontal = 18.dp,
                vertical = 16.dp,
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        items(items) { item ->
            CartCard(
                cartItem = item,
                onCancel = { onCancelClick(item) },
                onAddQuantityClick = { onAddClick(item.product) },
                onRemoveQuantityClick = { onRemoveClick(item.product) },
                modifier =
                    Modifier
                        .testTag(stringResource(id = R.string.test_tag_cart_card)),
            )
        }
    }
}

@Composable
private fun OrderButton(
    totalPrice: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues = PaddingValues(vertical = 15.dp),
) {
    Button(
        onClick = onClick,
        contentPadding = contentPaddingValues,
        colors =
            ButtonDefaults.buttonColors(
                containerColor = Blue50,
                contentColor = Color.White,
            ),
        shape = RectangleShape,
        modifier = modifier,
    ) {
        Text(
            text =
                stringResource(
                    id = R.string.order_btn_title,
                    stringResource(id = R.string.product_price, totalPrice),
                ),
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
private fun CartScreenPreview(
    @PreviewParameter(CartScreenPreviewParameterProvider::class) items: List<CartItem>,
) {
    ShoppingCartTheme {
        CartScreen(
            items = items,
            totalPrice = items.sumOf { it.totalPrice },
            navigateUp = { },
            onCancelClick = { },
            onAddClick = { },
            onRemoveClick = { },
        )
    }
}

class CartScreenPreviewParameterProvider : PreviewParameterProvider<List<CartItem>> {
    override val values: Sequence<List<CartItem>>
        get() =
            sequenceOf(
                listOf(
                    CartItem(
                        Product(
                            id = 1,
                            name = "Product 1",
                            price = 1000,
                            imgUrl = "https://www.example.com/product1.jpg",
                        ),
                        1,
                    ),
                    CartItem(
                        Product(
                            id = 2,
                            name = "Product 2",
                            price = 2000,
                            imgUrl = "https://www.example.com/product2.jpg",
                        ),
                        2,
                    ),
                ),
            )
}
