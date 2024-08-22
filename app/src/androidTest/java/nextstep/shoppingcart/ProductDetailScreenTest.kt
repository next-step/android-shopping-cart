package nextstep.shoppingcart

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.product.detail.ProductDetailScreen
import org.junit.Rule
import org.junit.Test

class ProductDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // 상품 금액 노출
    @Test
    fun 전달받은_상품_데이터의_가격_정보가_숫자_포멧팅되어_노출한다() {
        // given : 상품 정보를 선언한다.
        val product = Product(
            id = 1,
            imgUrl = "imgUrl",
            name = "아메리카노",
            price = 12984
        )

        // when : 상품 상세 스크린은 노출한다.
        composeTestRule.setContent {
            ProductDetailScreen(Modifier, product)
        }

        // then : 상품의 가격정보가 숫자 포멧팅되어 노출되어야한다.
        composeTestRule.onNodeWithText("12,984원").assertExists()
    }

    @Test
    fun 전달받은_상품_데이터의_가격_정보가_숫자_포멧팅되어_노출한다_에러() {
        // given : 상품 정보를 선언한다.
        val product = Product(
            id = 1,
            imgUrl = "imgUrl",
            name = "아메리카노",
            price = 12984
        )

        // when : 상품 상세 스크린은 노출한다.
        composeTestRule.setContent {
            ProductDetailScreen(Modifier, product)
        }

        // then : 상품의 가격정보가 숫자 포멧팅되어 노출되어야한다.
        composeTestRule.onNodeWithText("12984원").assertDoesNotExist()
    }

    // 상품 명 노출
    @Test
    fun 전달받은_상품_데이터의_상품명이_노출한다() {
        // given : 상품 정보를 선언한다.
        val product = Product(
            id = 1,
            imgUrl = "imgUrl",
            name = "라때",
            price = 12984
        )

        // when : 상품 상세 스크린은 노출한다.
        composeTestRule.setContent {
            ProductDetailScreen(Modifier, product)
        }

        // then :
        composeTestRule.onNodeWithText("라때").assertExists()
    }
}