package com.alexvital.custombutton

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * A customizable button composable that supports icons, loading states, and primary/secondary styles.
 *
 * @param text The text to display inside the button.
 * @param onClick The action to perform when the button is clicked.
 * @param icon An optional icon to display inside the button.
 * @param disabled Whether the button is disabled.
 * @param secondary Whether the button uses the secondary style.
 * @param iconTint The tint color for the icon.
 * @param iconSize The size of the icon.
 * @param loading Whether to show a loading indicator inside the button.
 */
@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    icon: ImageVector? = null,
    disabled: Boolean = false,
    secondary: Boolean = false,
    iconTint: Color = if (!disabled) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
    iconSize: Int = 24,
    loading: Boolean = false
) {
    Button(
        onClick = onClick,
        enabled = !disabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (!secondary) MaterialTheme.colorScheme.primary else Color.Transparent,
            contentColor = if (!secondary) MaterialTheme.colorScheme.onPrimary else Color.Transparent,
            disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
            disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        if (loading) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(iconSize.dp)
            )
        } else {
            Text(
                text = text,
                color = if (!disabled) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f)
            )
            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = iconTint,
                    modifier = Modifier.size(iconSize.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    CustomButton(
        text = "Try Again",
        onClick = {},
        secondary = true
    )
}
