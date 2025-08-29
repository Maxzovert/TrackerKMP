package org.example.projecttracker

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GlassMorphismScreen(
    onBackPressed: () -> Unit
) {
    var selectedExample by remember { mutableStateOf(0) }
    
    // Animated background with moving gradients
    val infiniteTransition = rememberInfiniteTransition(label = "background")
    val animatedValue by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "background"
    )
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF667eea),
                        Color(0xFF764ba2),
                        Color(0xFFf093fb),
                        Color(0xFFf5576c)
                    )
                )
            )
    ) {
        // Animated floating orbs in background
        repeat(5) { index ->
            val delay = index * 1000
            val animatedOffset by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(3000 + delay, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                ),
                label = "orb$index"
            )
            
            Box(
                modifier = Modifier
                    .size(100.dp + (index * 20).dp)
                    .offset(
                        x = (animatedOffset * 400 - 200).dp,
                        y = (animatedOffset * 600 - 300).dp
                    )
                    .clip(CircleShape)
                    .background(
                        Color.White.copy(alpha = 0.1f)
                    )
            )
        }
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Header with back button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                GlassTile(
                    modifier = Modifier.size(48.dp),
                    cornerRadius = 24.dp,
                    alphaValue = 0.2f
                ) {
                    IconButton(
                        onClick = onBackPressed,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(
                            "←",
                            fontSize = 20.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                
                Text(
                    "Glass Morphism",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                
                Spacer(modifier = Modifier.size(48.dp))
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Example selector
            GlassCard(
                modifier = Modifier.fillMaxWidth(),
                cornerRadius = 16.dp,
                alphaValue = 0.25f
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        "Select Example:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        listOf("Basic", "Advanced", "Interactive", "Effects").forEachIndexed { index, text ->
                                            GlassTile(
                    modifier = Modifier.weight(1f).padding(horizontal = 4.dp),
                    cornerRadius = 12.dp,
                    alphaValue = if (selectedExample == index) 0.3f else 0.15f
                ) {
                                Button(
                                    onClick = { selectedExample = index },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Transparent
                                    )
                                ) {
                                    Text(
                                        text,
                                        color = Color.White,
                                        fontSize = 14.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Example content
            when (selectedExample) {
                0 -> BasicGlassExamples()
                1 -> AdvancedGlassExamples()
                2 -> InteractiveGlassExamples()
                3 -> AdvancedEffectsExamples()
            }
        }
    }
}

@Composable
private fun BasicGlassExamples() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "Basic Glass Effects",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        
        // Simple glass tile
        GlassTile(
            modifier = Modifier.fillMaxWidth().height(80.dp),
            cornerRadius = 16.dp,
            alphaValue = 0.2f
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Simple Glass Tile",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        
        // Glass tile with border
        GlassTileWithBorder(
            modifier = Modifier.fillMaxWidth().height(80.dp),
            cornerRadius = 16.dp,
            alphaValue = 0.25f,
            borderWidth = 1.dp,
            borderColor = Color.White.copy(alpha = 0.4f)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Glass Tile with Border",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        
        // Glass card with elevation
        GlassCard(
            modifier = Modifier.fillMaxWidth().height(80.dp),
            cornerRadius = 20.dp,
            alphaValue = 0.3f,
            elevation = 12.dp
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Glass Card with Elevation",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
private fun AdvancedGlassExamples() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "Advanced Glass Effects",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        
        // Grid of glass tiles
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            repeat(2) { index ->
                GlassTile(
                    modifier = Modifier.weight(1f).height(120.dp),
                    cornerRadius = 20.dp,

                    alphaValue = 0.2f + (index * 0.1f)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            "Tile ${index + 1}",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Alpha: ${0.2f + (index * 0.1f)}",
                            color = Color.White.copy(alpha = 0.8f),
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
        
        // Layered glass effect
        Box(
            modifier = Modifier.fillMaxWidth().height(100.dp)
        ) {
            GlassTile(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .offset(y = 20.dp),
                cornerRadius = 16.dp,
                alphaValue = 0.15f
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Background Layer",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 14.sp
                    )
                }
            }
            
            GlassTile(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                cornerRadius = 16.dp,
                alphaValue = 0.25f
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Foreground Layer",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Composable
private fun InteractiveGlassExamples() {
    var isExpanded by remember { mutableStateOf(false) }
    var selectedColor by remember { mutableStateOf(0) }
    
    val colors = listOf(
        Color(0xFF667eea),
        Color(0xFF764ba2),
        Color(0xFFf093fb),
        Color(0xFFf5576c)
    )
    
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "Interactive Glass Effects",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        
        // Expandable glass card
        GlassCard(
            modifier = Modifier.fillMaxWidth(),
            cornerRadius = 20.dp,
            alphaValue = 0.25f,
            elevation = 8.dp
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Expandable Card",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    
                    Button(
                        onClick = { isExpanded = !isExpanded },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        )
                    ) {
                        Text(
                            if (isExpanded) "Collapse" else "Expand",
                            color = Color.White
                        )
                    }
                }
                
                AnimatedVisibility(
                    visible = isExpanded,
                    enter = expandVertically() + fadeIn(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    Column(
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text(
                            "This is the expanded content of the glass card. You can put any content here and it will maintain the beautiful glass morphism effect.",
                            color = Color.White.copy(alpha = 0.9f),
                            fontSize = 14.sp,
                            lineHeight = 20.sp
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Color picker
                        Text(
                            "Choose Background Color:",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            colors.forEachIndexed { index, color ->
                                GlassTile(
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape),
                                    cornerRadius = 16.dp,
                                    alphaValue = if (selectedColor == index) 0.4f else 0.2f
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(color)
                                            .clip(CircleShape)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        
        // Interactive glass tiles
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            repeat(3) { index ->
                var isPressed by remember { mutableStateOf(false) }
                
                GlassTile(
                    modifier = Modifier
                        .weight(1f)
                        .height(80.dp),
                    cornerRadius = 16.dp,
                    alphaValue = if (isPressed) 0.35f else 0.2f
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Press Me!",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AdvancedEffectsExamples() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "Advanced Glass Effects",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        
        // Frosted glass effect
        FrostedGlass(
            modifier = Modifier.fillMaxWidth().height(80.dp),
            cornerRadius = 16.dp,
            alphaValue = 0.2f
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Frosted Glass Effect",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        
        // Animated border glass
        AnimatedGlassBorder(
            modifier = Modifier.fillMaxWidth().height(80.dp),
            cornerRadius = 16.dp,
            alphaValue = 0.25f
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Animated Border Glass",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        
        // Animated border glass effect
        AnimatedGlassBorder(
            modifier = Modifier.fillMaxWidth().height(80.dp),
            cornerRadius = 16.dp,
            alphaValue = 0.2f
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Animated Border Glass",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        
        // Rainbow glass effect
        RainbowGlass(
            modifier = Modifier.fillMaxWidth().height(80.dp),
            cornerRadius = 16.dp,
            alphaValue = 0.25f
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Rainbow Glass Effect",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        
        // Particle glass effect
        ParticleGlass(
            modifier = Modifier.fillMaxWidth().height(80.dp),
            cornerRadius = 16.dp,
            alphaValue = 0.2f,
            particleCount = 15
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().height(80.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Particle Glass Effect",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        
        // Wave glass effect
        WaveGlass(
            modifier = Modifier.fillMaxWidth().height(80.dp),
            cornerRadius = 16.dp,
            alphaValue = 0.2f,
            waveCount = 3
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().height(80.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Wave Glass Effect",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        
        // Magnetic glass effect
        MagneticGlass(
            modifier = Modifier.fillMaxWidth().height(80.dp),
            cornerRadius = 16.dp,
            alphaValue = 0.2f
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().height(80.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Magnetic Glass Effect",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
