import androidx.compose.desktop.AppManager
import androidx.compose.desktop.Window
import androidx.compose.desktop.WindowEvents
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.MenuItem
import androidx.compose.ui.window.KeyStroke
import androidx.compose.ui.window.Menu
import androidx.compose.ui.window.MenuBar
import java.awt.Color
import java.awt.image.BufferedImage


fun main() {
    val count = mutableStateOf(0)
    val windowPos = mutableStateOf(IntOffset.Zero)

    Window(
        title = "MyApp",
        size = IntSize(1200, 600),
        icon = getMyAppIcon(),
        menuBar = MenuBar(
            Menu(
                name = "Actions",
                MenuItem(
                    name = "Increment value",
                    onClick = { count.value++ },
                    shortcut = KeyStroke(Key.I)
                ),
                MenuItem(
                    name = "Exit",
                    onClick = { AppManager.exit() },
                    shortcut = KeyStroke(Key.X)
                )
            )
        ),
        events = WindowEvents(
            onRelocate = { location ->
                windowPos.value = location
            }
        )
    ) {
        homeView()
    }
}

fun getMyAppIcon() : BufferedImage {
    val size = 256
    val image = BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB)
    val graphics = image.createGraphics()
    graphics.color = Color.orange
    graphics.fillOval(0, 0, size, size)
    graphics.dispose()
    return image
}