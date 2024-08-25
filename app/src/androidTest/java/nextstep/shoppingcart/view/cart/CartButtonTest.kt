package nextstep.shoppingcart.view.cart

import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.view.resource.Blue50
import nextstep.shoppingcart.view.resource.ShoppingCartTheme
import org.junit.Rule
import org.junit.Test

class CartButtonTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 주문하기_버튼이_표시된다() {
        val buttonText = "주문하기(1,000원)"
        composeTestRule.setContent {
            ShoppingCartTheme {
                CartButton(
                    onButtonClick = {},
                    text = buttonText,
                    fontSize = 20.sp,
                    color = ButtonDefaults.buttonColors(Blue50)
                )
            }
        }

        composeTestRule.onNodeWithText(buttonText).assertExists()
    }

    @Test
    fun 주문하기_버튼이_클릭된다() {
        var isButtonClicked = false
        composeTestRule.setContent {
            ShoppingCartTheme {
                CartButton(
                    onButtonClick = { isButtonClicked = true },
                    text = "주문하기(1,000원)",
                    fontSize = 20.sp,
                    color = ButtonDefaults.buttonColors(Blue50)
                )
            }
        }

        composeTestRule.onNodeWithText("주문하기(1,000원)").performClick()
        assert(isButtonClicked)
    }
}
