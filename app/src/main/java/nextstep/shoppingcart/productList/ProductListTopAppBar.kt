package nextstep.shoppingcart.productList

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListTopAppBar(
    count: Int,
    onCartButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = "상품 목록")
        },
        actions = {
            IconButton(
                onClick = onCartButtonClick,
            ) {
                BadgedBox(
                    modifier = modifier.clickable {
                        onCartButtonClick()
                    },
                    badge = {
                        if (count > 0) {
                            Badge(
                                containerColor = Color.Red,
                                contentColor = Color.White
                            ) {
                                Text("$count")
                            }
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ShoppingCart,
                        contentDescription = "cart",
                    )
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
        ),
        modifier = modifier,
    )
}

@Preview(name = "count 가 0일 때 상품 목록 TopAppBar 미리보기", showBackground = true)
@Composable
private fun P1() {
    ProductListTopAppBar(
        count = 0,
        onCartButtonClick = {},
    )
}

@Preview(name = "count 가 0보다 클 때 상품 목록 TopAppBar 미리보기", showBackground = true)
@Composable
private fun P2() {
    ProductListTopAppBar(
        count = 1,
        onCartButtonClick = {},
    )
}