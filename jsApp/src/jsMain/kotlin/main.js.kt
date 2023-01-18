import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.window.Window
import com.programmersbox.common.UIShow
import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    onWasmReady {
        Window("GDQ Schedule") {
            Column {
                /*Button({ println(window.prompt("Hello", "World")) }) { Text("Prompt") }
                Button({ window.alert("Hello World") }) { Text("Alert") }
                Button({ println(window.confirm("Hello World")) }) { Text("Confirm") }*/
                UIShow()
            }
        }
    }
}