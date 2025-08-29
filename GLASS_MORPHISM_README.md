# Glass Morphism Effects for Kotlin Multiplatform

This project provides a comprehensive collection of reusable glass morphism effects for Kotlin Multiplatform applications using Jetpack Compose.

## 🎨 Features

- **Basic Glass Effects**: Simple, clean glass tiles and backgrounds
- **Advanced Glass Effects**: Layered effects with multiple glass components
- **Interactive Glass Effects**: Expandable cards and interactive elements
- **Special Effects**: Frosted glass, animated borders, noise textures, rainbow effects, particles, waves, and magnetic fields

## 🚀 Getting Started

### Basic Usage

```kotlin
import org.example.projecttracker.*

@Composable
fun MyScreen() {
    GlassTile(
        modifier = Modifier.fillMaxWidth().height(100.dp),
        cornerRadius = 16.dp,
        alpha = 0.2f
    ) {
        Text("This is a glass tile!")
    }
}
```

### Available Components

#### 1. GlassTile
Basic glass morphism tile with customizable transparency and corner radius.

```kotlin
GlassTile(
    modifier = Modifier.size(200.dp),
    blurRadius = 20f,
    cornerRadius = 16.dp,
    alpha = 0.15f
) {
    // Your content here
}
```

#### 2. GlassBackground
Creates a blurred background effect.

```kotlin
GlassBackground(
    modifier = Modifier.fillMaxSize(),
    blurRadius = 30f,
    alpha = 0.15f
) {
    // Content on top of glass background
}
```

#### 3. GlassTileWithBorder
Enhanced glass tile with customizable border.

```kotlin
GlassTileWithBorder(
    modifier = Modifier.size(200.dp),
    cornerRadius = 16.dp,
    alpha = 0.2f,
    borderWidth = 1.dp,
    borderColor = Color.White.copy(alpha = 0.3f)
) {
    // Your content here
}
```

#### 4. GlassCard
Glass morphism card with elevation and shadow effects.

```kotlin
GlassCard(
    modifier = Modifier.size(200.dp),
    cornerRadius = 20.dp,
    alpha = 0.25f,
    elevation = 8.dp
) {
    // Your content here
}
```

### Advanced Effects

#### 5. FrostedGlass
Creates a frosted glass effect with enhanced transparency.

```kotlin
FrostedGlass(
    modifier = Modifier.size(200.dp),
    blurRadius = 20f,
    cornerRadius = 16.dp,
    alpha = 0.15f
) {
    // Your content here
}
```

#### 6. AnimatedGlassBorder
Glass effect with animated borders that continuously change.

```kotlin
AnimatedGlassBorder(
    modifier = Modifier.size(200.dp),
    cornerRadius = 16.dp,
    alpha = 0.2f
) {
    // Your content here
}
```

#### 7. NoiseGlass
Glass effect with noise texture for a more realistic appearance.

```kotlin
NoiseGlass(
    modifier = Modifier.size(200.dp),
    cornerRadius = 16.dp,
    alpha = 0.2f,
    noiseIntensity = 0.15f
) {
    // Your content here
}
```

#### 8. RainbowGlass
Glass effect with animated rainbow borders.

```kotlin
RainbowGlass(
    modifier = Modifier.size(200.dp),
    cornerRadius = 16.dp,
    alpha = 0.2f
) {
    // Your content here
}
```

#### 9. ParticleGlass
Glass effect with animated particle system.

```kotlin
ParticleGlass(
    modifier = Modifier.size(200.dp),
    cornerRadius = 16.dp,
    alpha = 0.2f,
    particleCount = 20
) {
    // Your content here
}
```

#### 10. WaveGlass
Glass effect with animated wave patterns.

```kotlin
WaveGlass(
    modifier = Modifier.size(200.dp),
    cornerRadius = 16.dp,
    alpha = 0.2f,
    waveCount = 3
) {
    // Your content here
}
```

#### 11. MagneticGlass
Glass effect with magnetic field simulation.

```kotlin
MagneticGlass(
    modifier = Modifier.size(200.dp),
    cornerRadius = 16.dp,
    alpha = 0.2f
) {
    // Your content here
}
```

## 🎯 Customization Options

### Common Parameters

- **modifier**: Compose Modifier for layout and styling
- **cornerRadius**: Corner radius for rounded corners
- **alpha**: Transparency level (0.0 = fully transparent, 1.0 = fully opaque)
- **blurRadius**: Blur effect intensity (for components that support it)

### Color Customization

All components use white-based glass effects by default, but you can easily customize colors by modifying the source code or creating wrapper components.

## 🌟 Best Practices

1. **Background Contrast**: Ensure your glass components have sufficient contrast with the background
2. **Alpha Values**: Use alpha values between 0.1 and 0.3 for best glass effect
3. **Corner Radius**: Use consistent corner radius values throughout your app
4. **Performance**: Limit the number of animated glass effects on screen simultaneously
5. **Accessibility**: Ensure text remains readable when using glass effects

## 📱 Platform Support

- ✅ Android
- ✅ iOS
- ✅ Desktop (JVM)
- ✅ Web (when supported)

## 🔧 Implementation Details

### Core Technologies

- **Jetpack Compose Multiplatform**: Cross-platform UI framework
- **Compose Graphics**: Custom drawing and effects
- **Compose Animation**: Smooth animations and transitions
- **Compose Foundation**: Layout and interaction components

### Performance Considerations

- Glass effects use `graphicsLayer` for hardware acceleration
- Animations are optimized with `rememberInfiniteTransition`
- Custom drawing operations are efficient and lightweight

## 📁 Project Structure

```
composeApp/src/commonMain/kotlin/org/example/projecttracker/
├── GlassMorphismComponents.kt    # Basic glass components
├── GlassMorphismUtils.kt         # Advanced effects and utilities
├── GlassMorphismScreen.kt        # Demo screen with examples
├── Navigation.kt                  # Screen navigation
└── App.kt                        # Main application
```

## 🎮 Demo

The project includes a comprehensive demo screen (`GlassMorphismScreen`) that showcases all available effects:

1. **Basic Examples**: Simple glass tiles and cards
2. **Advanced Examples**: Layered effects and grids
3. **Interactive Examples**: Expandable cards and interactive elements
4. **Effects Examples**: All special effects and animations

## 🚀 Running the Project

1. Clone the repository
2. Open in Android Studio or IntelliJ IDEA
3. Run on your target platform (Android, iOS, Desktop)
4. Navigate to the Glass Morphism screen to see all effects

## 🤝 Contributing

Feel free to contribute by:
- Adding new glass morphism effects
- Improving existing effects
- Optimizing performance
- Adding new customization options

## 📄 License

This project is open source and available under the MIT License.

## 🎨 Inspiration

The glass morphism effects are inspired by modern UI design trends and popular design systems like:
- Apple's iOS design language
- Material Design 3
- Modern web design trends
- Contemporary mobile app interfaces

---

**Happy coding with beautiful glass morphism effects! 🎉**
