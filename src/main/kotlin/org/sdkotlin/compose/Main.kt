package org.sdkotlin.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowSize
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.sdkotlin.compose.components.ChangeTextButton
import org.sdkotlin.compose.components.Tooltip

@ExperimentalComposeUiApi
fun main() = application {

	val windowState = rememberWindowState(size = WindowSize(width = 1024.dp, height = 768.dp))

	Window(title = "Demo", state = windowState) {

		MaterialTheme {
			Column(
				modifier = Modifier.fillMaxWidth().fillMaxHeight(),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center
			) {
				Tooltip(tooltipText = "Click me!") {
					ChangeTextButton(initialText = "Hello, World!", clickText = "Hello, Desktop!")
				}
			}
		}
	}
}
