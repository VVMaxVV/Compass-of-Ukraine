package com.example.compassofukraine.viewModel

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compassofukraine.mapper.TagMapper
import com.example.compassofukraine.viewState.AgeTagViewState
import com.example.compassofukraine.viewState.DescriptionTagViewState
import com.example.model.AgeTag
import com.example.model.DescriptionTag
import com.example.useCase.GetAgeTagsUseCase
import com.example.useCase.GetDescriptionTagsUseCase
import kotlinx.coroutines.launch
import java.util.Calendar

@SuppressLint("MutableCollectionMutableState")
class EventFilterViewModel(
    private val getDescriptionTagsUseCase: GetDescriptionTagsUseCase,
    private val getAgeTagsUseCase: GetAgeTagsUseCase

) : ViewModel() {
    private val tagMapper = TagMapper()

    private var _descriptionTagList = mutableStateListOf<DescriptionTagViewState>()
    val descriptionTagList: List<DescriptionTagViewState> get() = _descriptionTagList
    private val _selectedDescriptionTags = mutableStateListOf<DescriptionTag>()

    private var _ageTagList = mutableStateListOf<AgeTagViewState>()
    val ageTagList: List<AgeTagViewState> get() = _ageTagList
    private val _selectedAgeTags = mutableStateListOf<AgeTag>()

    val priceValue = mutableStateOf(0f..5000f)

    val selectedDate = mutableStateOf(Calendar.getInstance().timeInMillis)

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _descriptionTagList = getDescriptionTagsUseCase.execute().mapIndexed {
                    position, descriptionTag ->
                tagMapper.toDescriptionTagViewState(descriptionTag, position)
            }.toMutableStateList()

            _ageTagList = getAgeTagsUseCase.execute().mapIndexed {
                    position, ageTag ->
                tagMapper.toAgeTagViewState(ageTag, position)
            }.toMutableStateList()
        }
    }

    fun descriptionTagListUpdate(changedViewState: DescriptionTagViewState) {
        _descriptionTagList.remove(changedViewState)
        var position = 0

        if (changedViewState.isSelected.value) {
            _selectedDescriptionTags.add(changedViewState.tag)

            for (otherViewState in _descriptionTagList) {
                if (!otherViewState.isSelected.value ||
                    otherViewState.listPosition > changedViewState.listPosition
                ) { break }
                position++
            }
        } else {
            _selectedDescriptionTags.remove(changedViewState.tag)

            position = changedViewState.listPosition

            for (otherViewState in _descriptionTagList) {
                if (!otherViewState.isSelected.value) break

                if (otherViewState.listPosition > changedViewState.listPosition) {
                    position++
                }
            }
        }
        _descriptionTagList.add(position, changedViewState)
    }

    fun ageTagListUpdate(changedViewState: AgeTagViewState) {
        _ageTagList.remove(changedViewState)
        var position = 0

        if (changedViewState.isSelected.value) {
            _selectedAgeTags.add(changedViewState.tag)

            for (otherViewState in _ageTagList) {
                if (!otherViewState.isSelected.value ||
                    otherViewState.listPosition > changedViewState.listPosition
                ) { break }
                position++
            }
        } else {
            _selectedAgeTags.remove(changedViewState.tag)

            position = changedViewState.listPosition

            for (otherViewState in _ageTagList) {
                if (!otherViewState.isSelected.value) break

                if (otherViewState.listPosition > changedViewState.listPosition) {
                    position++
                }
            }
        }
        _ageTagList.add(position, changedViewState)
    }
}
