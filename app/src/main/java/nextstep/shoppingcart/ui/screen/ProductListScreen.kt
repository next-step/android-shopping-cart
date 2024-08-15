package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R


@Composable
fun ProductListScreen() {
    Scaffold(
        modifier = Modifier.padding(18.dp)
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 32.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                fontSize = 32.sp,
                text = stringResource(id = R.string.text_product_list_title)
            )

            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping Cart",
                modifier = Modifier
                    .size(24.dp)
                    .align(AbsoluteAlignment.CenterRight)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListScreenPrev() {
    ProductListScreen()
}