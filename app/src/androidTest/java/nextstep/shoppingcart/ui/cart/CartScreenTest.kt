package nextstep.shoppingcart.ui.cart

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.productsTestData
import org.junit.Rule
import org.junit.Test

internal class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 뒤로가기_버튼을_클릭할_수_있다() {
        // given
        var clicked = false
        composeTestRule.setContent {
            CartScreen(
                onBackClick = { clicked = true },
            )
        }

        // when
        composeTestRule
            .onNodeWithContentDescription("뒤로가기")
            .performClick()

        // then
        assert(clicked)
    }

    @Test
    fun 장바구니의_상품_갯수를_증가시키면_상품_수량이_증가한다() {
        // given
        composeTestRule.setContent {
            CartScreen(
                products = productsTestData,
                onBackClick = { },
            )
        }

        // when
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량증가")
            .onFirst()
            .apply {
                performClick()
                performClick()
            }

        // then
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량")
            .onFirst()
            .assertTextEquals("2")
    }

    @Test
    fun 장바구니의_상품_갯수를_감소시키면_상품_수량이_감소한다() {
        // given
        composeTestRule.setContent {
            CartScreen(
                products = productsTestData,
                onBackClick = { },
            )
        }

        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량증가")
            .onFirst()
            .apply {
                performClick()
                performClick()
            }

        // when
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량감소")
            .onFirst()
            .apply {
                performClick()
            }

        // then
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량")
            .onFirst()
            .assertTextEquals("1")
    }

    @Test
    fun 장바구니의_상품_갯수는_0보다_작을_수_없다() {
        // given
        composeTestRule.setContent {
            CartScreen(
                products = productsTestData,
                onBackClick = { },
            )
        }

        // when
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량감소")
            .onFirst()
            .apply {
                repeat(5) {
                    performClick()
                }
            }

        // then
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량")
            .onFirst()
            .assertTextEquals("0")
    }

    @Test
    fun 장바구니의_상품_갯수를_증가시키면_상품의_가격이_갯수만큼_증가한다() {
        // given
        val product = productsTestData[0].copy(price = 10000)
        composeTestRule.setContent {
            CartScreen(
                products = listOf(product),
                onBackClick = { },
            )
        }

        // when
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량증가")
            .onFirst()
            .apply {
                performClick()
                performClick()
            }

        // then
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템가격")
            .onFirst()
            .assertTextEquals("20,000원")
    }

    @Test
    fun 모든상품의_갯수만큼_전체_상품가격이_결정된다() {
        // given
        composeTestRule.setContent {
            CartScreen(
                products = listOf(
                    productsTestData[0].copy(price = 10000),
                    productsTestData[1].copy(price = 5000),
                ),
                onBackClick = { },
            )
        }

        // when
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량증가")[0]
            .performClick()

        composeTestRule
            .onAllNodesWithTag("장바구니::아이템수량증가")[1]
            .performClick()


        // then
        composeTestRule
            .onNodeWithText("주문하기(15,000원)")
            .assertIsDisplayed()
    }

    @Test
    fun 장바구니에서_상품을_제거하면_보이지_않는다() {
        // given
        composeTestRule.setContent {
            CartScreen(
                products = productsTestData,
                onBackClick = { },
            )
        }

        // when
        composeTestRule
            .onAllNodesWithContentDescription("장바구니::아이템제거")
            .onFirst()
            .performClick()

        // then
        composeTestRule
            .onAllNodesWithTag("장바구니::아이템")
            .assertCountEquals(productsTestData.size - 1)
    }
}
