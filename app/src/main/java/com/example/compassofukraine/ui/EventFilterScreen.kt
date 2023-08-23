@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class,
    ExperimentalLayoutApi::class
)

package com.example.compassofukraine.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.compassofukraine.R
import com.example.compassofukraine.ui.theme.inactiveTag
import com.example.compassofukraine.viewModel.EventFilterViewModel
import com.example.compassofukraine.viewState.AgeTagViewState
import com.example.compassofukraine.viewState.DescriptionTagViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@SuppressLint("MutableCollectionMutableState")
@Composable
fun EventFilterScreen(state: ModalBottomSheetState, scope: CoroutineScope) {
    val eventFilterViewModel = koinViewModel<EventFilterViewModel>()
    val descriptionTagList by remember { mutableStateOf(eventFilterViewModel.descriptionTagList) }
    val ageTagList by remember { mutableStateOf(eventFilterViewModel.ageTagList) }
    val priceValue by remember { mutableStateOf(eventFilterViewModel.priceValue) }
    val selectedDate by remember { mutableStateOf(eventFilterViewModel.selectedDate) }

    var dataPickerDialogState by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    val dateFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.ROOT)

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        if (dataPickerDialogState) {
            DatePickerDialog(
                onDismissRequest = { dataPickerDialogState = false },
                dismissButton = {
                    TextButton(
                        onClick = { dataPickerDialogState = false }
                    ) {
                        Text(text = "Cancel")
                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            dataPickerDialogState = false
                            selectedDate.value = datePickerState.selectedDateMillis!!
                        }
                    ) {
                        Text(text = "Confirm")
                    }
                },
                colors = DatePickerDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            ) {
                DatePicker(
                    state = datePickerState
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Date of events: ",
                style = MaterialTheme.typography.headlineMedium
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dateFormatter.format(Date(selectedDate.value)),
                    style = MaterialTheme.typography.labelMedium
                )

                IconButton(
                    onClick = { dataPickerDialogState = true }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_date),
                        contentDescription = "ic_date"
                    )
                }
            }
        } // Date

        divider()

        Box {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = if (priceValue.value.start == 0f) { "Free entry" } else { priceValue.value.start.toInt().toString() },
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = if (priceValue.value.endInclusive == 5000f) { "5000+" } else { priceValue.value.endInclusive.toInt().toString() },
                    style = MaterialTheme.typography.labelMedium
                )
            }

            RangeSlider(
                modifier = Modifier.padding(top = 8.dp),
                value = priceValue.value,
                onValueChange = { priceValue.value = it },
                steps = 9,
                valueRange = 0f..5000f,
                enabled = true,
                onValueChangeFinished = { },
                colors = SliderDefaults.colors(
                    activeTrackColor = MaterialTheme.colorScheme.primary,
                    inactiveTrackColor = inactiveTag
                )
            )
        } // Price

        divider()

        Column {
            Text(
                text = "Age restrictions",
                style = MaterialTheme.typography.headlineMedium
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                ageTagList.forEach { viewState ->
                    viewState.display() {
                        eventFilterViewModel.ageTagListUpdate(it as AgeTagViewState)
                    }
                }
            }
        } // Age tags

        divider()

        Column {
            Text(
                text = "Tags",
                style = MaterialTheme.typography.headlineMedium
            )

            FlowRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                descriptionTagList.forEach { viewState ->
                    viewState.display() {
                        eventFilterViewModel.descriptionTagListUpdate(it as DescriptionTagViewState)
                    }
                }
            }
        } // Description tags

        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            onClick = { scope.launch { state.hide() } }
        ) {
            Text(
                text = "Apply",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Composable
fun divider() {
    Divider(
        modifier = Modifier
            .clip(shape = CircleShape)
            .padding(top = 8.dp, bottom = 4.dp),
        thickness = 4.dp,
        color = inactiveTag
    )
}
