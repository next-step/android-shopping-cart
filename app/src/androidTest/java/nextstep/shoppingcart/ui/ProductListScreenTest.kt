package nextstep.shoppingcart.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onLast
import androidx.compose.ui.test.onNodeWithText
import nextstep.shoppingcart.model.ProductModel
import org.junit.Rule
import org.junit.Test

class ProductListScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val products = listOf(
        ProductModel(
            id = 1,
            imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
            name = "우유",
            price = 1000
        ),
        ProductModel(
            id = 2,
            imageUrl = "https://i.namu.wiki/i/QRHEugeivDhbNPuCzDMfraDC5Rd4chhuWLF7JTrQHzN-t5-Fxi4R2iqpaKIk0Hm_SCWC_oD76kz_SIwkaQQrcQ.webp",
            name = "초코우유",
            price = 2000
        ),
        ProductModel(
            id = 3,
            imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
            name = "커피우유",
            price = 2500
        ),
        ProductModel(
            id = 4,
            imageUrl = "https://i.namu.wiki/i/Gj5s8EAX_AiQRQIeOK7MYO9WDI9jv2VxIoG4fsfOL9JNYbZLGrWYmR3YX-8RFQ45_rElsB1AJ6oXc6AHiP-VcnMDzD0i39q10gcbK4rkkcTZcBxp9eDuCyw6xz6pgeLMy48xKcFniW2FshY48NV4Wg.webp",
            name = "사과",
            price = 2500
        ),
    )

    @Test
    fun 상품목록의_아이템이_노출() {
        // given
        composeTestRule.setContent {
            ProductListScreen(
                products = products,
                modifier = Modifier.testTag("productList"),
            )
        }

        // then
        products.forEach { item ->
            composeTestRule
                .onNodeWithText(item.name)
                .assertIsDisplayed()
        }
        composeTestRule
            .onAllNodesWithTag("productList")
            .onLast()
            .onChildren()
            .assertCountEquals(products.size)
    }
}