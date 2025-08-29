package org.example.projecttracker

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

/**
 * Creates a frosted glass effect with enhanced transparency
 */
@Composable
fun FrostedGlass(
    modifier: Modifier = Modifier,
    cornerRadius: androidx.compose.ui.unit.Dp = 16.dp,
    alphaValue: Float = 0.15f,
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
                        Color.White.copy(alpha = 0.3f),
                        Color.White.copy(alpha = 0.1f),
                        Color.White.copy(alpha = 0.05f)
                    )
                )
            )
    ) {
        content()
    }
}

/**
 * Creates a glass morphism effect with animated borders
 */
@Composable
fun AnimatedGlassBorder(
    modifier: Modifier = Modifier,
    cornerRadius: androidx.compose.ui.unit.Dp = 16.dp,
    alphaValue: Float = 0.2f,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "border")
    val animatedValue by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "border"
    )
    
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .graphicsLayer {
                alpha = alphaValue
                clip = true
            }
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.3f * animatedValue),
                        Color.White.copy(alpha = 0.1f),
                        Color.White.copy(alpha = 0.3f * (1f - animatedValue))
                    )
                )
            )
    ) {
        content()
    }
}

/**
 * Creates a glass morphism effect with rainbow borders
 */
@Composable
fun RainbowGlass(
    modifier: Modifier = Modifier,
    cornerRadius: androidx.compose.ui.unit.Dp = 16.dp,
    alphaValue: Float = 0.2f,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "rainbow")
    val animatedValue by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rainbow"
    )
    
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .graphicsLayer {
                alpha = alphaValue
                clip = true
            }
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFff0080),
                        Color(0xFFff8c00),
                        Color(0xFF40e0d0),
                        Color(0xFFee82ee),
                        Color(0xFFff0080)
                    )
                )
            )
            .padding(2.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.25f),
                        Color.White.copy(alpha = 0.1f)
                    )
                ),
                shape = RoundedCornerShape(cornerRadius - 2.dp)
            )
    ) {
        content()
    }
}

/**
 * Creates a glass morphism effect with particle system
 */
@Composable
fun ParticleGlass(
    modifier: Modifier = Modifier,
    cornerRadius: androidx.compose.ui.unit.Dp = 16.dp,
    alphaValue: Float = 0.2f,
    particleCount: Int = 20,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "particles")
    
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
        // Animated particles
        repeat(particleCount) { index ->
            val delay = index * 100
            val animatedOffset by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(2000 + delay, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "particle$index"
            )
            
            val particleSize = (5 + (index % 3) * 2).dp
            val particleAlpha = 0.1f + (index % 3) * 0.1f
            
            Box(
                modifier = Modifier
                    .size(particleSize)
                    .offset(
                        x = (animatedOffset * 200 - 100).dp,
                        y = (animatedOffset * 200 - 100).dp
                    )
                    .background(
                        Color.White.copy(alpha = particleAlpha),
                        CircleShape
                    )
            )
        }
        
        content()
    }
}

/**
 * Creates a glass morphism effect with wave animation
 */
@Composable
fun WaveGlass(
    modifier: Modifier = Modifier,
    cornerRadius: androidx.compose.ui.unit.Dp = 16.dp,
    alphaValue: Float = 0.2f,
    waveCount: Int = 3,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "wave")
    val animatedValue by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "wave"
    )
    
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
 * Creates a glass morphism effect with magnetic field simulation
 */
@Composable
fun MagneticGlass(
    modifier: Modifier = Modifier,
    cornerRadius: androidx.compose.ui.unit.Dp = 16.dp,
    alphaValue: Float = 0.2f,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "magnetic")
    val animatedValue by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "magnetic"
    )
    
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .graphicsLayer {
                alpha = alphaValue
                clip = true
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
