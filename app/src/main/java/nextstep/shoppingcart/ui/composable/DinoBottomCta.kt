package nextstep.shoppingcart.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoxScope.DinoBottomCta(
    ctaText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TextButton(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
        shape = RectangleShape,
        contentPadding = PaddingValues(15.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color(0xff2196F3)
        ),
        onClick = onClick
    ) {
        Text(
            text = ctaText,
            fontWeight = FontWeight.W700,
            fontSize = 20.sp,
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun DinoBottomCtaPreview() {
    Box {
        DinoBottomCta(
            ctaText = "버튼",
            onClick = {

            }
        )
    }
}
