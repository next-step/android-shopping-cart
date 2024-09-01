package nextstep.shoppingcart.ui.component


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.Blue50

@Composable
fun BlueBottomButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Blue50
        ),
    ) {
        Text(
            text = label,
            fontSize = 20.sp,
            fontWeight = Bold,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailCartAddButtonPreview() {
    Box {
        BlueBottomButton(
            "장바구니 담기", {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrderButtonPreview() {
    Box {
        BlueBottomButton(
            stringResource(id = R.string.price_format_button_label, 1000), {}
        )
    }
}
