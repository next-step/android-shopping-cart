package nextstep.shoppingcart.ui.screen.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.theme.Blue50

@Composable
fun BlueRectangleButton(
    buttonTitle: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(Blue50),
        onClick = onClick
    ) {
        Text(
            text = buttonTitle,
            modifier = Modifier.padding(vertical = 15.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.W700,
            color = Color.White,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BlueRectangleButtonPreview() {
    BlueRectangleButton(
        buttonTitle = "Button",
        onClick = { }
    )
}