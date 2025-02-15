package nextstep.shoppingcart.component

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.junit4.createComposeRule
import nextstep.shoppingcart.ui.component.BackNavigationAppBar
import org.junit.Rule
import org.junit.Test

class BackNavigationAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `클릭가능한_버튼을_하나만_포함한다`() {
        composeTestRule.setContent {
            BackNavigationAppBar(
                title = "",
                onBackButtonClick = { }
            )
        }

        composeTestRule
            .onAllNodes(hasClickAction())
            .assertCountEquals(1)
    }
}
