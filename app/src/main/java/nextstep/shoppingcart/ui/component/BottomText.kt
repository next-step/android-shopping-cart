package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomText(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color(color = 0xFF2196F3))
            .clickable { onClick() }
            .padding(vertical = 15.dp)
            .semantics {
                contentDescription = "BottomText"
            },
        text = text,
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
    )
}
