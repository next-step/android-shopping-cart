package nextstep.shoppingcart.data

import nextstep.shoppingcart.model.Product

object ProductsTestData {
    val productTestDataList = List(30) { i ->
        Product(
            name = "[${i}] PET 보틀 - 음료수,정사각형 음료수,정사각형 음료수,정사각형 음료수",
            imageUrl = "https://i.namu.wiki/i/Ert2K83rRrg_S7Z-T1wpr2yu2Qp0cAF4XHkah-rAjQaJP9YzTQvHGQ90p5cgs2OEEJIDHBXkHVYL3AuJqaX9xGN91bOoCVfIHyZxMZ7ml6ZEvNRB9ibxNSml6VAno4o6JeOuPEWOGg1cw3N5wIB-xw.webp",
            price = 10000 + i,
            productId = "id${i}"
        )
    }
}
