package com.example.compassofukraine.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compassofukraine.mapper.TagMapper
import com.example.compassofukraine.viewState.DescriptionTagViewState
import com.example.model.DescriptionTag
import com.example.useCase.GetDescriptionTagsUseCase
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication.Companion.init
import java.util.LinkedList

@SuppressLint("MutableCollectionMutableState")
class EventFilterViewModel(
    private val getDescriptionTagsUseCase: GetDescriptionTagsUseCase,

): ViewModel() {
    private val tagMapper = TagMapper()

    private val _descriptionTagList = mutableStateOf<LinkedList<DescriptionTagViewState>>(LinkedList())
    val descriptionTagList: State<LinkedList<DescriptionTagViewState>> get() = _descriptionTagList

    private val _selectedDescriptionTags = mutableStateOf<MutableList<DescriptionTag>>(mutableListOf())
    val selectedDescriptionTags: State<MutableList<DescriptionTag>> get() = _selectedDescriptionTags

    init {
        fetchData()
    }

    fun fetchData(){
        viewModelScope.launch {
            _descriptionTagList.value = LinkedList(getDescriptionTagsUseCase.execute().mapIndexed {
                    position, descriptionTag ->
                tagMapper.toDescriptionViewState(descriptionTag, position)
            })
        }
    }

    fun descriptionTagListUpdate(viewState: DescriptionTagViewState){

        val list = _descriptionTagList.value

        list.reverse()

        _descriptionTagList.value = list

        //for (tag in _descriptionTagList.value)  Log.d("tag", tag.tag.content.toString())
    }
}