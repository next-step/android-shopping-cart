package nextstep.shoppingcart

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.productList.ProductList
import org.junit.Rule
import org.junit.Test

class ProductListTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 리스트에_6개의_아이템이_노출된다() {
        // given
        val product = Product(
            name = "테스트",
            price = 10000,
            imageUrl = ""
        )

        val products = List(10) { product }

        composeTestRule.setContent {
            ProductList(products = products)
        }

        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onAllNodesWithText("테스트")
            .assertCountEquals(6)
    }

}