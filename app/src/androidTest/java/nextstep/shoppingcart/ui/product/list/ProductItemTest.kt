package nextstep.shoppingcart.ui.product.list

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.domain.model.Product
import nextstep.shoppingcart.ui.product.list.component.ProductItem
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProductItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val product = mutableStateOf<Product?>(null)

    @Before
    fun setup() {
        composeTestRule.setContent {
            MaterialTheme {
                val product = product.value ?: return@MaterialTheme
                ProductItem(product = product)
            }
        }
    }

    @Test
    fun 상품의_이름은_그대로_출력한다() {
        // given
        val productName = "PET보틀-정사각"
        val product = fakeProduct(name = productName)

        // when
        this.product.value = product

        // then
        composeTestRule
            .onNodeWithText(productName)
            .assertIsDisplayed()
    }

    @Test
    fun 상품의_가격은_원화_단위로_출력한다() {
        // given
        val productPrice = 44100
        val product = fakeProduct(price = productPrice)

        // when
        this.product.value = product

        // then
        composeTestRule
            .onNodeWithText("44,100원")
            .assertIsDisplayed()
    }

    private fun fakeProduct(
        name: String = "",
        price: Int = 0,
        imageUrl: String = "",
    ) = Product(
        id = "",
        name = name,
        price = price,
        imageUrl = imageUrl,
    )
}
