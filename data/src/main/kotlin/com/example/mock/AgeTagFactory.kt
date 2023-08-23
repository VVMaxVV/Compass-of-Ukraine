package com.example.mock

import com.example.model.AgeTag

class AgeTagFactory {

    suspend fun get(): List<AgeTag> {
        return listOf(
            AgeTag("0+"),
            AgeTag("6+"),
            AgeTag("12+"),
            AgeTag("16+"),
            AgeTag("18+")
        )
    }
}
