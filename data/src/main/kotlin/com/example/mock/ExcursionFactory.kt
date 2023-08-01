package com.example.mock

import android.content.Context
import com.example.data.R
import com.example.model.Excursion
import com.example.model.ExcursionType
import com.example.model.Location
import kotlinx.coroutines.delay

internal class ExcursionFactory(context: Context) {

    val kharkivExcursionList = listOf(
        Excursion(
            id = 0,
            name = context.getString(R.string.excursion_1_title),
            distance = 24.0F,
            type = ExcursionType.WALKING,
            imageUrl = "https://s.zagranitsa.com/images/articles/4825/870x486/be14d668a1985e0e5f70252b7f248dac.jpg?1477899992",
            description = context.getString(R.string.excursion_1_description)
        ),
        Excursion(
            id = 1,
            name = context.getString(R.string.excursion_2_title),
            distance = 16.2F,
            type = ExcursionType.BICYCLE,
            imageUrl = "https://farm6.static.flickr.com/5285/5230091294_eda276d64f.jpg",
            description = context.getString(R.string.excursion_1_description)
        ),
        Excursion(
            id = 2,
            name = context.getString(R.string.excursion_3_title),
            distance = 29F,
            type = ExcursionType.BICYCLE,
            imageUrl = "https://www.ukraine-is.com/wp-content/uploads/2019/07/Horticzya.jpg",
            description = context.getString(R.string.excursion_1_description),
        ),
        Excursion(
            id = 3,
            name = context.getString(R.string.excursion_4_title),
            distance = 2.7F,
            type = ExcursionType.WALKING,
            imageUrl = "https://bigpicture.ru/wp-content/uploads/2017/03/013-1.jpg",
            description = context.getString(R.string.excursion_1_description),
        ),
        Excursion(
            id = 4,
            name = context.getString(R.string.excursion_5_title),
            distance = 45F,
            type = ExcursionType.CAR,
            imageUrl = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/26/a1/ae/caption.jpg?w=500&h=-1&s=1",
            description = context.getString(R.string.excursion_1_description),
        ),
        Excursion(
            id = 5,
            name = context.getString(R.string.excursion_1_title),
            distance = 24.0F,
            type = ExcursionType.WALKING,
            imageUrl = "https://s.zagranitsa.com/images/articles/4825/870x486/be14d668a1985e0e5f70252b7f248dac.jpg?1477899992",
            description = context.getString(R.string.excursion_1_description),
        ),
    )

    suspend fun get(location: Location): List<Excursion> {
        delay(1000)
        return when (location) {
            is Location.Kharkiv -> kharkivExcursionList
            else -> listOf()
        }
    }
}
