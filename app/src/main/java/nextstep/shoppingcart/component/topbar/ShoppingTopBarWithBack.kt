package nextstep.shoppingcart.component.topbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingTopBarWithBack(
    title: String,
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    ShoppingTopBar(
        modifier = modifier,
        title = title,
        titleTextAlign = TextAlign.Start,
        leftActionButtons = {
            IconButton(
                onClick = onClickBack
            ) {
                Icon(
                    modifier = Modifier
                        .size(20.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "ShoppingCart"
                )
            }
        }
    )
}

@Preview(name = "ShoppingDetailTopBar", showBackground = true)
@Composable
private fun Preview1() {
    ShoppingTopBarWithBack(
        modifier = Modifier.fillMaxWidth(),
        title = "상품 목록",
        onClickBack = {}
    )
}