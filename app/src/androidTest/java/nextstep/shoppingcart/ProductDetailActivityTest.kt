package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsRule
import org.junit.Rule
import org.junit.Test

class ProductDetailActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ProductDetailActivity>()

    @get:Rule
    val intentTestRule = IntentsRule()

    @Test
    fun 장바구니담기_클릭시_카트_화면_호출() {
        // when
        composeTestRule.onNodeWithText("장바구니 담기").performClick()

        // then
        intended(hasComponent(ProductCartActivity::class.java.name))
    }

}
