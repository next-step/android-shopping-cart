package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.cart.CartScreen
import nextstep.shoppingcart.cart.CartViewModel
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.Product
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val viewModel = CartViewModel(repository = Cart)

    @Before
    fun setup() {
        // 장바구니 데이터 초기화
        Cart.clearCartItem()
    }

    @Test
    fun 장바구니에_10000원_상품_1개_추가시_상품명과_1과_포맷된_10000원이_노출된다() {
        // given: 장바구니에 상품이 없는 상태
        composeTestRule.setContent {
            CartScreen(viewModel = viewModel)
        }

        // when: 10000원 상품 1개를 장바구니에 추가
        viewModel.addOne(test1)

        // then: 상품명, 수량(1), 포맷된 가격(10,000원)이 노출됨
        composeTestRule
            .onNodeWithText("1")
            .assertExists()
        composeTestRule
            .onNodeWithText("10,000원")
            .assertExists()
        composeTestRule
            .onNodeWithText("10000원 상품")
            .assertExists()
    }

    @Test
    fun 장바구니에_10000원_상품_2개_추가시_2와_포맷된_20000원이_노출된다() {
        // given: 장바구니에 10000원 상품 1개가 있는 상태
        composeTestRule.setContent {
            CartScreen(viewModel = viewModel)
        }
        viewModel.addOne(test1)

        // when: 10000원 상품을 1개 더 추가 (총 2개)
        composeTestRule.onNodeWithTag("addOneToCart ${test1.name}").performClick()

        // then: 수량(2), 포맷된 가격(20,000원)이 노출됨
        composeTestRule
            .onNodeWithText("2")
            .assertExists()
        composeTestRule
            .onNodeWithText("20,000원")
            .assertExists()
    }

    @Test
    fun 장바구니에_10000원_상품_1개_존재하고_1개_삭제버튼_클릭시_상품이_노출되지_않는다() {
        // given: 장바구니에 10000원 상품 1개가 있는 상태
        composeTestRule.setContent {
            CartScreen(viewModel = viewModel)
        }
        viewModel.addOne(test1)

        // when: 10000원 상품의 삭제 버튼 클릭
        composeTestRule.onNodeWithTag("onRemoveOneFromCart ${test1.name}").performClick()

        // then: 상품이 노출되지 않음 (수량, 가격 모두 없음)
        composeTestRule
            .onNodeWithText("1")
            .assertDoesNotExist()
        composeTestRule
            .onNodeWithText("10,000원")
            .assertDoesNotExist()
    }

    @Test
    fun 장바구니_상품_전체삭제_버튼_클릭시_상품이_노출되지_않는다() {
        // given: 장바구니에 10000원 상품 4개가 있는 상태
        composeTestRule.setContent {
            CartScreen(viewModel = viewModel)
        }
        viewModel.addOne(test1)
        composeTestRule.onNodeWithTag("addOneToCart ${test1.name}").performClick()
        composeTestRule.onNodeWithTag("addOneToCart ${test1.name}").performClick()
        composeTestRule.onNodeWithTag("addOneToCart ${test1.name}").performClick()

        // when: 전체 삭제 버튼 클릭
        composeTestRule.onNodeWithContentDescription("${test1.name} 삭제버튼").performClick()

        // then: 상품이 노출되지 않음 (수량, 가격 모두 없음)
        composeTestRule
            .onNodeWithText("1")
            .assertDoesNotExist()
        composeTestRule
            .onNodeWithText("10,000원")
            .assertDoesNotExist()
    }

    companion object {
        private val test1 = Product(
            name = "10000원 상품",
            imageUrl = "",
            price = 10000,
            productId = "10000"
        )
    }
}
