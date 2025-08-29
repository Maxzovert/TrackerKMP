package org.example.projecttracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

/**
 * Reusable glass tile component that creates a glass morphism effect
 * @param modifier Modifier for the tile
 * @param content Content to be displayed inside the glass tile
 * @param cornerRadius Corner radius for the tile (default: 16.dp)
 * @param alphaValue Transparency of the glass effect (default: 0.1f)
 */
@Composable
fun GlassTile(
    modifier: Modifier = Modifier,
    cornerRadius: androidx.compose.ui.unit.Dp = 16.dp,
    alphaValue: Float = 0.1f,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .graphicsLayer {
                alpha = alphaValue
                clip = true
            }
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.25f),
                        Color.White.copy(alpha = 0.1f)
                    )
                )
            )
    ) {
        content()
    }
}

/**
 * Reusable glass background component that creates a blurred background effect
 * @param modifier Modifier for the background
 * @param alphaValue Transparency of the background (default: 0.15f)
 * @param content Content to be displayed on top of the glass background
 */
@Composable
fun GlassBackground(
    modifier: Modifier = Modifier,
    alphaValue: Float = 0.15f,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .graphicsLayer {
                alpha = alphaValue
            }
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.3f),
                        Color.White.copy(alpha = 0.1f),
                        Color.Transparent
                    )
                )
            )
    ) {
        content()
    }
}

/**
 * Enhanced glass tile with border and shadow effects
 * @param modifier Modifier for the tile
 * @param content Content to be displayed inside the glass tile
 * @param cornerRadius Corner radius for the tile (default: 16.dp)
 * @param alphaValue Transparency of the glass effect (default: 0.15f)
 * @param borderWidth Border width (default: 1.dp)
 * @param borderColor Border color (default: White with 0.3 alpha)
 */
@Composable
fun GlassTileWithBorder(
    modifier: Modifier = Modifier,
    cornerRadius: androidx.compose.ui.unit.Dp = 16.dp,
    alphaValue: Float = 0.15f,
    borderWidth: androidx.compose.ui.unit.Dp = 1.dp,
    borderColor: Color = Color.White.copy(alpha = 0.3f),
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .graphicsLayer {
                alpha = alphaValue
                clip = true
            }
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.25f),
                        Color.White.copy(alpha = 0.1f)
                    )
                )
            )
            .background(
                color = borderColor,
                shape = RoundedCornerShape(cornerRadius)
            )
            .padding(borderWidth)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.25f),
                        Color.White.copy(alpha = 0.1f)
                    )
                ),
                shape = RoundedCornerShape(cornerRadius - borderWidth)
            )
    ) {
        content()
    }
}

/**
 * Glass morphism card with elevation and enhanced visual effects
 * @param modifier Modifier for the tile
 * @param content Content to be displayed inside the glass card
 * @param cornerRadius Corner radius for the card (default: 20.dp)
 * @param alphaValue Transparency of the glass effect (default: 0.2f)
 * @param elevation Elevation for shadow effect (default: 8.dp)
 */
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    cornerRadius: androidx.compose.ui.unit.Dp = 20.dp,
    alphaValue: Float = 0.2f,
    elevation: androidx.compose.ui.unit.Dp = 8.dp,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .graphicsLayer {
                alpha = alphaValue
                clip = true
                shadowElevation = elevation.value
            }
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.3f),
                        Color.White.copy(alpha = 0.15f),
                        Color.White.copy(alpha = 0.05f)
                    )
                )
            )
    ) {
        content()
    }
}
