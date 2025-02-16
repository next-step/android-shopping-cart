package nextstep.shoppingcart.component

import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.ui.component.ProductListTopAppBar
import org.junit.Rule
import org.junit.Test

class ProductListTopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `탑바는_클릭가능한_버튼을_포함한다`() {
        var count = 0

        composeTestRule.setContent {
            ProductListTopAppBar(
                onClickButton = { count++ }
            )
        }

        composeTestRule
            .onNode(hasClickAction())
            .performClick()

        assert(count == 1)
    }
}
