package nextstep.shoppingcart.ui.screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun ProductListPreview() {
    ProductList()
}

@Composable
fun ProductList(modifier: Modifier = Modifier) {
    Scaffold (
        topBar = {
            Title(title = "상품 목록") {

            }
        },
        content = { paddingValues ->  
            
        }
    )
}