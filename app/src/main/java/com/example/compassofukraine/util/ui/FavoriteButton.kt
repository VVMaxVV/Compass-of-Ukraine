package com.example.compassofukraine.util.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.compassofukraine.R
import com.example.compassofukraine.ui.theme.CompassOfUkraineTheme

@Composable
fun FavoriteButton(isChecked: Boolean, onClick: (Boolean) -> Unit) {
    IconToggleButton(
        checked = isChecked,
        onCheckedChange = { onClick(it) },
        colors = IconButtonDefaults.filledIconToggleButtonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            checkedContainerColor = MaterialTheme.colorScheme.primary,
            checkedContentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_favorite), contentDescription = null)
    }
}

@Preview
@Composable
fun FavoriteButtonPreview() {
    CompassOfUkraineTheme {
        FavoriteButton(false) { }
    }
}
