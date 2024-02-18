package nextstep.shoppingcart.ui.product

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.productsTestData
import nextstep.shoppingcart.ui.product.detail.ProductDetailScreen
import org.junit.Rule
import org.junit.Test

class ProductDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 상품의_이름은_그대로_출력한다() {
        // given & when
        composeTestRule.setContent {
            ProductDetailScreen(
                product = productsTestData[0],
                onBackClick = { },
                onProductAddClick = { },
            )
        }

        // then
        composeTestRule
            .onNodeWithText(productsTestData[0].name)
            .assertIsDisplayed()
    }

    @Test
    fun 상품의_가격은_원화_단위로_출력한다() {
        // given & when
        composeTestRule.setContent {
            ProductDetailScreen(
                product = productsTestData[0].copy(price = 44100),
                onBackClick = { },
                onProductAddClick = { },
            )
        }

        // then
        composeTestRule
            .onNodeWithText("44,100원")
            .assertIsDisplayed()
    }

    @Test
    fun 장바구니_담기_버튼을_클릭할_수_있다() {
        var clicked = false

        // given
        composeTestRule.setContent {
            ProductDetailScreen(
                product = productsTestData[0],
                onBackClick = { },
                onProductAddClick = { clicked = true },
            )
        }

        // when
        composeTestRule
            .onNodeWithText("장바구니 담기")
            .performClick()

        // then
        assert(clicked)
    }
}
