package nextstep.shoppingcart.ext

import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics


fun Modifier.setContentDescription(desc: String): Modifier =
    semantics { contentDescription = desc }
