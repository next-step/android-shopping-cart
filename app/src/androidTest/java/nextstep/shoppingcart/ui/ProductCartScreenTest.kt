package nextstep.shoppingcart.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToNode
import nextstep.shoppingcart.model.dummyCartProductList
import org.junit.Rule
import org.junit.Test

class ProductCartScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 장바구니_목록에_모든_아이템_노출() {
        // given
        composeTestRule.setContent {
            ProductCartScreen(
                model = dummyCartProductList,
                onBackButtonClick = {},
            )
        }

        // then
        dummyCartProductList.forEach { item ->
            composeTestRule
                .onNodeWithTag("productCartLazyColumn")
                .performScrollToNode(hasText(item.name))
                .assertIsDisplayed()
        }
    }
}