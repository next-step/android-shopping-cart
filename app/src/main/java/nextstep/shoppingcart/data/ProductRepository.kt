package nextstep.shoppingcart.data

import nextstep.shoppingcart.model.Product

class ProductRepository {
    fun getProducts(): List<Product> {
        return listOf(
            Product(
                "https://s3-alpha-sig.figma.com/img/05ef/e578/d81445480aff1872344a6b1b35323488?Expires=1742774400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=iAnCjlosczr-wNaf-XUWxSynLvrnjQ8SwbkO7YN2A9cpfw8wcUsrMIpi6HDyslQFsSZ1pyb81Gw3LSDsplfPfSS9QDBa5sSCorviFhyBdsWBeU77xktfS3b3iID0cIbtEoLrag09FgNm4jVlLQdpNXPv98G3vGCk7FdVxgVSjdOMRUpCOeuEqEZX2agJtgebpfdcEz4ZfCqXxxkKa0epVujkqudUiu9iReulyaNMtUWZWzbF0zmj4-F2rVjK8M2rX~OfswEvRv3Mxu2qTrO8xRyL36~3VDIxdlpzIKrM0gGtBBpQ73XsmzugfyyOHk2Ak8PB5GKgBC0XZnthpAL3Lg__",
                "PET보틀-정사각...",
                10000
            ),
            Product(
                "https://s3-alpha-sig.figma.com/img/f081/71c9/4a1459fb4310f704c34be19a15f662a4?Expires=1742774400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=YaNob9JZiqKYXCzf2UVH~XIuO49CZdWRVkpzsxsPypPk2zAeQlicYNG-i9-7JTM0-Z-ByztRsm6GuAXhV9vEu~UrVg1Wax7YXNPDZEFAhckl3H9V2C3QaPBdhYfgTnXGabVmM-incd1y1Pf59vWoA6glzt84U4sh5O596tL--J1o3AZkjgRVYsTV0ujzLAqAQhc0~LaAW6ezPkkZk3M1eSInU3ZJZLPhTg9FB8IEUU6ZThdYMC5pO4K~Moww6HWFkG~5fnYXGlDcZkUgJPpDv8h3PzWaNjl36pHMLV~JllRvOTVWpuc8IWag-O2HOmDjs1adeX~7vjNIpQ38ZI9iBQ__",
                "PET보틀-밀크티...",
                12000
            ),
            Product(
                "https://s3-alpha-sig.figma.com/img/ff9f/d83e/b40e670bfc38dbcddbcec8b3ca363d50?Expires=1742774400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=exOuCQEXROSgmhZysqykFHaGEjOq3MCSjrvMzrvgvs8iyEZaGHrWhYG~Fs9hP2sXyUfpWsb0LhFQwdtujDhx6c2dqK1FS84A2vBD3Js89jmEbduQ9CILQmQI1mXsDslMtmyQL8eV2T6rt2pIALB2ldzYYF8WpvrjDfKldz~caInC9aFCMg3JUa~QA9v4qTrzQObCwM7K~s4F4rPKbtJhqPwJ-JPcarcPMq1y22ErJJs87Ff81~UJeiGP7sRs9YMFfsTZrwHENKT~a~1S9nwHxTOv7ct4T4e33MBzN5NdWg9FiscH8KIYdhPMBKL8yvUEamZbYMf3cm~vVYGhjnJ0Og__",
                "PET보틀-정사각...",
                10000
            ),
            Product(
                "https://s3-alpha-sig.figma.com/img/b8b6/a740/d8661b91e8210779ce9db930d260230d?Expires=1742774400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=MaKkiGsJ4Tq0P14Q0TP2fIeCacSXnBpNjLGNCHgV~nF9rJWbAZMqaO2iB3sNAz4NMedZ4EdkCo0XoAuqlY4siAJN3zlePrYXOsO8ndlNA22ALSkSiI15cbne3taMsUOrFQ2juhKHZAPKePmC3JYfc2u728Wlw0H79RSDPkvRT9OZclsfyDAphzftr1r5CVCU7lWXrX~MRE2pl4YgHc0Qe5ghUw0iL75Xsl1Dm9EqRYj53aMoF4oVbUfd3ldeWnTcSIZH2GNWTolXh8Ym3H0NDAEqYzcOf~jkLqOLt3gndOmWTrsDObyVgNWbghIkJuMp~RaE3nVxjZfM19OqlVht9w__",
                "PET보틀-납작(2...",
                12000
            ),
            Product(
                "https://s3-alpha-sig.figma.com/img/8f83/c0e8/c17365cdfe5a00fa17c0283d520f4a99?Expires=1742774400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=asAZL81vBh7uM2pu1Gm5Azv-PhSQPsKnr6mozNLJxhJwnkHo4aACnb0nW595OCDVj0ujzN1kXpg9wNZqZM8MDTNXHFa7tpRzTLonyBwSUfQFZtm6kqwET3bDdgfQSab0V7AaCEVcCTW7iOu72UNc~u0jZXwkuVSG2SbsC0-C50AQbzQfypYTzowh1pqZ5cEHem3tSANrMorRW-NkUw9RtWYzlmOjhK5ZsAc6gEYqkUuEprjI0yevqYuAhm6R7k2jUFaro--A2oZDbsFov4EPHtThDulUByX~ByqiuiOaTt~DFpgcgKHR2R2h1BLHix4AS96ksXENOvtpKkraioofPg__",
                "PET보틀-정사각...",
                10000
            ),
            Product(
                "https://s3-alpha-sig.figma.com/img/b9f2/403d/b915b1b22edac0877abb7b97129296b6?Expires=1742774400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=joZjFDjunU-KZYNAEeL7lnjo54w4dVJiTsJhbh759JvauNRzbduDrimn7b43hxZdqMBf~jJIZH~BCevsIRIh6FMlPblfLWCNJiGyoE1f7cl~Kl8MdS6iIQ~sesDO~bVQn8hi6ZzDq66BRvn5rB4wPVM-6IFO6y0V1fjWig77kDAkk5KaCs5c5Pr8zBw0oXtSz3FONDyxRz9c6wjHhXBY2gn~S5psw-fKr9j10ERWP3hw9wZeisOOV6wEdcTaCZkmUXcoaFJoDTWEd9sZXcZ0QAEa1uZgff~QJKNXLRVWHPSUGZVOmJAKHRbjv6AeQWvDpPbQLeCSYrRaKB0EqYvIhQ__",
                "PET보틀-납작(2...",
                12000
            ),
            Product(
                "https://s3-alpha-sig.figma.com/img/fd20/b2b8/827d18cb936f84b3d7ab156b54952df7?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=mV~26532GM~FVWvuulYCjYZTlP9AhkSmZT7aeIbznHveYv5e0Vq8wh0FK6Ja7JvuV5Z7ixdE5KKw5J1B1rIG6i0ySx545Wft3ujyRHafo264bPrkohy6mDoaJx03my9weXbRtBZ0lygdiSwg9VJgBNSZDK7zWK6fawbfZNmy1ULnZznFzfgAe~GgSGBeOxkT6Fj13Gg8wiAXFLNy577pWqVGAEUTq-IZ-iL6513UJ-dYVCajNeA4158pmaEse7MzKg~bNUr6qoYEJ9fHUBHmuCNKSTnX3H2ojNDzJ~dYmcM30V44FoB-0wL~hUA4Iz-tl1GgAc4QbKXqqzpbEU~-0g__",
                "[든든] 동원 스위트콘",
                99800
            ),
            Product(
                "https://s3-alpha-sig.figma.com/img/c207/5f9e/651a2553089d78809044bd63d7019dc8?Expires=1743379200&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=PViwNeN7MlmTnKIYtXOB0Zkr7e-T4V-MflWL3Xi3KqFtoUgpZ55OXOFtsaaVOULytnqVIjakmr-7v5cu2YgBo-q9MF4cX-hfczCfB-izlhZ-psFH33~3X8rN7cUPhLBe7U3YwDnznADswr2MBkYIXsBi9b0yrip6MN6Eyp9rqxYN5XL3ogshLDXPRwiPROQaUhL8cdV63NwZvTB07dvw~Yj78W2Kpr7nPV6xrxj7jQ7OrwuZT1~KMJZv1kwCMLFgHfzwuj2pGYY5tHg1g1ldhVaH5ygPfGMfS-8yvxIrhl16s0Rh6RQZsLhXG0LSWmn05VOaD~8yJPIsrltICQpzhw__",
                "PET보틀-원형(500ml)",
                84400
            ),
        )
    }
}