package nextstep.shoppingcart.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.theme.Blue50
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ShoppingTextButton(
    text : String,
    onClick : () -> Unit,
    modifier: Modifier = Modifier,
    shape : Shape = RectangleShape,
    colors : ButtonColors = ButtonDefaults.textButtonColors(
        containerColor = Blue50,
        contentColor = Color.White
    ),
    textStyle: TextStyle = MaterialTheme.typography.titleSmall,
    fontWeight: FontWeight = FontWeight.Bold
) {
    TextButton(
        modifier = modifier.height(54.dp),
        shape = shape,
        colors = colors,
        onClick = onClick
    ) {
        Text(
            text= text,
            style = textStyle,
            fontWeight = fontWeight
        )
    }
}

@Preview
@Composable
private fun PreviewShoppingTextButton() {
    ShoppingCartTheme {
        ShoppingTextButton(
            modifier = Modifier.fillMaxWidth(),
            text = "장바구니 담기",
            onClick = {}
        )
    }
}