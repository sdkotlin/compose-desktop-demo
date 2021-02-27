package org.sdkotlin.compose

import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize

fun main() {
	Window(title = "Demo", size = IntSize(width = 1024, height = 768)) {
		var text by remember { mutableStateOf("Hello, World!") }

		MaterialTheme {
			Column(
				modifier = Modifier.fillMaxWidth().fillMaxHeight(),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center
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
