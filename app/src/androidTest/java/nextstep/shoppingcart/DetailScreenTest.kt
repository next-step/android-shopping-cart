package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.detail.component.DetailProductPrice
import nextstep.shoppingcart.detail.widget.DetailTopBar
import org.junit.Rule
import org.junit.Test

class DetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `상품_가격이_형식에_맞게_출력되는지_테스트`() {
        // given
        val price = 40000

        // when
        composeTestRule.setContent {
            DetailProductPrice(price)
        }

        // then
        composeTestRule
            .onNodeWithText("40,000원")
            .assertExists()
    }

    @Test
    fun `앱바_뒤로가기_버튼이_정상적인_클릭이_되는지_테스트`() {
        // given
        var isClicked = false
        composeTestRule.setContent {
            DetailTopBar(popBackstack = {
                isClicked = true
            })
        }

        // when
        composeTestRule
            .onNodeWithTag("topBarBackButton")
            .performClick()

        //then
        assert(isClicked)
    }
}
