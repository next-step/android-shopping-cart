package nextstep.shoppingcart.ui.productdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.model.Product
import nextstep.shoppingcart.ui.theme.Blue50
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductDetailColumn(
    product: Product,
    modifier: Modifier = Modifier,
    onAddToCartClick: () -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                placeholder = painterResource(R.drawable.ic_photo),
                error = painterResource(R.drawable.ic_photo),
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                text = product.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            HorizontalDivider(thickness = 1.dp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = stringResource(R.string.price_text), fontSize = 20.sp)
                Text(text = product.price, fontSize = 20.sp)
            }
        }

        Button(
            onClick = onAddToCartClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            elevation = ButtonDefaults.buttonElevation(4.dp),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue50
            )
        ) {
            Text(
                text = stringResource(R.string.add_to_cart_button_text),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailColumnPreview() {
    ShoppingCartTheme {
        ProductDetailColumn(
            product = Product(
                "https://s3-alpha-sig.figma.com/img/b9f2/403d/b915b1b22edac0877abb7b97129296b6?Expires=1742774400&Key-Pair-Id=APKAQ4GOSFWCW27IBOMQ&Signature=joZjFDjunU-KZYNAEeL7lnjo54w4dVJiTsJhbh759JvauNRzbduDrimn7b43hxZdqMBf~jJIZH~BCevsIRIh6FMlPblfLWCNJiGyoE1f7cl~Kl8MdS6iIQ~sesDO~bVQn8hi6ZzDq66BRvn5rB4wPVM-6IFO6y0V1fjWig77kDAkk5KaCs5c5Pr8zBw0oXtSz3FONDyxRz9c6wjHhXBY2gn~S5psw-fKr9j10ERWP3hw9wZeisOOV6wEdcTaCZkmUXcoaFJoDTWEd9sZXcZ0QAEa1uZgff~QJKNXLRVWHPSUGZVOmJAKHRbjv6AeQWvDpPbQLeCSYrRaKB0EqYvIhQ__",
                "PET보틀-납작(2...",
                "12,000원"
            )
        )
    }
}