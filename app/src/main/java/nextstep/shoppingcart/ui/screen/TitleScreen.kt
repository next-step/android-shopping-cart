package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R

@Preview(showBackground = true)
@Composable
private fun TitlePreview() {
    Title("상품 목록") {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Title(
    title: String,
    onClick: () -> Unit
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
        actions = {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clickable(onClick = onClick),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.shopping_cart),
                    contentDescription = "장바구니",
                    modifier = Modifier
                        .size(20.dp)
                )
            }

        }
    )
}