package nextstep.shoppingcart.component

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.hasAnyAncestor
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.model.CartItem
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.component.ProductCartList
import org.junit.Rule
import org.junit.Test

class ProductCartListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val cartItems = List(3) { (CartItem(Product(it, "", "상품$it", 1000), 1)) }

    @Test
    fun `항목의_갯수만큼_표시된다`() {
        composeTestRule.setContent {
            ProductCartList(
                modifier = Modifier.testTag("ProductCartList"),
                cartItems = cartItems,
                onRemoveClick = {},
                onIncreaseClick = {},
                onDecreaseClick = {},
            )
        }

        composeTestRule
            .onNodeWithTag("ProductCartList")
            .onChildren()
            .assertCountEquals(cartItems.size)
    }

    @Test
    fun `지우기_버튼을_누르면_해당하는_상품정보를_가져온다`() {
        var removeProduct: Product? = null

        composeTestRule.setContent {
            ProductCartList(
                cartItems = cartItems,
                onRemoveClick = { removeProduct = it },
                onIncreaseClick = { },
                onDecreaseClick = { },
            )
        }

        composeTestRule
            .onNode(hasTestTag("remove_button") and hasAnyAncestor(hasTestTag("상품0")))
            .performClick()

        assert(removeProduct == cartItems[0].product)
    }

    @Test
    fun `증가_버튼을_누르면_해당하는_상품정보를_가져온다`() {
        var increaseProduct: Product? = null

        composeTestRule.setContent {
            ProductCartList(
                cartItems = cartItems,
                onRemoveClick = { },
                onIncreaseClick = { increaseProduct = it },
                onDecreaseClick = { },
            )
        }

        composeTestRule
            .onNode(hasTestTag("increase_button") and hasAnyAncestor(hasTestTag("상품1")))
            .performClick()

        assert(increaseProduct == cartItems[1].product)

    }

    @Test
    fun `감소_버튼을_누르면_해당하는_상품정보를_가져온다`() {
        var decreaseProduct: Product? = null

        composeTestRule.setContent {
            ProductCartList(
                cartItems = cartItems,
                onRemoveClick = { },
                onIncreaseClick = { },
                onDecreaseClick = { decreaseProduct = it },
            )
        }

        composeTestRule
            .onNode(hasTestTag("decrease_button") and hasAnyAncestor(hasTestTag("상품2")))
            .performClick()

        assert(decreaseProduct == cartItems[2].product)

    }
}
