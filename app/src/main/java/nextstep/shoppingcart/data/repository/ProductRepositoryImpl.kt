package nextstep.shoppingcart.data.repository

import nextstep.shoppingcart.data.model.Product

object ProductRepository {
    private val _productList: List<Product> =
        listOf(
            Product(
                id = 1,
                imageUrl = "https://www.themealdb.com/images/media/meals/g046bb1663960946.jpg",
                name = "날치알이 생각보다 많은 초밥",
                price = 20000,
            ),
            Product(
                id = 2,
                imageUrl = "https://www.themealdb.com/images/media/meals/d8f6qx1604182128.jpg",
                name = "기본 카츠동",
                price = 11000,
            ),
            Product(
                id = 3,
                imageUrl = "https://www.themealdb.com/images/media/meals/wrustq1511475474.jpg",
                name = "야끼우동",
                price = 12000,
            ),
            Product(
                id = 4,
                imageUrl = "https://www.themealdb.com/images/media/meals/lwsnkl1604181187.jpg",
                name = "너무나 바삭바삭한 돈까스",
                price = 14000,
            ),
            Product(
                id = 5,
                imageUrl = "https://www.themealdb.com/images/media/meals/tyywsw1505930373.jpg",
                name = "정말 맛있는 치킨 가라아케",
                price = 8000,
            ),
            Product(
                id = 6,
                imageUrl = "https://www.themealdb.com/images/media/meals/vwrpps1503068729.jpg",
                name = "돈까스 카레 덮밥",
                price = 15000,
            ),
            Product(
                id = 7,
                imageUrl = "https://www.themealdb.com/images/media/meals/1525876468.jpg",
                name = "육즙이 바로 터져버리는 고기만두",
                price = 4000,
            ),
            Product(
                id = 8,
                imageUrl = "https://www.themealdb.com/images/media/meals/1529446137.jpg",
                name = "슴슴한 계란국",
                price = 5500,
            ),
            Product(
                id = 9,
                imageUrl = "https://www.themealdb.com/images/media/meals/1529442316.jpg",
                name = "탕수육",
                price = 33000,
            ),
            Product(
                id = 10,
                imageUrl = "https://www.themealdb.com/images/media/meals/1525874812.jpg",
                name = "마라보다 맵디매운 마파 두부",
                price = 28000,
            ),
        )

    fun getProductList(): List<Product> {
        return _productList
    }

    fun getProductById(id: Int): Product {
        return _productList.first { it.id == id }
    }
}
