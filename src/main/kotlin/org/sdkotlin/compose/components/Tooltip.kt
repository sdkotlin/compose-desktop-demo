package org.sdkotlin.compose.components

import androidx.compose.foundation.BoxWithTooltip
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun Tooltip(
	tooltipText: String,
	delayMillis: Int = 500,
	content: @Composable () -> Unit,
) {
	BoxWithTooltip(
		tooltip = {
			Surface(
				modifier = Modifier.shadow(4.dp),
				shape = RoundedCornerShape(4.dp)
			) {
				Text(
					text = tooltipText,
					modifier = Modifier.padding(10.dp)
				)
			}
		},
		delay = delayMillis, // in milliseconds
		offset = DpOffset((-8).dp, 4.dp) // tooltip offset
	) {
		content()
	}
}
