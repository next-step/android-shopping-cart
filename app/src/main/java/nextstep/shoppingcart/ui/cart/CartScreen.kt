package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Products
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.cart.component.CartItemList

@Composable
internal fun CartScreen(
    onBackClick: () -> Unit,
    products: List<Product> = Products,
) {
    val productsState = remember(products) { mutableStateOf(products) }
    var countByProductId: Map<String, Int> by remember { mutableStateOf(mapOf()) }

    CartScreen(
        products = productsState.value,
        onBackClick = onBackClick,
        countByProductId = countByProductId,
        onCartDeleteClick = { product ->
            productsState.value = products.filter { it.id != product.id }
            countByProductId = countByProductId.filterKeys { it != product.id }
        },
        onCartPlusClick = {
            val nextValue = (countByProductId.getOrDefault(it.id, 0) + 1)
            val nextCountByProductId = countByProductId.toMutableMap()
            nextCountByProductId[it.id] = nextValue
            countByProductId = nextCountByProductId
        },
        onCartMinusClick = {
            val nextValue = (countByProductId.getOrDefault(it.id, 0) - 1).coerceAtLeast(0)
            val nextCountByProductId = countByProductId.toMutableMap()
            nextCountByProductId[it.id] = nextValue
            countByProductId = nextCountByProductId
        },
        onOrderClick = { /*TODO*/ })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CartScreen(
    products: List<Product>,
    onBackClick: () -> Unit,
    countByProductId: Map<String, Int>,
    onCartDeleteClick: (Product) -> Unit,
    onCartPlusClick: (Product) -> Unit,
    onCartMinusClick: (Product) -> Unit,
    onOrderClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.cart_title)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로가기",
                        )
                    }
                },
            )
        },
        content = { innerPadding ->
            CartContent(
                products = products,
                countByProductId = countByProductId,
                onCartDeleteClick = onCartDeleteClick,
                onCartPlusClick = onCartPlusClick,
                onCartMinusClick = onCartMinusClick,
                onOrderClick = onOrderClick,
                modifier = Modifier.padding(innerPadding),
            )
        },
    )
}

@Composable
private fun CartContent(
    products: List<Product>,
    countByProductId: Map<String, Int>,
    onCartDeleteClick: (Product) -> Unit,
    onCartPlusClick: (Product) -> Unit,
    onCartMinusClick: (Product) -> Unit,
    onOrderClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        CartItemList(
            products = products,
            countByProductId = countByProductId,
            onDeleteClick = onCartDeleteClick,
            onPlusClick = onCartPlusClick,
            onMinusClick = onCartMinusClick,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        OrderButton(
            totalPrice = remember(products, countByProductId) {
                products.sumOf { it.price * countByProductId.getOrDefault(it.id, 0) }
            },
            onClick = onOrderClick,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
private fun OrderButton(
    totalPrice: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .background(Color(0xFF2196F3))
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(12.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(id = R.string.cart_order_fmt, totalPrice),
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            color = Color.White,
        )
    }
}

@Preview
@Composable
private fun CartScreenPreview() {
    MaterialTheme {
        CartScreen(
            onBackClick = { },
        )
    }
}
