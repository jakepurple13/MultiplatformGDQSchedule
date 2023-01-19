import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberTrayState
import com.programmersbox.common.UIShow

fun main() = application {

    val trayState = rememberTrayState()

    Tray(
        state = trayState,
        icon = TrayIcon,
        onAction = { },
        menu = { Item("Quit App", onClick = ::exitApplication) }
    )

    Window(
        onCloseRequest = {

        }
    ) {
        UIShow(trayState)
    }
}


object TrayIcon : Painter() {
    override val intrinsicSize = Size(256f, 256f)

    override fun DrawScope.onDraw() {
        drawOval(Color(0xFFFFA500))
    }
}