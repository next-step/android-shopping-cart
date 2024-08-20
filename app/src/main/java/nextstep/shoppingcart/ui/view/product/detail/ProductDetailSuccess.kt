package nextstep.shoppingcart.ui.view.product.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.composable.DinoBottomCta
import nextstep.shoppingcart.ui.model.Product

@Composable
fun ProductDetailSuccess(
    product: Product,
    onBottomCtaClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                model = product.imageUrl,
                contentDescription = stringResource(R.string.product_detail_product_image)
            )
            Text(
                modifier = Modifier.padding(18.dp),
                text = product.name,
                fontWeight = FontWeight.W700,
                fontSize = 24.sp,
                color = Color(0xff333333)
            )
            Divider(
                thickness = Dp.Hairline,
                color = Color(0xffaaaaaa)
            )
            Row(modifier = Modifier.padding(18.dp)) {
                Text(
                    text = "금액",
                    fontWeight = FontWeight.W400,
                    fontSize = 20.sp,
                    color = Color(0xff333333)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stringResource(id = R.string.product_list_product_item_price_fmt, product.price),
                    fontWeight = FontWeight.W400,
                    fontSize = 20.sp,
                    color = Color(0xff333333)
                )
            }
        }
        DinoBottomCta(
            ctaText = stringResource(R.string.product_detail_put_in_shopping_cart_button),
            onClick = onBottomCtaClick,
        )
    }

}
