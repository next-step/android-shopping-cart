package nextstep.shoppingcart

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.filter
import androidx.compose.ui.test.hasAnySibling
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.ProductAppMoveActionTest.Companion.SHOPPING_CART_ICON_DESCRIPTION
import nextstep.shoppingcart.ProductListScreenTest.Companion.PLUS_FLOATING_BUTTON_DESCRIPTION
import nextstep.shoppingcart.data.FakeData
import nextstep.shoppingcart.repository.CartRepository
import nextstep.shoppingcart.ui.screen.ProductApp
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductShoppingCartTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        CartRepository.clear()

        composeTestRule.setContent {
            ProductApp()
        }

        // 상품1, 상품2 담기
        // 플로팅 버튼 클릭
        composeTestRule.onAllNodesWithContentDescription(PLUS_FLOATING_BUTTON_DESCRIPTION)
            .filter(hasParent(hasText(PRODUCT_ONE)))
            .onFirst()
            .performClick()

        // 플로팅 버튼 클릭
        composeTestRule.onAllNodesWithContentDescription(PLUS_FLOATING_BUTTON_DESCRIPTION)
            .filter(hasParent(hasText(PRODUCT_TWO)))
            .onFirst()
            .performClick()

        // 앱바의 쇼핑카트 아이콘 클릭
        composeTestRule.onNodeWithContentDescription(SHOPPING_CART_ICON_DESCRIPTION).performClick()
    }

    @Test
    fun 담긴_상품이_화면에_노출된다() {
        // 상품1, 상품2가 화면에 존재하는지 확인
        composeTestRule.onNodeWithText(PRODUCT_ONE)
            .assertExists()

        composeTestRule.onNodeWithText(PRODUCT_TWO)
            .assertExists()
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // 총합 가격이 화면에 존재하는지 확인
        composeTestRule.onNodeWithText("$ORDER_BUTTON_TITLE(30,000원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // 상품1 제거 버튼 클릭
        composeTestRule.onAllNodesWithContentDescription(REMOVE_BUTTON_DESCRIPTION)
            .filter(hasAnySibling(hasText(PRODUCT_ONE)))
            .onFirst()
            .performClick()

        // 상품1이 화면에 존재하지 않는지 확인
        composeTestRule.onNodeWithText(PRODUCT_ONE)
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // 상품1 수량 증가 버튼 클릭
        composeTestRule.onAllNodesWithText(ADD_BUTTON_TITLE)
            .filter(hasAnySibling(hasText(PRODUCT_ONE)))
            .onFirst()
            .performClick()

        // 상품1의 총 가격이 화면에 존재하는지 확인
        composeTestRule.onNodeWithText(PRODUCT_ONE)
            .assert(hasAnySibling(hasText("20,000원")))

        // 총합 가격이 정확한지 확인
        composeTestRule.onNodeWithText("$ORDER_BUTTON_TITLE(40,000원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // 상품1 수량 추가
        composeTestRule.onAllNodesWithText(ADD_BUTTON_TITLE)
            .filter(hasAnySibling(hasText(PRODUCT_ONE)))
            .onFirst()
            .performClick()

        // 상품1 수량 감소 버튼 클릭
        composeTestRule.onAllNodesWithText(MINUS_BUTTON_TITLE)
            .filter(hasAnySibling(hasText(PRODUCT_ONE)))
            .onFirst()
            .performClick()

        // 상품1의 총 가격이 화면에 존재하는지 확인
        composeTestRule.onNodeWithText(PRODUCT_ONE)
            .assert(hasAnySibling(hasText("10,000원")))

        // 총합 가격이 정확한지 확인
        composeTestRule.onNodeWithText("$ORDER_BUTTON_TITLE(30,000원)")
            .assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        // 상품1 수량 감소 버튼 클릭
        composeTestRule.onAllNodesWithText(MINUS_BUTTON_TITLE)
            .filter(hasAnySibling(hasText(PRODUCT_ONE)))
            .onFirst()
            .performClick()

        // 상품1이 화면에 존재하지 않는지 확인
        composeTestRule.onNodeWithText(PRODUCT_ONE)
            .assertDoesNotExist()
    }

    companion object {
        private const val ORDER_BUTTON_TITLE = "주문하기"
        private const val REMOVE_BUTTON_DESCRIPTION = "Remove Button"
        private const val ADD_BUTTON_TITLE = "+"
        private const val MINUS_BUTTON_TITLE = "-"

        private val PRODUCT_ONE = FakeData.products[0].title
        private val PRODUCT_TWO = FakeData.products[1].title
    }
}
