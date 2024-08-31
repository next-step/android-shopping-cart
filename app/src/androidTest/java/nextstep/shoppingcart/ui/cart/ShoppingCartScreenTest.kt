package nextstep.shoppingcart.ui.cart

import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.Cart
import nextstep.shoppingcart.model.Product
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val testProduct = Product(
        name = "테스트 상품",
        imageUrl = "https://img.danawa.com/prod_img/500000/334/189/img/28189334_1.jpg",
        price = 1000,
    )

    @Before
    fun setup() {
        Cart.clear()
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // given : 상품이 하나도 없음
        val product = testProduct

        // when : 1000원 상품이 2개 추가됨
        Cart.addOne(product)
        Cart.addOne(product)
        composeTestRule.setContent {
            ShoppingCartScreen(onClickBack = {})
        }

        // then : 주문 버튼에 총합인 2000이 표시됨
        composeTestRule
            .onNodeWithTag("orderButton")
            .assertTextContains("주문하기(2,000원)")
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // given : "테스트 상품" 이름의 상품 하나가 있음
        Cart.addOne(testProduct)
        composeTestRule.setContent {
            ShoppingCartScreen(onClickBack = {})
        }

        // when : 삭제 버튼 클릭
        composeTestRule
            .onNodeWithTag("deleteButton")
            .performClick()

        // then : "테스트 상품" 이름의 상품이 없어짐
        composeTestRule
            .onNodeWithTag("테스트 상품")
            .assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // given : "테스트 상품" 이름의 상품 하나가 있음
        Cart.addOne(testProduct)
        composeTestRule.setContent {
            ShoppingCartScreen(onClickBack = {})
        }

        // when : "테스트 상품" 수량 추가 버튼 클릭
        composeTestRule
            .onNodeWithText("+")
            .performClick()

        // then : "테스트 상품"의 2개의 값인 2000원이 주문 버튼에 노출
        composeTestRule
            .onNodeWithTag("orderButton")
            .assertTextContains("주문하기(2,000원)")
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // given : "테스트 상품" 이름의 상품 하나가 있음
        Cart.addOne(testProduct)
        composeTestRule.setContent {
            ShoppingCartScreen(onClickBack = {})
        }

        // when : "테스트 상품" 수량 제거 버튼 클릭
        composeTestRule
            .onNodeWithText("−")
            .performClick()

        // then : "테스트 상품" 이 0개로 총 상품 가격 0원이 주문 버튼에 노출
        composeTestRule
            .onNodeWithTag("orderButton")
            .assertTextContains("주문하기(0원)")
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        // given : "테스트 상품" 이름의 상품 하나가 있음
        Cart.addOne(testProduct)
        composeTestRule.setContent {
            ShoppingCartScreen(onClickBack = {})
        }

        // when : "테스트 상품" 수량 제거 버튼 클릭
        composeTestRule
            .onNodeWithText("−")
            .performClick()

        // given : "테스트 상품" 이름의 상품이 존재하지 않음
        composeTestRule
            .onNodeWithTag("테스트 상품")
            .assertDoesNotExist()
    }
}
