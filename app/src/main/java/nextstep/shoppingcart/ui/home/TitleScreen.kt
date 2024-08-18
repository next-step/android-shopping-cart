package nextstep.shoppingcart.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Title(
    title: String,
    onActionClick: () -> Unit
) {
    TopAppBar(
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = title,
                    fontSize = 22.sp,
                    color = Color(0xFF1D1B20)
                )
            }
        },
        navigationIcon = {
            Box(
                modifier = Modifier
                    .size(48.dp)
            )
        },
        actions = {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clickable(onClick = onActionClick),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "장바구니",
                    modifier = Modifier
                        .size(20.dp)
                )
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
private fun TitlePreview() {
    Title("상품 목록") {
    }
}
