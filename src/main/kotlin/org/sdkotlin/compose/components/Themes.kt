package org.sdkotlin.compose.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MyTheme(content: @Composable () -> Unit) {
	MaterialTheme {
		content()
	}
}
