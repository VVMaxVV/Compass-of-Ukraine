package com.example.mock

import com.example.model.Excursion
import com.example.model.ExcursionType
import com.example.model.Location
import kotlinx.coroutines.delay

class ExcursionFactory {
    suspend fun get(location: Location): List<Excursion> {
        delay(1000)
        return when (location) {
            is Location.Kharkiv -> listOf(
                Excursion(
                    id = 0,
                    name = "Unexplored Kyiv",
                    distance = 24.0F,
                    type = ExcursionType.WALKING,
                    imageUrl = "https://s.zagranitsa.com/images/articles/4825/870x486/be14d668a1985e0e5f70252b7f248dac.jpg?1477899992",
                    description = "    Kharkiv City Day is an annual celebration that pays tribute to the vibrant and historic city of Kharkiv, Ukraine. This joyous occasion brings together locals and visitors from around the world to commemorate the rich cultural heritage, achievements, and progress of Kharkiv.\n" +
                        "    During the festivities, the streets come alive with an array of colorful decorations, captivating performances, and lively music that resonates throughout the city. The event showcases the city's diverse artistic talent, including captivating dance troupes, captivating musical performances, and awe-inspiring theatrical shows."
                ),
                Excursion(
                    id = 0,
                    name = "Beketov's houses",
                    distance = 16.2F,
                    type = ExcursionType.BICYCLE,
                    imageUrl = "https://farm6.static.flickr.com/5285/5230091294_eda276d64f.jpg",
                    description = "    Kharkiv City Day is an annual celebration that pays tribute to the vibrant and historic city of Kharkiv, Ukraine. This joyous occasion brings together locals and visitors from around the world to commemorate the rich cultural heritage, achievements, and progress of Kharkiv.\n" +
                        "    During the festivities, the streets come alive with an array of colorful decorations, captivating performances, and lively music that resonates throughout the city. The event showcases the city's diverse artistic talent, including captivating dance troupes, captivating musical performances, and awe-inspiring theatrical shows."

                ),
                Excursion(
                    id = 0,
                    name = "Cossack places",
                    distance = 29F,
                    type = ExcursionType.BICYCLE,
                    imageUrl = "https://www.ukraine-is.com/wp-content/uploads/2019/07/Horticzya.jpg",
                    description = "    Kharkiv City Day is an annual celebration that pays tribute to the vibrant and historic city of Kharkiv, Ukraine. This joyous occasion brings together locals and visitors from around the world to commemorate the rich cultural heritage, achievements, and progress of Kharkiv.\n" +
                        "    During the festivities, the streets come alive with an array of colorful decorations, captivating performances, and lively music that resonates throughout the city. The event showcases the city's diverse artistic talent, including captivating dance troupes, captivating musical performances, and awe-inspiring theatrical shows."

                ),
                Excursion(
                    id = 0,
                    name = "Futuristic Kyiv",
                    distance = 2.7F,
                    type = ExcursionType.WALKING,
                    imageUrl = "https://bigpicture.ru/wp-content/uploads/2017/03/013-1.jpg",
                    description = "    Kharkiv City Day is an annual celebration that pays tribute to the vibrant and historic city of Kharkiv, Ukraine. This joyous occasion brings together locals and visitors from around the world to commemorate the rich cultural heritage, achievements, and progress of Kharkiv.\n" +
                        "    During the festivities, the streets come alive with an array of colorful decorations, captivating performances, and lively music that resonates throughout the city. The event showcases the city's diverse artistic talent, including captivating dance troupes, captivating musical performances, and awe-inspiring theatrical shows."

                ),
                Excursion(
                    id = 0,
                    name = "Ancient Ukraine",
                    distance = 45F,
                    type = ExcursionType.CAR,
                    imageUrl = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/26/a1/ae/caption.jpg?w=500&h=-1&s=1",
                    description = "    Kharkiv City Day is an annual celebration that pays tribute to the vibrant and historic city of Kharkiv, Ukraine. This joyous occasion brings together locals and visitors from around the world to commemorate the rich cultural heritage, achievements, and progress of Kharkiv.\n" +
                        "    During the festivities, the streets come alive with an array of colorful decorations, captivating performances, and lively music that resonates throughout the city. The event showcases the city's diverse artistic talent, including captivating dance troupes, captivating musical performances, and awe-inspiring theatrical shows."

                ),
                Excursion(
                    id = 0,
                    name = "Unexplored Kyiv",
                    distance = 24.0F,
                    type = ExcursionType.WALKING,
                    imageUrl = "https://s.zagranitsa.com/images/articles/4825/870x486/be14d668a1985e0e5f70252b7f248dac.jpg?1477899992",
                    description = "    Kharkiv City Day is an annual celebration that pays tribute to the vibrant and historic city of Kharkiv, Ukraine. This joyous occasion brings together locals and visitors from around the world to commemorate the rich cultural heritage, achievements, and progress of Kharkiv.\n" +
                        "    During the festivities, the streets come alive with an array of colorful decorations, captivating performances, and lively music that resonates throughout the city. The event showcases the city's diverse artistic talent, including captivating dance troupes, captivating musical performances, and awe-inspiring theatrical shows."
                )
            )
            else -> listOf()
        }
    }
}
