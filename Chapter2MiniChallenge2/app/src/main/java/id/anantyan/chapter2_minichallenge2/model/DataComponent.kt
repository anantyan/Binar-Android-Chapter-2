package id.anantyan.chapter2_minichallenge2.model

data class DataComponent2(
    val imageView: String?,
    val title: String?,
    val location: String?,
    val price: Float?
)

data class DataComponent4(
    val imageView: String?,
    val title: String?,
    val opened: String?,
    val rating: Float?,
    val reviews: String?
)

data class ListItem(
    val resultsComponent2: MutableList<DataComponent2>?,
    val resultsComponent4: MutableList<DataComponent4>?
)

object DataDummy {
    fun dataComponent(): ListItem {
        return ListItem(
            resultsComponent2 = mutableListOf(
                DataComponent2(
                    "",
                    "Pizza Unta",
                    "Grim Caffee & Eatery",
                    8.79f
                ),
                DataComponent2(
                    "",
                    "O'Donut",
                    "Mang Kobul",
                    7.80f
                ),
                DataComponent2(
                    "",
                    "Salad You",
                    "Restaurant Elite",
                    10.50f
                )
            ),
            resultsComponent4 = mutableListOf(
                DataComponent4(
                    "",
                    "Cassetto O'Donut",
                    "Open until 10.30PM",
                    4.9f,
                    "10K"
                ),
                DataComponent4(
                    "",
                    "McDonald",
                    "Jakart Selatan",
                    4.3f,
                    "9.2K"
                ),
            )
        )
    }
}