package nextstep.shoppingcart.ui.screen.utils

import java.text.NumberFormat
import java.util.Locale

object FormatUtils {
    fun formatMoney(number: Int): String {
        val formatter = NumberFormat.getNumberInstance(Locale.PRC) // ✅ 로케일별 포맷 가능
        return formatter.format(number)
    }
}