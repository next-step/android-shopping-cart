package nextstep.shoppingcart

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.ui.ShoppingCartScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        val product = Product(
            imageUrl = "https://image.msscdn.net/images/goods_img/20230425/3257548/3257548_16823548430020_500.jpg",
            name = "루바토 브이넥 반팔 티셔츠 네이비",
            price = 16371
        )
        Cart.removeAll(product)
        Cart.addOne(product)
        composeTestRule.setContent {
            ShoppingCartScreen(onNavigationClick = { /*TODO*/ })
        }
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        composeTestRule
            .onNodeWithText("주문하기(16,371원)")
            .assertIsEnabled()
    }


    @Test
    fun 담긴_상품을_제거할_수_있다() {
        composeTestRule
            .onNodeWithContentDescription("${Cart.items[0].product.name} 장바구니에서 삭제")
            .performClick()

        composeTestRule
            .onNodeWithText("루바토 브이넥 반팔 티셔츠 네이비")
            .assertIsNotDisplayed()
    }


    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        composeTestRule
            .onNodeWithText("+")
            .performClick()

        composeTestRule
            .onNodeWithText("주문하기(32,742원)")
            .assertIsDisplayed()
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        composeTestRule
            .onNodeWithText("-")
            .performClick()

        composeTestRule
            .onNodeWithText("주문하기(0원)")
            .assertIsDisplayed()
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        composeTestRule
            .onNodeWithText("-")
            .performClick()


        composeTestRule
            .onNodeWithText("루바토 브이넥 반팔 티셔츠 네이비")
            .assertIsNotDisplayed()

    }
}
