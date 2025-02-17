package nextstep.shoppingcart.ui.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.Cart
import nextstep.shoppingcart.model.dummyProducts
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CountControlButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val product = dummyProducts.first()
    private val initCount = 3
    private var items by mutableStateOf(Cart.items)

    @Before
    fun setup() {
        Cart.init()

        repeat(initCount) {
            Cart.addOne(product)
        }
        items = Cart.items

        composeTestRule.setContent {
            CountControlButton(
                model = items.first(),
                listUpdate = {
                    items = Cart.items
                }
            )
        }
    }

    @Test
    fun 담기_숫자_제거_버튼_노출() {
        // then
        composeTestRule
            .onNodeWithContentDescription("담기")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("$initCount")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription("제거")
            .assertIsDisplayed()
    }

    @Test
    fun 담기_버튼_클릭시_카운트_증가() {
        // when
        composeTestRule
            .onNodeWithContentDescription("담기")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("${initCount.inc()}")
            .assertIsDisplayed()
    }

    @Test
    fun 제거_버튼_클릭시_카운트_감소() {
        // when
        composeTestRule
            .onNodeWithContentDescription("제거")
            .performClick()

        // then
        composeTestRule
            .onNodeWithText("${initCount.dec()}")
            .assertIsDisplayed()
    }
}