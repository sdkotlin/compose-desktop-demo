package org.sdkotlin.compose.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ChangeTextButton(
	initialText: String,
	clickText: String,
) {

	var text by remember { mutableStateOf(initialText) }

	Button(onClick = {
		text = clickText
	}) {
		Text(text)
	}
}
