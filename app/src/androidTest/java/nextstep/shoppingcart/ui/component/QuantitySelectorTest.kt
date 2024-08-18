package nextstep.shoppingcart.ui.component

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import nextstep.shoppingcart.R
import org.junit.Rule
import org.junit.Test

class QuantitySelectorTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun 추가버튼을_누르면_수량이_증가한다() {
        // given
        composeTestRule.setContent {
            var quantity by remember { mutableStateOf(1) }
            QuantitySelector(
                quantity = quantity,
                onAddClick = { quantity++ },
                onRemoveClick = {},
            )
        }

        // when
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_quantity_selector_add))
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_quantity_selector_quantity))
            .assertTextContains("2")
    }

    @Test
    fun 감소버튼을_누르면_수량이_감소한다() {
        // given
        composeTestRule.setContent {
            var quantity by remember { mutableStateOf(2) }
            QuantitySelector(
                quantity = quantity,
                onAddClick = {},
                onRemoveClick = { quantity-- },
            )
        }

        // when
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_quantity_selector_remove))
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_quantity_selector_quantity))
            .assertTextContains("1")
    }
}
