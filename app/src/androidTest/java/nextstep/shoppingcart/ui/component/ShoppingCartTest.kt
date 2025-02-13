package nextstep.shoppingcart.ui.component

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import nextstep.shoppingcart.model.ShoppingCartTopBarType
import org.junit.Rule
import org.junit.Test

class ShoppingCartTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 탑바에_타이틀과_장바구니_아이콘_노출() {
        // given
        val topBarType = ShoppingCartTopBarType.PRODUCT_LIST

        // then
        composeTestRule.setContent {
            ShoppingCartTopBar(
                type = topBarType,
                modifier = Modifier.testTag("topBar")
            )
        }

        composeTestRule
            .onNodeWithTag("topBar")
            .onChildren()
            .assertCountEquals(2)
    }
}