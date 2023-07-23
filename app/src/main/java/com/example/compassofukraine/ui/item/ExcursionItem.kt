package com.example.compassofukraine.ui.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.compassofukraine.R
import com.example.model.Excursion
import com.example.model.ExcursionType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExcursionItem(excursion: Excursion, onClick: (id: Int) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp, pressedElevation = 1.dp),
        shape = CardDefaults.shape,
        onClick = {
            onClick(excursion.id)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .height(100.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                Modifier
                    .weight(1f)
                    .padding(start = 24.dp, end = 20.dp)
            ) {
                Text(
                    text = excursion.name,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = excursion.distance.toString() + stringResource(id = R.string.km),
                    style = MaterialTheme.typography.labelSmall
                )
                Text(
                    text = getExcursionTypeIcon(excursionType = excursion.type),
                    style = MaterialTheme.typography.labelSmall
                )
            }
            AsyncImage(
                model = excursion.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun getExcursionTypeIcon(excursionType: ExcursionType) =
    when (excursionType) {
        ExcursionType.WALKING -> stringResource(id = R.string.excursion_type_walking)
        ExcursionType.CAR -> stringResource(id = R.string.excursion_type_car)
        ExcursionType.BICYCLE -> stringResource(id = R.string.excursion_type_bicycle)
        ExcursionType.COMBINE -> stringResource(id = R.string.excursion_type_combine)
    }
