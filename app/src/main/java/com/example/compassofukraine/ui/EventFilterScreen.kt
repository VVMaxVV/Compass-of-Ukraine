@file:OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterialApi::class,
    ExperimentalLayoutApi::class
)

package com.example.compassofukraine.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.compassofukraine.R
import com.example.compassofukraine.viewModel.EventFilterViewModel
import com.example.compassofukraine.viewState.DescriptionTagViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@SuppressLint("MutableCollectionMutableState")
@Composable
fun EventFilterFragment(state: ModalBottomSheetState, scope: CoroutineScope){

    val eventFilterViewModel = koinViewModel<EventFilterViewModel>()
    val descriptionTagList by remember {mutableStateOf(eventFilterViewModel.descriptionTagList.value)}

    Column(
       modifier = Modifier
           .padding(20.dp)
           .fillMaxWidth()
   ) {

        FlowRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            descriptionTagList.forEach { viewState ->
                viewState.display(){

                    eventFilterViewModel.descriptionTagListUpdate(it as DescriptionTagViewState)
                }
            }
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(25.dp),
            onClick = {scope.launch { state.hide() }}
        ) {
            Text(
                text = "Apply",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )
        }
    }
}

@Composable
fun ageFilter(){

    val ageRestrictions = stringArrayResource(id = R.array.ageRestrictions)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        repeat(ageRestrictions.size){index ->
            Card(
                modifier = Modifier
                    .wrapContentHeight(Alignment.CenterVertically)
                    .width(68.dp)
                    .padding(4.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = ageRestrictions[index],
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
fun priceFilter(){

    var price by remember { mutableStateOf(0f..5000f)}

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = if (price.start == 0f) "Free entry" else price.start.toInt().toString())
        Text(text = if (price.endInclusive == 5000f) "5000+" else price.endInclusive.toInt().toString())
    }

    RangeSlider(
        value = price,
        onValueChange = {price = it},
        steps = 9,
        valueRange = 0f..5000f,
        enabled = true,
        onValueChangeFinished = {},
        colors = SliderDefaults.colors(
            activeTrackColor = MaterialTheme.colorScheme.primary,
            inactiveTrackColor = MaterialTheme.colorScheme.secondary
        )
    )
}

@Composable
fun dateFilter(){


    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Date of events: ",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "27.07.2023"
        )

        IconButton(
            onClick = {}
        ){
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_date),
                contentDescription = "button"
            )
        }
    }
}
