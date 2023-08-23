package com.example.compassofukraine.mapper

import com.example.compassofukraine.viewState.AgeTagViewState
import com.example.compassofukraine.viewState.DescriptionTagViewState
import com.example.model.AgeTag
import com.example.model.DescriptionTag

class TagMapper {

    fun toDescriptionTagViewState(tag: DescriptionTag, position: Int): DescriptionTagViewState {
        return DescriptionTagViewState(tag, position)
    }

    fun toAgeTagViewState(tag: AgeTag, position: Int): AgeTagViewState {
        return AgeTagViewState(tag, position)
    }
}
