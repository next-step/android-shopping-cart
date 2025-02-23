package nextstep.shoppingcart.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight.Companion.W700
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.theme.blue50

@Composable
fun ShoppingCartButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = blue50,
            contentColor = Color.White
        ),
        shape = RectangleShape,
        contentPadding = PaddingValues(16.dp),
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = W700,
        )
    }
}

@Preview
@Composable
private fun BottomAppBarPreview() {
    ShoppingCartButton(
        text = "장바구니 담기",
        onClick = {},
        modifier = Modifier.fillMaxWidth()
    )
}