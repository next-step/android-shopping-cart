package nextstep.shoppingcart.ui.screen.cart

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.model.Product
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartScreenTest {
    @get:Rule
    val composeTestRule: ComposeContentTestRule = createComposeRule()

    @Before
    fun setup() {
        CartBox.clear()
    }

    @Test
    fun 상품이_없으면_주문하기_금액은_0원입니다() {
        // given
        composeTestRule.setContent {
            CartScreen()
        }

        // when

        // then
        composeTestRule
            .onNodeWithContentDescription("BottomText")
            .assertTextEquals("주문하기(0원)")
    }

    @Test
    fun 상품이_있으면_주문하기_금액이_상품가격입니다() {
        // given
        CartBox.add(product = Product.fixture.first())
        CartBox.add(product = Product.fixture.last())
        composeTestRule.setContent {
            CartScreen()
        }

        // when

        // then
        composeTestRule
            .onNodeWithContentDescription("BottomText")
            .assertTextEquals("주문하기(22,000원)")
    }

    @Test
    fun 상품_개수를_감소시키면_상품_수량과_금액이_감소합니다() {
        // given
        CartBox.add(product = Product.fixture.first())
        CartBox.add(product = Product.fixture.first())
        CartBox.add(product = Product.fixture.first())
        composeTestRule.setContent {
            CartScreen()
        }

        // when
        composeTestRule
            .onNodeWithContentDescription("감소")
            .performClick()

        // then
        composeTestRule
            .onNodeWithContentDescription("Count")
            .assertTextEquals("2")

        composeTestRule
            .onNodeWithContentDescription("BottomText")
            .assertTextEquals("주문하기(20,000원)")
    }

    @Test
    fun 상품_개수를_증가시키면_상품_수량과_금액이_증가합니다() {
        // given
        CartBox.add(product = Product.fixture.first())
        CartBox.add(product = Product.fixture.first())
        CartBox.add(product = Product.fixture.first())
        composeTestRule.setContent {
            CartScreen()
        }

        // when
        composeTestRule
            .onNodeWithContentDescription("증가")
            .performClick()

        // then
        composeTestRule
            .onNodeWithContentDescription("Count")
            .assertTextEquals("4")

        composeTestRule
            .onNodeWithContentDescription("BottomText")
            .assertTextEquals("주문하기(40,000원)")
    }

    @Test
    fun 상품을_제거하면_해당_상품이_제거됩니다() {
        // given
        CartBox.add(product = Product.fixture.first())
        composeTestRule.setContent {
            CartScreen()
        }

        // when
        composeTestRule
            .onNodeWithContentDescription("삭제")
            .performClick()

        // then
        composeTestRule
            .onNodeWithContentDescription("CartItem")
            .assertDoesNotExist()
    }
}
