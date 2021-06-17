package ir.cafebaazar.notebaazar.data.models.mappers

import ir.cafebaazar.notebaazar.data.models.Note
import ir.cafebaazar.notebaazar.data.models.entities.NoteEntity

object NoteMapper {

    fun Note.mapToEntity() = NoteEntity(
        this.id,
        this.title,
        this.content,
        this.createTime,
        this.folderId
    )

    fun NoteEntity.mapFromEntity() = Note(
        this.id,
        this.title,
        this.content,
        this.createTime,
        this.folderId
    )
}