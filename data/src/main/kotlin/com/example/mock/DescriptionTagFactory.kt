package com.example.mock

import com.example.model.DescriptionTag

internal class DescriptionTagFactory {

    suspend fun get(): List<DescriptionTag> {
        return listOf(
            DescriptionTag("Dancing"),
            DescriptionTag("Music"),
            DescriptionTag("Pets friendly")
        )
    }
}
