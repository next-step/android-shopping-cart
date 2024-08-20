package nextstep.shoppingcart.ui.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.ui.cart.component.CART_ITEM_COUNTER_DECREASE_TEST_TAG
import nextstep.shoppingcart.ui.cart.component.CART_ITEM_COUNTER_INCREASE_TEST_TAG
import nextstep.shoppingcart.ui.cart.component.CartItemCounter
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartItemCounterTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    var count by mutableStateOf(1)

    @Before
    fun setup() {
        composeTestRule.setContent {
            CartItemCounter(
                count = count,
                onClickIncrease = { count += 1 },
                onClickDecrease = { count -= 1 },
            )
        }
    }

    @Test
    fun 더하기_버튼을_누르면_카운트_수가_1_증가한다() {
        // given
        count = 1

        // when
        composeTestRule
            .onNodeWithTag(CART_ITEM_COUNTER_INCREASE_TEST_TAG)
            .performClick()

        // then
        Assert.assertEquals(count, 2)
        composeTestRule
            .onNodeWithText("2")
            .assertExists()
    }

    @Test
    fun 빼기_버튼을_누르면_카운트_수가_1_감소한다() {
        // given
        count = 2

        // when
        composeTestRule
            .onNodeWithTag(CART_ITEM_COUNTER_DECREASE_TEST_TAG)
            .performClick()

        // then
        Assert.assertEquals(count, 1)
        composeTestRule
            .onNodeWithText("1")
            .assertExists()
    }

}
