package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsRule
import nextstep.shoppingcart.model.dummyProducts
import nextstep.shoppingcart.navigator.PARAM_ID
import nextstep.shoppingcart.navigator.PARAM_IMAGE_URL
import nextstep.shoppingcart.navigator.PARAM_NAME
import nextstep.shoppingcart.navigator.PARAM_PRICE
import org.junit.Rule
import org.junit.Test

class ProductListActivityTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ProductListActivity>()

    @get:Rule
    val intentTestRule = IntentsRule()

    @Test
    fun 상품_아이템_클릭시_상품_상세_화면_호출() {
        // given
        val testModel = dummyProducts.first()

        // when
        composeTestRule.onNodeWithText(testModel.name).performClick()


        // then
        intended(hasComponent(ProductDetailActivity::class.java.name))
    }


    @Test
    fun 상품_아이템_클릭시_상품_데이터_전송() {
        // given
        val testModel = dummyProducts.first()

        // when
        composeTestRule.onNodeWithText(testModel.name).performClick()

        // then
        intended(IntentMatchers.hasExtra(PARAM_ID, testModel.id))
        intended(IntentMatchers.hasExtra(PARAM_NAME, testModel.name))
        intended(IntentMatchers.hasExtra(PARAM_PRICE, testModel.price))
        intended(IntentMatchers.hasExtra(PARAM_IMAGE_URL, testModel.imageUrl))
    }

    @Test
    fun 카트_클릭시_카트_화면_호출() {
        // when
        composeTestRule.onNodeWithContentDescription("장바구니").performClick()

        // then
        intended(hasComponent(ProductCartActivity::class.java.name))
    }
}
