package org.sdkotlin.compose

import androidx.compose.foundation.BoxWithTooltip
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowSize
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@ExperimentalComposeUiApi
fun main() = application {

	val windowState = rememberWindowState(size = WindowSize(width = 1024.dp, height = 768.dp))

	Window(title = "Demo", state = windowState) {

		var text by remember { mutableStateOf("Hello, World!") }

		MaterialTheme {
			Column(
				modifier = Modifier.fillMaxWidth().fillMaxHeight(),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center
			) {
				BoxWithTooltip(
					tooltip = {
						Surface(
							modifier = Modifier.shadow(4.dp),
							shape = RoundedCornerShape(4.dp)
						) {
							Text(
								text = "Click me!",
								modifier = Modifier.padding(10.dp)
							)
						}
					},
					delay = 500, // in milliseconds
					offset = DpOffset((-8).dp, 4.dp) // tooltip offset
				) {
					Button(onClick = {
						text = "Hello, Desktop!"
					}) {
						Text(text)
					}
				}
			}
		}
	}
}
