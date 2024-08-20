package nextstep.shoppingcart.ui.iconpack.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.ui.iconpack.IconPack

public val IconPack.IcPlus: ImageVector
    get() {
        if (_icPlus != null) {
            return _icPlus!!
        }
        _icPlus = Builder(name = "IcPlus", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 960.0f, viewportHeight = 960.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(440.0f, 520.0f)
                lineTo(240.0f, 520.0f)
                quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                reflectiveQuadTo(200.0f, 480.0f)
                quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                reflectiveQuadTo(240.0f, 440.0f)
                horizontalLineToRelative(200.0f)
                verticalLineToRelative(-200.0f)
                quadToRelative(0.0f, -17.0f, 11.5f, -28.5f)
                reflectiveQuadTo(480.0f, 200.0f)
                quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                reflectiveQuadTo(520.0f, 240.0f)
                verticalLineToRelative(200.0f)
                horizontalLineToRelative(200.0f)
                quadToRelative(17.0f, 0.0f, 28.5f, 11.5f)
                reflectiveQuadTo(760.0f, 480.0f)
                quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                reflectiveQuadTo(720.0f, 520.0f)
                lineTo(520.0f, 520.0f)
                verticalLineToRelative(200.0f)
                quadToRelative(0.0f, 17.0f, -11.5f, 28.5f)
                reflectiveQuadTo(480.0f, 760.0f)
                quadToRelative(-17.0f, 0.0f, -28.5f, -11.5f)
                reflectiveQuadTo(440.0f, 720.0f)
                verticalLineToRelative(-200.0f)
                close()
            }
        }
        .build()
        return _icPlus!!
    }

private var _icPlus: ImageVector? = null
