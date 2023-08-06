package com.example.compassofukraine.viewState

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.model.DescriptionTag
import com.example.model.Tag

class DescriptionTagViewState(
    override val tag: DescriptionTag,
    override val listPosition: Int
) : BaseTagViewState(tag, listPosition) {

    @Composable
    override fun display(onClick: (viewState: BaseTagViewState) -> Unit) {

        Button(
            onClick = {
                isSelected.value = !isSelected.value
                onClick(this)
                      },
            modifier = Modifier.padding(4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor =
                if (isSelected.value) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.secondary)
        ) {
            Text(
                text = tag.content,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

    }

}