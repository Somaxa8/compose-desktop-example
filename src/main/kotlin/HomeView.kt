import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun homeView() {
    MaterialTheme() {
        Button(onClick = { println("Hola") }) {
            Text("hola mundo")
        }
    }
}