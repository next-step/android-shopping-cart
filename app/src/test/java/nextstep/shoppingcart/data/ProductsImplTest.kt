package nextstep.shoppingcart.data

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import nextstep.shoppingcart.domain.model.Product
import org.junit.Test

class ProductsImplTest {
    @Test
    fun 입력한_ID에_상품목록에_있으면_해당하는_상품을_반환한다() {
        // given
        val id = 1L
        val products: Products =
            ProductsImpl(
                listOf(
                    Product(
                        id = 1,
                        name = "M3 MacBook Air",
                        price = 2000,
                        imgUrl =
                            "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-macbook-air-m2-m3-202402?wid=1400&hei=1000&fmt=p-jpg&qlt=95&.v=1707259317253",
                    ),
                ),
            )

        // when
        val product = products.findById(id)

        // then
        assertNotNull(product)
        assertEquals(id, product?.id)
    }

    @Test
    fun 입력한_ID에_상품목록에_없으면_null을_반환한다() {
        // given
        val id = 1L
        val products: Products =
            ProductsImpl(
                listOf(
                    Product(
                        id = 2,
                        name = "MacBook Pro",
                        price = 1000,
                        imgUrl =
                            "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-macbookpro-14-16-202310?wid=1200&hei=1000&fmt=p-jpg&qlt=95&.v=1699558878477",
                    ),
                ),
            )

        // when
        val product = products.findById(id)

        // then
        assertNull(product)
    }

    @Test
    fun 전체_상품목록을_반환한다() {
        // given
        val mockData =
            listOf(
                Product(
                    id = 1,
                    name = "M3 MacBook Air",
                    price = 2000,
                    imgUrl =
                        "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-macbook-air-m2-m3-202402?wid=1400&hei=1000&fmt=p-jpg&qlt=95&.v=1707259317253",
                ),
                Product(
                    id = 2,
                    name = "MacBook Pro",
                    price = 1000,
                    imgUrl =
                        "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-card-40-macbookpro-14-16-202310?wid=1200&hei=1000&fmt=p-jpg&qlt=95&.v=1699558878477",
                ),
            )
        val products: Products =
            ProductsImpl(mockData)

        // when
        val productList = products.getAll()

        // then
        assertEquals(mockData, productList)
    }
}
