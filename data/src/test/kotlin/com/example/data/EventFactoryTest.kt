package com.example.data
/*
import com.example.mock.EventsFactory
import com.example.model.Event
import com.example.model.Location
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

internal class EventFactoryTest {

    private val eventsFactory = EventsFactory()

    @Test
    fun `GIVE location WHEN location is Kharkiv THEN result equal expected`() {
        val expected = listOf(
            Event(
                1,
                "Okean Elzy",
                "Word tour 2024",
                "https://i1.sndcdn.com/artworks-0bq97n0yddKGBwyj-aZyhzg-t500x500.jpg"
            ),
            Event(
                2,
                "95 Kvartal",
                "Stand up",
                "https://yt3.googleusercontent.com/NGRscJTU-FVvX-70K7bBOFn1Gmd4llwyXis23KwSdRDQS8pRB1Cur1-0hKte9HM70AKF9C_vo2w=s900-c-k-c0x00ffffff-no-rj"
            ),
            Event(
                3,
                "Dacha bracha",
                "Concert",
                "https://lvivmozart.com/assets/uploads/person/DahaBraha_db5.jpg"
            ),
            Event(
                4,
                "Kharkiv City Day",
                "Celebration",
                "https://cdnp.flypgs.com/files/Sehirler-long-tail/Kharkiv/kharkiv-sehir.jpg"
            ),
            Event(
                5,
                "Zhadan i sobaky",
                "Concert",
                "https://www.nta.ua/wp-content/uploads/2022/09/na-sajt-1-1.jpg"
            ),
            Event(
                1,
                "Okean Elzy",
                "Word tour 2024",
                "https://i1.sndcdn.com/artworks-0bq97n0yddKGBwyj-aZyhzg-t500x500.jpg"
            ),
            Event(
                2,
                "95 Kvartal",
                "Stand up",
                "https://yt3.googleusercontent.com/NGRscJTU-FVvX-70K7bBOFn1Gmd4llwyXis23KwSdRDQS8pRB1Cur1-0hKte9HM70AKF9C_vo2w=s900-c-k-c0x00ffffff-no-rj"
            ),
            Event(
                3,
                "Dacha bracha",
                "Concert",
                "https://lvivmozart.com/assets/uploads/person/DahaBraha_db5.jpg"
            ),
            Event(
                4,
                "Kharkiv City Day",
                "Celebration",
                "https://cdnp.flypgs.com/files/Sehirler-long-tail/Kharkiv/kharkiv-sehir.jpg"
            ),
            Event(
                5,
                "Zhadan i sobaky",
                "Concert",
                "https://www.nta.ua/wp-content/uploads/2022/09/na-sajt-1-1.jpg"
            )
        )
        CoroutineScope(Dispatchers.IO).launch {
            assertEquals(expected, eventsFactory.get(Location.Kharkiv))
        }
    }

    @Test
    fun `GIVE location WHEN location is Kyiv THEN result equal expected`() {
        val expected = listOf(
            Event(
                2,
                "95 Kvartal",
                "Stand up",
                "https://yt3.googleusercontent.com/NGRscJTU-FVvX-70K7bBOFn1Gmd4llwyXis23KwSdRDQS8pRB1Cur1-0hKte9HM70AKF9C_vo2w=s900-c-k-c0x00ffffff-no-rj"
            ),
            Event(
                1,
                "Okean Elzy",
                "Word tour 2024",
                "https://i1.sndcdn.com/artworks-0bq97n0yddKGBwyj-aZyhzg-t500x500.jpg"
            ),
            Event(
                6,
                "Kyiv City Day",
                "Celebration",
                "https://cdnp.flypgs.com/files/Sehirler-long-tail/Kyiv/kyiv-bag_ms_zl_k-anit.jpg"
            ),
            Event(
                7,
                "Jazz on the roof: Louis Armstrong",
                "Concert",
                "https://hips.hearstapps.com/hmg-prod/images/louis.jpg"
            )
        )
        CoroutineScope(Dispatchers.IO).launch {
            assertEquals(expected, eventsFactory.get(Location.Kyiv))
        }
    }
}
*/