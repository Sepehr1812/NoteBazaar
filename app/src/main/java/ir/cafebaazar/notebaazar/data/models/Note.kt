package ir.cafebaazar.notebaazar.data.models

data class Note(
    val id: Int? = null,
    val title: String? = null,
    val content: String? = null,
    val createTime: Long? = null,
    val folderId: Int? = null
)
