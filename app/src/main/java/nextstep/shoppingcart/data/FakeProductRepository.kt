package nextstep.shoppingcart.data

import nextstep.shoppingcart.domain.Price
import nextstep.shoppingcart.domain.Product
import nextstep.shoppingcart.domain.ProductRepository
import nextstep.shoppingcart.domain.Products

object FakeProductRepository : ProductRepository {
    override fun getAllProducts(): Products {
        return Products(
            listOf(
                Product(
                    id = 1,
                    name = "Wireless Mouse",
                    price = Price.of(9500),
                    imageUrl = "https://media.istockphoto.com/id/1458492520/ko/%EC%82%AC%EC%A7%84/%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD%EC%97%90-%EA%B2%A9%EB%A6%AC-%EB%90%9C-%EA%B2%80%EC%9D%80-%EC%83%89-%EB%AC%B4%EC%84%A0-%EC%BB%B4%ED%93%A8%ED%84%B0-%EB%A7%88%EC%9A%B0%EC%8A%A4.jpg?s=2048x2048&w=is&k=20&c=G4NKK2vawg36_ejtJ8U-v0kG9I1xfZ8E34SQd5-F-VQ="
                ),
                Product(
                    id = 2,
                    name = "Mechanical Keyboard",
                    price = Price.of(12000),
                    imageUrl = "https://cdn.pixabay.com/photo/2022/08/14/16/39/keyboard-7386244_1280.jpg"
                ),
                Product(
                    id = 3,
                    name = "HD Monitor",
                    price = Price.of(15000),
                    imageUrl = "https://cdn.pixabay.com/photo/2017/03/24/07/01/computer-2170392_1280.jpg"
                ),
                Product(
                    id = 4,
                    name = "USB-C Hub",
                    price = Price.of(8000),
                    imageUrl = "https://media.istockphoto.com/id/1566051942/ko/%EC%82%AC%EC%A7%84/usb-c-%EB%A9%80%ED%8B%B0%ED%8F%AC%ED%8A%B8-%ED%97%88%EB%B8%8C%EA%B0%80-%EC%9E%88%EB%8A%94-%ED%83%9C%EB%B8%94%EB%A6%BF-%EC%B6%A9%EC%A0%84.jpg?s=2048x2048&w=is&k=20&c=I_pqVVno4_v7lYQ9-vjZALqcf_9m1TU-EwupYktvbQg="
                ),
                Product(
                    id = 5,
                    name = "External Hard Drive",
                    price = Price.of(11000),
                    imageUrl = "https://media.istockphoto.com/id/2135718673/ko/%EC%82%AC%EC%A7%84/usb%EB%A5%BC-%ED%86%B5%ED%95%B4-%EC%B5%9C%EC%8B%A0-%EB%85%B8%ED%8A%B8%EB%B6%81%EC%97%90-%EC%97%B0%EA%B2%B0%EB%90%9C-%EC%99%B8%EC%9E%A5-%ED%95%98%EB%93%9C-%EB%94%94%EC%8A%A4%ED%81%AC-%EB%93%9C%EB%9D%BC%EC%9D%B4%EB%B8%8C.jpg?s=2048x2048&w=is&k=20&c=zIxxhouNFbgoZ_p1RDMdYU548omU6Ha3gLbjfFqgp3c="
                ),
                Product(
                    id = 6,
                    name = "Bluetooth Speaker",
                    price = Price.of(13000),
                    imageUrl = "https://media.istockphoto.com/id/1335374517/ko/%EB%B2%A1%ED%84%B0/%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD%EC%97%90-%EC%A0%84%EC%9B%90-%ED%8C%8C%EB%9E%80%EC%83%89-%EB%A6%AC%EB%93%9C%EC%99%80-%EB%B8%94%EB%9E%99-%EB%B8%94%EB%A3%A8%ED%88%AC%EC%8A%A4-%EC%8A%A4%ED%94%BC%EC%BB%A4-eps10-%EB%B2%A1%ED%84%B0-%ED%99%98%EC%83%81.jpg?s=2048x2048&w=is&k=20&c=hXLCRI63VzJPUmbDfvUnixVsoHFmp0eWKe6HRNxThiE="
                ),
                Product(
                    id = 7,
                    name = "Webcam",
                    price = Price.of(7000),
                    imageUrl = "https://media.istockphoto.com/id/1366598344/ko/%EC%82%AC%EC%A7%84/%ED%99%94%EC%83%81-%ED%9A%8C%EC%9D%98%EC%97%90-%ED%99%94%EC%83%81-%ED%86%B5%ED%99%94%EC%97%90-%EC%B0%B8%EC%97%AC%ED%95%98%EA%B1%B0%EB%82%98-%EC%9B%B9%EC%BA%A0-%EA%B0%9C%EB%85%90%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%98%EC%97%AC.jpg?s=2048x2048&w=is&k=20&c=NpgZpUJnY0Uc8T1oZGuX6Bhd6SiwgKwZhw3ntD23glc="
                ),
                Product(
                    id = 8,
                    name = "Wireless Charger",
                    price = Price.of(9000),
                    imageUrl = "https://media.istockphoto.com/id/1028116790/ko/%EC%82%AC%EC%A7%84/%EA%B7%BC%EC%A0%91-%EC%A0%84%ED%99%94-%EB%AC%B4%EC%84%A0-%EC%B6%A9%EC%A0%84%EA%B8%B0-%EC%9E%A5%EC%B9%98%EC%97%90-%EC%B6%A9%EC%A0%84.jpg?s=2048x2048&w=is&k=20&c=t6HNJWwA5iH9NxQfU3Ust2QRz1gt8gi7LBVh6r-Yw2c="
                ),
                Product(
                    id = 9,
                    name = "Portable SSD",
                    price = Price.of(14000),
                    imageUrl = "https://media.istockphoto.com/id/1366928542/ko/%EC%82%AC%EC%A7%84/%ED%9C%B4%EB%8C%80%EC%9A%A9-ssd-%EB%93%9C%EB%9D%BC%EC%9D%B4%EB%B8%8C-%EB%94%94%EC%8A%A4%ED%81%AC.jpg?s=2048x2048&w=is&k=20&c=SkG-8xPlBYavhgxbUCgFwYAYu45PuY7ktO07Xru1Tgc="
                ),
                Product(
                    id = 10,
                    name = "Noise Cancelling Headphones",
                    price = Price.of(16000),
                    imageUrl = "https://media.istockphoto.com/id/1363897157/ko/%EC%82%AC%EC%A7%84/%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD%EC%97%90-%EA%B2%80%EC%9D%80-%EA%B0%80%EC%A3%BD%EC%9C%BC%EB%A1%9C-%EC%A0%88%EC%97%B0-%EB%90%9C-%EB%AC%B4%EC%84%A0-%EC%9D%B8%EC%9D%B4%EC%96%B4-%ED%97%A4%EB%93%9C%ED%8F%B0.jpg?s=2048x2048&w=is&k=20&c=CDt6qwVS12Q-BBK1f1HPer0OxgWVQXMS8Hgm-RBTbr4="
                ),
                Product(
                    id = 11,
                    name = "Smartwatch",
                    price = Price.of(18000),
                    imageUrl = "https://media.istockphoto.com/id/1286099942/ko/%EC%82%AC%EC%A7%84/%ED%99%94%EB%A9%B4%EC%97%90-%EA%B1%B4%EA%B0%95-%EC%9D%91%EC%9A%A9-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%A8%EA%B3%BC-%ED%95%A8%EA%BB%98-%EC%86%90%EC%9D%84-%EB%A7%8C%EC%A7%80%EB%8A%94-%EC%8A%A4%EB%A7%88%ED%8A%B8-%EC%9B%8C%EC%B9%98%EC%9D%98-%ED%81%B4%EB%A1%9C%EC%A6%88%EC%97%85-%ED%94%BC%ED%8A%B8%EB%8B%88%EC%8A%A4-%ED%99%9C%EC%84%B1-%EB%9D%BC%EC%9D%B4%ED%94%84-%EC%8A%A4%ED%83%80%EC%9D%BC%EC%9D%84%EC%9C%84%ED%95%9C-%EA%B0%80%EC%A0%9C%ED%8A%B8.jpg?s=2048x2048&w=is&k=20&c=5OF4W-BCeQOf6sDMal43yFuUZczOlO0KqYwLY_w18e8="
                ),
                Product(
                    id = 12,
                    name = "Fitness Tracker",
                    price = Price.of(8500),
                    imageUrl = "https://media.istockphoto.com/id/869641322/ko/%EC%82%AC%EC%A7%84/%EB%8B%B9%EC%8B%A0%EC%9D%98-%EC%86%90%EB%AA%A9%EC%97%90-%EB%8C%80-%ED%95%9C-%EA%B8%B0%EC%88%A0%EC%9D%98-%EC%B5%9C%EA%B3%A0%EC%9D%98-%EC%9E%91%ED%92%88.jpg?s=2048x2048&w=is&k=20&c=GLDU1TeTXZZlaIF5jza0xktgT0nUglMOuBN0cwsprdo="
                ),
                Product(
                    id = 13,
                    name = "Drone",
                    price = Price.of(20000),
                    imageUrl = "https://media.istockphoto.com/id/1401444200/ko/%EC%82%AC%EC%A7%84/%EB%93%9C%EB%A1%A0-%ED%99%94%EC%9D%B4%ED%8A%B8-%EC%BB%AC%EB%9F%AC-%EB%B9%84%ED%96%89-%ED%81%B4%EB%A1%9C%EC%A6%88%EC%97%85.jpg?s=2048x2048&w=is&k=20&c=HNsjq0IeqIz49jZz75JT1fN4rwBBjcSqBk1PNZjqo5w="
                ),
                Product(
                    id = 14,
                    name = "Action Camera",
                    price = Price.of(17000),
                    imageUrl = "https://media.istockphoto.com/id/1310250081/ko/%EC%82%AC%EC%A7%84/%EA%B2%80%EC%9D%80-%EC%83%89%EC%9D%98-%ED%9D%A1%EC%9E%85-%EB%A7%88%EC%9A%B4%ED%8A%B8%EC%97%90-%EC%83%88%EB%A1%9C%EC%9A%B4-4k-%EC%95%A1%EC%85%98-%EC%B9%B4%EB%A9%94%EB%9D%BC-%EA%B2%A9%EB%A6%AC%EB%90%9C-%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD.jpg?s=2048x2048&w=is&k=20&c=agwphaCDqPT0v92pFAEo8oeqBYgKSouZTSMEGoJwJwY="
                ),
                Product(
                    id = 15,
                    name = "E-Reader",
                    price = Price.of(9500),
                    imageUrl = "https://media.istockphoto.com/id/1468285968/ko/%EC%82%AC%EC%A7%84/%ED%9C%B4%EB%8C%80%EC%9A%A9-%EC%A0%84%EC%9E%90-%EC%B1%85%EA%B3%BC-%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD%EC%97%90-%ED%95%98%EB%93%9C-%EC%BB%A4%EB%B2%84-%EC%B1%85-%EC%8A%A4%ED%83%9D.jpg?s=2048x2048&w=is&k=20&c=EoHA_Imxg95F0Wa9r1IqFLjLEt7FTYKJCVH621paORs="
                ),
                Product(
                    id = 16,
                    name = "Smartphone Gimbal",
                    price = Price.of(11500),
                    imageUrl = "https://media.istockphoto.com/id/1423411585/ko/%EC%82%AC%EC%A7%84/%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD%EC%97%90-%EC%8A%A4%EB%A7%88%ED%8A%B8-%ED%8F%B0%EC%9D%84%EC%9C%84%ED%95%9C-%EC%95%88%EC%A0%95%EC%A0%9C-%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD%EC%97%90-%EA%B3%A0%EB%A6%BD-%EB%90%9C-%ED%9D%B0%EC%83%89-%ED%99%94%EB%A9%B4%EC%9D%B4%EC%9E%88%EB%8A%94-%EC%A7%90%EB%B2%8C-%EB%B0%8F-%EC%8A%A4%EB%A7%88%ED%8A%B8-%ED%8F%B0.jpg?s=2048x2048&w=is&k=20&c=VwGh1QitWu7q7ptYItnZr7bPWWYicVy7E7sWM9v2mDI="
                ),
                Product(
                    id = 17,
                    name = "VR Headset",
                    price = Price.of(19000),
                    imageUrl = "https://media.istockphoto.com/id/1135085068/ko/%EC%82%AC%EC%A7%84/%EA%B0%80%EC%83%81-%ED%98%84%EC%8B%A4-%EC%95%88%EA%B2%BD-%ED%97%A4%EB%93%9C%EC%85%8B%EC%9D%84-%EA%B2%BD%ED%97%98-%ED%95%98%EB%8A%94-%EC%A0%8A%EC%9D%80-%EB%82%A8%EC%9E%90.jpg?s=2048x2048&w=is&k=20&c=x1qqi-UAy19eB2rdLau9auUJ9yoYCUAG5QFPXjgE1WA="
                ),
                Product(
                    id = 18,
                    name = "Gaming Controller",
                    price = Price.of(10500),
                    imageUrl = "https://media.istockphoto.com/id/1386256565/ko/%EC%82%AC%EC%A7%84/%ED%94%8C%EB%A0%88%EC%9D%B8-%EA%B7%B8%EB%A0%88%EC%9D%B4-%EB%B0%B0%EA%B2%BD%EC%97%90-%EC%B0%A8%EC%84%B8%EB%8C%80-%EA%B2%8C%EC%9E%84-%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC.jpg?s=2048x2048&w=is&k=20&c=91BKRU5ii-6d_C3vRXIznK8QlLjb0JQ_iE6wuha9oSs="
                ),
                Product(
                    id = 19,
                    name = "Laptop Stand",
                    price = Price.of(7500),
                    imageUrl = "https://media.istockphoto.com/id/1125614863/ko/%EC%82%AC%EC%A7%84/%EB%85%B8%ED%8A%B8%EB%B6%81%EC%9D%80-%EA%B0%9C%EB%B0%A9%EC%A0%81%EC%9D%B4-%EA%B3%A0-%EB%83%89%EA%B0%81-%EC%8A%A4%ED%83%A0%EB%93%9C%EC%97%90-%EC%9E%A5%EC%B0%A9-%EB%90%9C.jpg?s=2048x2048&w=is&k=20&c=73ZDVU6px-oMxi0UqDkqohABFsdhFlJ2EuWxgaGmNMg="
                ),
                Product(
                    id = 20,
                    name = "Wireless Earbuds",
                    price = Price.of(13500),
                    imageUrl = "https://media.istockphoto.com/id/1207726079/ko/%EB%B2%A1%ED%84%B0/%ED%8C%8C%EC%9A%B0%EC%B9%98%EC%99%80-%ED%98%84%EC%8B%A4%EC%A0%81%EC%9D%B8-%EB%AC%B4%EC%84%A0-%EC%9D%B4%EC%96%B4%ED%8F%B0-%ED%9D%B0%EC%83%89-%EA%B4%91%ED%83%9D-%EC%9D%8C%EC%95%85-%EC%9D%B4%EC%96%B4%EB%B2%84%EB%93%9C-%EB%AA%A8%EC%9D%98-%ED%85%9C%ED%94%8C%EB%A6%BF-%EC%82%BD%ED%99%94-%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD%EC%97%90-%EA%B2%A9%EB%A6%AC.jpg?s=2048x2048&w=is&k=20&c=yRo1jvA3j9SWFsK5LJF9kAEolpbmUyZsc7JwsVQAHdI="
                )
            )
        )
    }

    fun getFirstProduct(): Product =
        Product(
            id = 1,
            name = "Wireless Mouse",
            price = Price.of(9500),
            imageUrl = "https://media.istockphoto.com/id/1458492520/ko/%EC%82%AC%EC%A7%84/%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD%EC%97%90-%EA%B2%A9%EB%A6%AC-%EB%90%9C-%EA%B2%80%EC%9D%80-%EC%83%89-%EB%AC%B4%EC%84%A0-%EC%BB%B4%ED%93%A8%ED%84%B0-%EB%A7%88%EC%9A%B0%EC%8A%A4.jpg?s=2048x2048&w=is&k=20&c=G4NKK2vawg36_ejtJ8U-v0kG9I1xfZ8E34SQd5-F-VQ="
        )
}
