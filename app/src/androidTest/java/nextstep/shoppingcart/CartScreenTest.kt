package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.cart.CartScreen
import nextstep.shoppingcart.cart.model.CartViewModel
import nextstep.shoppingcart.model.Product
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val viewModel = CartViewModel(repository = nextstep.shoppingcart.data.Cart)

    @Before
    fun setup() {
        composeTestRule.setContent {
            CartScreen(
                onBackButtonClick = {},
            )
        }
    }

    @Test
    fun 장바구니에_10000원_상품_1개_추가시_상품명과_1과_포맷된_10000원이_노출된다() {
        //given
        viewModel.removeAll(test1)

        // when
        viewModel.addOne(test1)

        // then
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
        //given
        viewModel.removeAll(test1)
        viewModel.addOne(test1)

        // when
        composeTestRule.onNodeWithTag("addOneToCart ${test1.name}").performClick()

        // then
        composeTestRule
            .onNodeWithText("2")
            .assertExists()
        composeTestRule
            .onNodeWithText("20,000원")
            .assertExists()
    }

    @Test
    fun 장바구니에_10000원_상품_1개_존재하고_1개_삭제시_상품이_노출되지_않는다() {
        //given
        viewModel.removeAll(test1)
        viewModel.addOne(test1)

        // when
        composeTestRule.onNodeWithTag("onRemoveOneFromCart ${test1.name}").performClick()

        // then
        composeTestRule
            .onNodeWithText("1")
            .assertDoesNotExist()
        composeTestRule
            .onNodeWithText("10,000원")
            .assertDoesNotExist()
    }

    @Test
    fun 장바구니_상품_전체_삭제시_상품이_노출되지_않는다() {
        //given
        viewModel.removeAll(test1)
        viewModel.addOne(test1)
        composeTestRule.onNodeWithTag("addOneToCart ${test1.name}").performClick()
        composeTestRule.onNodeWithTag("addOneToCart ${test1.name}").performClick()
        composeTestRule.onNodeWithTag("addOneToCart ${test1.name}").performClick()

        // when
        composeTestRule.onNodeWithContentDescription("${test1.name} 삭제버튼").performClick()

        // then
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
