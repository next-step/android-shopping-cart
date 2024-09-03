package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.data.Cart

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartScreen(
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cartList by remember {
        derivedStateOf { Cart.items }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Black
                ),
                title = {
                    Text(
                        text = "장바구니",
                        fontSize = 22.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onClickBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로 가기",
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }
            )
        },
        modifier = modifier.fillMaxSize(),
        content = { paddingValues ->
            CartContent(
                cartList = cartList,
                onClickIncrease = { product -> Cart.addOne(product) },
                onClickDecrease = { product -> Cart.removeOne(product) },
                onClickDelete = { product -> Cart.removeAll(product) },
                modifier = Modifier.padding(paddingValues),
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ShoppingCartScreenPreview() {
    ShoppingCartScreen({})
}
