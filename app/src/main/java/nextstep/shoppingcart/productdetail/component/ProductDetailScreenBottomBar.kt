package nextstep.shoppingcart.productdetail.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.theme.NextStepTheme

@Composable
internal fun ProductDetailScreenBottomBar(
    onAddToCartClick: () -> Unit,
) {
    Surface(
        shadowElevation = 4.dp,
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFF2196F3),
        onClick = onAddToCartClick,
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.put_in_shopping_cart),
                modifier = Modifier.padding(vertical = 15.dp),
                style = NextStepTheme.typography.roboto20B,
                color = Color.White,
            )
        }
    }
}