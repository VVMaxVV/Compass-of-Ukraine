package com.example.compassofukraine.mapper

import com.example.compassofukraine.viewState.DescriptionTagViewState
import com.example.model.DescriptionTag
import com.example.model.Tag

class TagMapper {

    fun toDescriptionViewState(tag: DescriptionTag, position:Int):DescriptionTagViewState{
        return DescriptionTagViewState(tag, position)
    }

}