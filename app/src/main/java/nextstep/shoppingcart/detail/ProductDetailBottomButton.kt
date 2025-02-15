package nextstep.shoppingcart.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.Blue50
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailBottomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp),
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors().copy(containerColor = Blue50, contentColor = Color.White)
    ) {
        Text(
            text = stringResource(R.string.add_to_cart),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
private fun ProductDetailBottomButtonPreview() {
    ShoppingCartTheme {
        ProductDetailBottomButton(
            onClick = {}
        )
    }
}