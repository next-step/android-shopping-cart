package nextstep.shoppingcart.component.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.component.IconPack

public val IconPack.Remove: ImageVector
    get() {
        if (_remove != null) {
            return _remove!!
        }
        _remove = Builder(name = "Remove", defaultWidth = 11.0.dp, defaultHeight = 3.0.dp,
                viewportWidth = 11.0f, viewportHeight = 3.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.248f, 0.14035f)
                verticalLineTo(1.35965f)
                horizontalLineTo(0.9668f)
                verticalLineTo(0.14035f)
                horizontalLineTo(10.248f)
                close()
            }
        }
        .build()
        return _remove!!
    }

private var _remove: ImageVector? = null
