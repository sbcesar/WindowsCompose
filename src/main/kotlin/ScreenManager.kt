import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.rememberWindowState

@Composable
@Preview
fun ScreenManager() {
    var showSecondWindow by remember { mutableStateOf(false) }

    if (!showSecondWindow) {
        MainScreen {
            showSecondWindow = true
        }
    } else {
        SecondaryWindow(onClose = {
            showSecondWindow = false
        })
    }
}

@Composable
fun MainScreen(
    onSwitchScreen: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(100.dp,Alignment.CenterVertically),
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "MAIN SCREEN",
        )
        Button(
            onClick = onSwitchScreen,
            colors = ButtonDefaults.buttonColors(Color.Magenta)
        ) {
            Text(
                text = "OPEN SECOND WINDOW",
                color = Color.White
            )
        }
    }
}

@Composable
fun SecondaryWindow(onClose: () -> Unit) {
    Window(
        onCloseRequest = onClose,
        title = "Login",
        state = rememberWindowState()
    ) {
        LoginScreen()
    }
}