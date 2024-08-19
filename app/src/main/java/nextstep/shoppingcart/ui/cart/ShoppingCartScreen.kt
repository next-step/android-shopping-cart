package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import nextstep.shoppingcart.data.cart.Cart
import nextstep.shoppingcart.data.goods.Product
import nextstep.shoppingcart.ui.component.ShoppingTopBar

@Composable
fun ShoppingCart(navController: NavHostController) {
    Scaffold(
        topBar = {
            ShoppingTopBar(
                navController,
                title = "장바구니"
            )
        },
        bottomBar = {
            CartProductBottomBar {

            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(Cart.items) { item ->
                CartProduct(item)
            }
        }
    }
}

@Composable
private fun CartProductBottomBar(
    onClick: () -> Unit) {
    val totalPrice = remember { mutableIntStateOf(Cart.totalPrice) }
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2196F3),
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        shape = RectangleShape,
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(
            text = "주문하기(${"%,d".format(totalPrice.value)}원)",
            style = MaterialTheme.typography.titleLarge,
            maxLines = 1,
        )
    }
}

@Preview
@Composable
private fun ShoppingCartPreview() {
    Cart.addOne(product = Product(
        productId = 1,
        imageUrl = "https://picsum.photos/156/158",
        name = "상품1",
        price = 12000
    ))
    Cart.addOne(product = Product(
        productId = 2,
        imageUrl = "https://picsum.photos/156/158",
        name = "상품2",
        price = 12000
    ))
    ShoppingCart(navController = rememberNavController())
}