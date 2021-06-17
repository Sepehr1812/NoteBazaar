package ir.cafebaazar.notebaazar.data.models.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String? = null,
    val content: String? = null,
    val createTime: Long? = null,
    val folderId: Int? = null
)
