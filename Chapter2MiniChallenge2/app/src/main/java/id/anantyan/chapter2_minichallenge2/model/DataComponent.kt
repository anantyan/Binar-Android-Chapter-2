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
