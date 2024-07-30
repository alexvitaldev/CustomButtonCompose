# CustomButton Component

A reusable Jetpack Compose component for customizable buttons with support for icons, loading states, and primary/secondary styles.

## Features

- Customizable button text and click action.
- Optional icon support with customizable size and tint color.
- Loading indicator support.
- Primary and secondary styles.
- Disabled state handling.

## Requirements

Add the following dependencies to your `build.gradle` file:

```groovy
dependencies {
    // Material3
    implementation("androidx.compose.material3:material3:1.0.0")
}
```

## Usage
To use the CustomButton component, simply call it with the required parameters.

```
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.alexvital.custombutton.CustomButton

@Composable
fun ExampleScreen() {
    Column {
        CustomButton(
            text = "Try Again",
            onClick = { /* Handle click */ },
            icon = ImageVector.vectorResource(id = R.drawable.ic_example),
            secondary = true,
            loading = false
        )
    }
}
