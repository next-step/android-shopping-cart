package nextstep.shoppingcart.shoppinglist.shoppinglist.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import nextstep.shoppingcart.ui.shoppinglist.component.ShoppingProductHeader
import nextstep.shoppingcart.ui.shoppinglist.model.Product
import org.junit.Rule
import org.junit.Test

class ShoppingProductHeaderTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `0번_상품이_장바구니에_1개_이상_담겨있다면_갯수가_노출된다`() {
        // given:
        composeTestRule.apply {
            setContent {
                ShoppingProductHeader(
                    product = Product(
                        id = 0L,
                        name = "요구르트",
                        imageUrl = "",
                        price = 500000000L,
                        containedCount = 2,
                    ),
                    onPutClick = {},
                    onAddClick = {},
                    onSubtractClick = {},
                )
            }
        }

        // when:
        // then:
        composeTestRule.onNodeWithContentDescription("ShoppingProductAddButton")
            .assertIsNotDisplayed()
        composeTestRule.onNodeWithContentDescription("ShoppingCountBarTotalCount")
            .assertTextEquals("2")
    }

    @Test
    fun `0번_상품이_장바구니에_0개_담겨있다면_갯수_추가_버튼이_노출된다`() {
        // given:
        composeTestRule.apply {
            setContent {
                ShoppingProductHeader(
                    product = Product(
                        id = 0L,
                        name = "요구르트",
                        imageUrl = "",
                        price = 500000000L,
                        containedCount = 0,
                    ),
                    onPutClick = {},
                    onAddClick = {},
                    onSubtractClick = {},
                )
            }
        }

        // when:
        // then:
        composeTestRule.onNodeWithContentDescription("ShoppingProductAddButton")
            .assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("shoppingCountBarDescription")
            .assertIsNotDisplayed()
    }
}
