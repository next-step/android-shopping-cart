package nextstep.shoppingcart.productList

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import nextstep.shoppingcart.data.Product
import org.junit.Rule
import org.junit.Test

class ProductListTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 상품_리스트가_4개면_4개의_아이템이_노출된다() {
        // given
        val product = Product(
            id = 1,
            name = "테스트",
            price = 10000,
            imageUrl = ""
        )

        val products = List(4) { product }

        composeTestRule.setContent {
            ProductList(
                products = products,
                onItemClick = {},
                onPlusClick = {},
                onMinusClick = {},
            )
        }

        // then
        composeTestRule
            .onAllNodesWithText("테스트")
            .assertCountEquals(4)
    }

}