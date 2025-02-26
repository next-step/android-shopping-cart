package nextstep.shoppingcart.productDetail

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.data.Product
import org.junit.Rule
import org.junit.Test

class ProductDetailScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 상품의_이름이_테스트가_노출되어야_한다() {
        // given
        val product = Product(
            name = "테스트",
            price = 10000,
            imageUrl = ""
        )

        composeTestRule.setContent {
            ProductDetailScreen(product = product)
        }

        // then
        composeTestRule
            .onNodeWithText("테스트")
            .assertExists()
    }

    @Test
    fun 상품의_금액이_10_000원이_노출되어야_한다() {
        // given
        val product = Product(
            name = "테스트",
            price = 10000,
            imageUrl = ""
        )

        composeTestRule.setContent {
            ProductDetailScreen(product = product)
        }

        // then
        composeTestRule
            .onNodeWithText("10,000원")
            .assertExists()
    }

    @Test
    fun 버튼의_이름이_장바구니_담기_로_노출되어야_한다() {
        // given
        val product = Product(
            name = "테스트",
            price = 10000,
            imageUrl = ""
        )

        composeTestRule.setContent {
            ProductDetailScreen(product = product)
        }

        // then
        composeTestRule
            .onNodeWithText("장바구니 담기")
            .assertExists()
    }
}