package com.example.mock

import android.content.Context
import com.example.data.R
import com.example.model.ExcursionType
import com.example.model.GeoPosition
import com.example.model.excursion.DetailedExcursion
import com.example.model.excursion.Time
import kotlinx.coroutines.delay

internal class DetailsExcursionFactory(context: Context) {

    private val kharkivExcursionDetailList = listOf(
        DetailedExcursion(
            id = 0,
            name = context.getString(R.string.excursion_1_title),
            distance = 24.0F,
            type = ExcursionType.COMBINE,
            imagesUrl = listOf(
                "https://s.zagranitsa.com/images/articles/4825/870x486/be14d668a1985e0e5f70252b7f248dac.jpg?1477899992",
                "https://beket.com.ua/wp-content/uploads/_k/kharkov-01.jpg",
                "https://farm6.static.flickr.com/5127/5231792925_7d5d7a6958.jpg"
            ),
            imageUrl = "https://s.zagranitsa.com/images/articles/4825/870x486/be14d668a1985e0e5f70252b7f248dac.jpg?1477899992",
            description = context.getString(R.string.excursion_1_description),
            walkingCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            bicycleCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            carCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            carTime = Time(0, 30),
            walkingTime = Time(1, 10),
            bicycleTime = Time(0, 40)
        ),
        DetailedExcursion(
            id = 1,
            name = context.getString(R.string.excursion_2_title),
            distance = 16.2F,
            type = ExcursionType.COMBINE,
            imageUrl = "https://farm6.static.flickr.com/5285/5230091294_eda276d64f.jpg",
            imagesUrl = listOf(
                "https://farm6.static.flickr.com/5285/5230091294_eda276d64f.jpg",
                "https://www.mediaport.ua/sites/default/files/mp/images/Phil/Beketov_dvorets/%D0%9D%D0%BE%D0%B2%D0%BE%D0%B5%20%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%BC%D0%B5%D0%B4%D0%B8%D1%86%D0%B8%D0%BD%D1%81%D0%BA%D0%BE%D0%B3%D0%BE%20%D0%BE%D0%B1%D1%89%D0%B5%D1%81%D1%82%D0%B2%D0%B0%2C%20%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82.jpg",
                "https://farm6.static.flickr.com/5127/5231792925_7d5d7a6958.jpg"
            ),
            description = context.getString(R.string.excursion_1_description),
            walkingCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            bicycleCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            carCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            carTime = Time(0, 30),
            walkingTime = Time(1, 10),
            bicycleTime = Time(0, 40)
        ),
        DetailedExcursion(
            id = 2,
            name = context.getString(R.string.excursion_3_title),
            distance = 29F,
            type = ExcursionType.COMBINE,
            imageUrl = "https://www.ukraine-is.com/wp-content/uploads/2019/07/Horticzya.jpg",
            description = context.getString(R.string.excursion_1_description),
            imagesUrl = listOf(
                "https://www.ukraine-is.com/wp-content/uploads/2019/07/Horticzya.jpg",
                "https://www.mediaport.ua/sites/default/files/mp/images/Phil/Beketov_dvorets/%D0%9D%D0%BE%D0%B2%D0%BE%D0%B5%20%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%BC%D0%B5%D0%B4%D0%B8%D1%86%D0%B8%D0%BD%D1%81%D0%BA%D0%BE%D0%B3%D0%BE%20%D0%BE%D0%B1%D1%89%D0%B5%D1%81%D1%82%D0%B2%D0%B0%2C%20%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82.jpg",
                "https://farm6.static.flickr.com/5127/5231792925_7d5d7a6958.jpg"
            ),
            walkingCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            bicycleCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            carCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            carTime = Time(0, 30),
            walkingTime = Time(1, 10),
            bicycleTime = Time(0, 40)
        ),
        DetailedExcursion(
            id = 3,
            name = context.getString(R.string.excursion_4_title),
            distance = 2.7F,
            type = ExcursionType.COMBINE,
            imageUrl = "https://bigpicture.ru/wp-content/uploads/2017/03/013-1.jpg",
            description = context.getString(R.string.excursion_1_description),
            imagesUrl = listOf(
                "https://bigpicture.ru/wp-content/uploads/2017/03/013-1.jpg",
                "https://www.mediaport.ua/sites/default/files/mp/images/Phil/Beketov_dvorets/%D0%9D%D0%BE%D0%B2%D0%BE%D0%B5%20%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%BC%D0%B5%D0%B4%D0%B8%D1%86%D0%B8%D0%BD%D1%81%D0%BA%D0%BE%D0%B3%D0%BE%20%D0%BE%D0%B1%D1%89%D0%B5%D1%81%D1%82%D0%B2%D0%B0%2C%20%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82.jpg",
                "https://farm6.static.flickr.com/5127/5231792925_7d5d7a6958.jpg"
            ),
            walkingCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            bicycleCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            carCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            carTime = Time(0, 30),
            walkingTime = Time(1, 10),
            bicycleTime = Time(0, 40)
        ),
        DetailedExcursion(
            id = 4,
            name = context.getString(R.string.excursion_5_title),
            distance = 45F,
            type = ExcursionType.COMBINE,
            imageUrl = "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/26/a1/ae/caption.jpg?w=500&h=-1&s=1",
            description = context.getString(R.string.excursion_1_description),
            imagesUrl = listOf(
                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/04/26/a1/ae/caption.jpg?w=500&h=-1&s=1",
                "https://www.mediaport.ua/sites/default/files/mp/images/Phil/Beketov_dvorets/%D0%9D%D0%BE%D0%B2%D0%BE%D0%B5%20%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%BC%D0%B5%D0%B4%D0%B8%D1%86%D0%B8%D0%BD%D1%81%D0%BA%D0%BE%D0%B3%D0%BE%20%D0%BE%D0%B1%D1%89%D0%B5%D1%81%D1%82%D0%B2%D0%B0%2C%20%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82.jpg",
                "https://farm6.static.flickr.com/5127/5231792925_7d5d7a6958.jpg"
            ),
            walkingCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            bicycleCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            carCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            carTime = Time(0, 30),
            walkingTime = Time(1, 10),
            bicycleTime = Time(0, 40)
        ),
        DetailedExcursion(
            id = 5,
            name = context.getString(R.string.excursion_1_title),
            distance = 24.0F,
            type = ExcursionType.COMBINE,
            imageUrl = "https://s.zagranitsa.com/images/articles/4825/870x486/be14d668a1985e0e5f70252b7f248dac.jpg?1477899992",
            description = context.getString(R.string.excursion_1_description),
            imagesUrl = listOf(
                "https://s.zagranitsa.com/images/articles/4825/870x486/be14d668a1985e0e5f70252b7f248dac.jpg?1477899992",
                "https://www.mediaport.ua/sites/default/files/mp/images/Phil/Beketov_dvorets/%D0%9D%D0%BE%D0%B2%D0%BE%D0%B5%20%D0%B7%D0%B4%D0%B0%D0%BD%D0%B8%D0%B5%20%D0%BC%D0%B5%D0%B4%D0%B8%D1%86%D0%B8%D0%BD%D1%81%D0%BA%D0%BE%D0%B3%D0%BE%20%D0%BE%D0%B1%D1%89%D0%B5%D1%81%D1%82%D0%B2%D0%B0%2C%20%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82.jpg",
                "https://farm6.static.flickr.com/5127/5231792925_7d5d7a6958.jpg"
            ),
            walkingCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            bicycleCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            carCoordinates = listOf(
                GeoPosition(50.00457842801801, 36.233972769529544),
                GeoPosition(49.98166256322657, 36.223517256305286),
                GeoPosition(49.9773110901227, 36.24841398734801)
            ),
            carTime = Time(0, 30),
            walkingTime = Time(1, 10),
            bicycleTime = Time(0, 40)
        )
    )

    suspend fun get(id: Int): DetailedExcursion {
        delay(1000)
        return kharkivExcursionDetailList.first { it.id == id }
    }
}
