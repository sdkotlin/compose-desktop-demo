package org.sdkotlin.compose

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowSize
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.sdkotlin.compose.components.ChangeTextButton
import org.sdkotlin.compose.components.MyLayout
import org.sdkotlin.compose.components.MyTheme
import org.sdkotlin.compose.components.StandardTooltip

@ExperimentalComposeUiApi
fun main() = application {

	val windowState = rememberWindowState(size = WindowSize(width = 1024.dp, height = 768.dp))

	Window(title = "Demo", state = windowState) {
		MyTheme {
			MyLayout {
				StandardTooltip(tooltipText = "Click me!") {
					ChangeTextButton(initialText = "Hello, World!", clickText = "Hello, Desktop!")
				}
			}
		}
	}
}
