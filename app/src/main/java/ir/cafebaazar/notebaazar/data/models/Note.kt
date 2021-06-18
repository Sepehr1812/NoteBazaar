package ir.cafebaazar.notebaazar.data.models

class Note(
    id: Int? = null,
    title: String? = null,
    val content: String? = null,
    createTime: Long? = null,
    val folderId: Int? = null
) : NoteFolderItem(id, title, createTime)
