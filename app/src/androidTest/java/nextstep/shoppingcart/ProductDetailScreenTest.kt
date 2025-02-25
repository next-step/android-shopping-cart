package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.ProductAppMoveActionTest.Companion.ADD_TO_CART_BUTTON
import nextstep.shoppingcart.data.FakeData
import nextstep.shoppingcart.ui.screen.ProductApp
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    @Before
    fun setUp() {
        composeTestRule.setContent {
            ProductApp()
        }

        val productItem = FakeData.products[0]
        composeTestRule.onNodeWithText(productItem.title).performClick()
    }

    @Test
    fun 상품_상세화면에서_장바구니_담기_버튼_클릭시_장바구니_화면에_해당_상품이_추가되어_있다() {
        val productItem = FakeData.products[0]

        // 장바구니 담기 버튼 클릭
        composeTestRule.onNodeWithText(ADD_TO_CART_BUTTON).performClick()

        // 장바구니 화면에 해당 상품이 추가되어 있는지 확인
        composeTestRule.onNodeWithText(productItem.title).assertExists()
    }
}