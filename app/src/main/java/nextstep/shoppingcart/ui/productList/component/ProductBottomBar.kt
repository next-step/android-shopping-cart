package nextstep.shoppingcart.ui.productList.component

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.shoppingCart.ShoppingCartActivity

@Composable
fun ProductBottomBar(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    BottomAppBar(
        modifier
            .fillMaxWidth()
            .clickable {
                val intent = Intent(context, ShoppingCartActivity::class.java)
                context.startActivity(intent)
            },
        containerColor = Color(0xFF2196F3)
    ) {
        Text(
            text = stringResource(id = R.string.text_shopping_cart),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}