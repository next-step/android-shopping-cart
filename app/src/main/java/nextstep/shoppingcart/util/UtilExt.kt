package nextstep.shoppingcart.util

import java.text.NumberFormat
import java.util.Locale

/**
 * 로컬 화폐 포맷 처리 용 확장 함수
 * 한국 화폐면 '원' String 맨뒤에 붙여줌
**/
fun Long.getLocalCurrencyFormat(locale: Locale = Locale.getDefault()): String {
    val numberFormat = NumberFormat.getNumberInstance(locale)
    val lastString =  if(locale == Locale.KOREA) "원" else ""
    return numberFormat.format(this) + lastString
}