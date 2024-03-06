package nextstep.shoppingcart.ui.screen.cart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.component.PriceText
import nextstep.shoppingcart.ui.component.ProductImage
import nextstep.shoppingcart.ui.screen.product.detail.BottomText
import nextstep.shoppingcart.ui.screen.product.detail.ProductTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    cartBox: List<CartItem> = CartBox.value,
    onClickBack: () -> Unit = {}
) {
    var cart by remember {
        mutableStateOf(cartBox)
    }
    val totalPrice by remember(key1 = cart) {
        mutableIntStateOf(
            cart.sumOf { it.count.times(other = it.product.price) }
        )
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.cart)) },
                navigationIcon = {
                    IconButton(onClick = { onClickBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.go_back),
                        )
                    }
                },
            )
        },
        content = { innerPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = innerPadding),
                verticalArrangement = Arrangement.spacedBy(space = 16.dp)
            ) {
                items(items = cart) { item ->
                    CartItem(
                        item = item,
                        onDeleteItem = {
                            cart = CartBox.removed(it)
                        },
                        onClickInc = {
                            CartBox.add(it)
                            cart = CartBox.value
                        },
                        onClickDec = {
                            CartBox.remove(it)
                            cart = CartBox.value
                        }
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(height = 66.dp))
                }
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                BottomText(
                    text = stringResource(id = R.string.order) +
                        "(${stringResource(id = R.string.price_format, totalPrice)})",
                    onClick = {}
                )
            }
        },
    )
}

@Composable
private fun CartItem(
    item: CartItem,
    onDeleteItem: (Product) -> Unit,
    onClickInc: (Product) -> Unit,
    onClickDec: (Product) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .fillMaxWidth()
            .height(height = 150.dp)
            .border(
                border = BorderStroke(width = 1.dp, color = Color(0xFFAAAAAA)),
                shape = RoundedCornerShape(size = 4.dp)
            )
            .padding(all = 18.dp)
            .semantics {
                contentDescription = "CartItem"
            }
    ) {
        CartHeader(
            item = item.product,
            onDeleteItem = {
                onDeleteItem(it)
            }
        )
        Row(
            modifier = Modifier
                .padding(top = 6.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProductImage(imageUrl = item.product.imageUrl)
            Column(
                modifier = Modifier.padding(top = 18.dp),
                horizontalAlignment = Alignment.End
            ) {
                PriceText(
                    price = item.product.price,
                    fontSize = 16.sp
                )
                CountIndicator(
                    count = item.count.toString(),
                    onClickInc = { onClickInc(item.product) },
                    onClickDec = { onClickDec(item.product) }
                )
            }
        }
        Spacer(modifier = Modifier.weight(weight = 1f))
    }
}

@Composable
private fun CountIndicator(
    count: String,
    onClickInc: () -> Unit,
    onClickDec: () -> Unit
) {
    Row(
        modifier = Modifier.width(width = 126.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .weight(weight = 1f)
                .fillMaxHeight()
                .clickable {
                    onClickDec()
                },
            imageVector = Icons.Filled.KeyboardArrowDown,
            contentDescription = stringResource(R.string.minus)
        )
        Text(
            modifier = Modifier
                .weight(weight = 1f)
                .fillMaxHeight()
                .semantics {
                    contentDescription = "Count"
                },
            text = count,
            textAlign = TextAlign.Center,
            fontSize = 22.sp
        )
        Image(
            modifier = Modifier
                .weight(weight = 1f)
                .fillMaxHeight()
                .clickable {
                    onClickInc()
                },
            imageVector = Icons.Filled.KeyboardArrowUp,
            contentDescription = stringResource(R.string.plus)
        )
    }
}

@Composable
private fun CartHeader(
    item: Product,
    onDeleteItem: (Product) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 24.dp)
    ) {
        ProductTitle(
            modifier = Modifier.weight(weight = 1f),
            title = item.name,
            fontSize = 20.sp
        )
        Image(
            modifier = Modifier.clickable {
                onDeleteItem(item)
            },
            imageVector = Icons.Filled.Clear,
            contentDescription = stringResource(R.string.delete),
        )
    }
}

@Preview
@Composable
private fun Preview() {
    CartScreen(
        cartBox = listOf(
            CartItem(count = 2, product = Product.fixture.first()),
            CartItem(count = 1, product = Product.fixture.last())
        ),
        onClickBack = {}
    )
}
