package nextstep.shoppingcart.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode
import nextstep.shoppingcart.R

object ImageUtil {

    @Composable
    fun getUrlIfNotPreview(url: String) =
        if (LocalInspectionMode.current) {
            R.drawable.woori
        } else {
            url
        }
}