package nextstep.shoppingcart

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import nextstep.shoppingcart.model.ProductModel
import org.junit.Test

class ProductPriceTextTest {
    private val model = ProductModel(
        id = 0L,
        imageUrl = "",
        name = "",
        price = 0,
    )

    @Test
    fun 세자리마다_콤마() {
        // given
        val price = 1_000_000
        val priceModel = model.copy(price = price)

        // then
        assertTrue(priceModel.priceText == "1,000,000")
    }

    @Test
    fun 세자리_이하는_콤마_없음() {
        // given
        val price = 100
        val priceModel = model.copy(price = price)

        // then
        assertFalse(priceModel.priceText.contains(","))
    }
}