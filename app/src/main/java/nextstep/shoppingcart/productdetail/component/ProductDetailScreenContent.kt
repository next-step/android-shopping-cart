package nextstep.shoppingcart.productdetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import nextstep.shoppingcart.R
import nextstep.shoppingcart.common.model.Product
import nextstep.shoppingcart.common.theme.NextStepTheme
import java.text.NumberFormat
import java.util.Locale

@Composable
internal fun ProductDetailScreenContent(
    product: Product,
    modifier: Modifier,
) {
    Column(
        modifier = modifier.verticalScroll(state = rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    drawLine(
                        color = Color(0xFFAAAAAA),
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = 1.dp.toPx(),
                    )
                }
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.imageUrl)
                    .crossfade(true)  // 페이드 인 애니메이션
                    .error(R.drawable.ic_outline_image_not_supported_24)  // 로드 실패 시 표시할 이미지
                    .placeholder(R.drawable.ic_outline_image_search_24)  // 로딩 중에 표시할 이미지
                    .build(),
                contentDescription = product.name
            )

            Text(
                text = product.name,
                style = NextStepTheme.typography.roboto24B,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.amount_of_money),
                style = NextStepTheme.typography.sans20N
            )

            Text(
                text = stringResource(
                    R.string.amount_of_money_right,
                    NumberFormat.getNumberInstance(Locale.KOREA).format(product.price)
                ),
                style = NextStepTheme.typography.sans20N,
            )
        }
    }
}