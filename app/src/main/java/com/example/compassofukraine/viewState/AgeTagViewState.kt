package com.example.compassofukraine.viewState

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compassofukraine.ui.theme.inactiveTag
import com.example.model.AgeTag

class AgeTagViewState(
    override val tag: AgeTag,
    override val listPosition: Int
) : BaseTagViewState(tag, listPosition) {

    @Composable
    override fun display(onClick: (viewState: BaseTagViewState) -> Unit) {
        Button(
            onClick = {
                isSelected.value = !isSelected.value
                onClick(this)
            },
            modifier = Modifier.padding(4.dp).wrapContentSize(),
            shape = RoundedCornerShape(16.dp),
            contentPadding = PaddingValues(4.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor =
                if (isSelected.value) { MaterialTheme.colorScheme.primary } else { inactiveTag }
            )
        ) {
            Text(
                text = tag.content,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}
