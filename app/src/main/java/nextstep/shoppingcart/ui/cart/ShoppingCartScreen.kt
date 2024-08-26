package nextstep.shoppingcart.ui.cart

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartScreen(
    onClickBackButton: () -> Unit,
    modifier: Modifier = Modifier
) {
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
                    IconButton(onClick = { onClickBackButton() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "뒤로 가기",
                            modifier = Modifier
                                .size(48.dp)
                                .clickable { onClickBackButton() }
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            ShoppingCartContent(
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}
