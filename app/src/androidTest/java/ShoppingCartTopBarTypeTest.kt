import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import nextstep.shoppingcart.ui.component.ShoppingCartTopBar
import org.junit.Rule
import org.junit.Test

class ShoppingCartTopBarTypeTest {
    @get:Rule
    val composableTest = createComposeRule()

    @Test
    fun 탑바에_타이틀과_장바구니_아이콘_노출() {
        // given
        val title = "제목"

        // then
        composableTest.setContent {
            ShoppingCartTopBar(
                type = nextstep.shoppingcart.model.ShoppingCartTopBarType.PRODUCT_LIST,
                modifier = Modifier.testTag("topBar")
            )
        }

        composableTest
            .onNodeWithTag("topBar")
            .onChildren()
            .assertCountEquals(2)
    }
}