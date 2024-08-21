package nextstep.shoppingcart

import android.content.Context
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.data.cart.Cart
import nextstep.shoppingcart.data.cart.CartItem
import nextstep.shoppingcart.ui.product.list.component.InteractiveProductImage
import org.junit.Rule
import org.junit.Test

class InteractiveProductImageTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    val context: Context = ApplicationProvider.getApplicationContext()

    @Test
    fun 상품의_더하기_fab버튼_클릭시_카트에_저장된다() {
        // given : 상품을 등록한다.
        val product = Product(
            id = 1,
            imgUrl = "https://picsum.photos/seed/1/200",
            name = "상품 1-이름이 너무 길다면 어떻게 할 것인가요?",
            price = 3000
        )

        composeTestRule.setContent {
            InteractiveProductImage(product, Modifier)
        }

        // when : 상품 카드의 더하기 fab버튼을 클릭한다.
        composeTestRule
            .onNodeWithTag(context.getString(R.string.test_tag_add_fab))
            .performClick()

        val actual = CartItem(product, 1)

        // then :
        assert(Cart.items.contains(actual))
    }
}