package ir.cafebaazar.notebaazar.data.models.mappers

import ir.cafebaazar.notebaazar.data.models.Note
import ir.cafebaazar.notebaazar.data.models.entities.NoteEntity

object NoteMapper {

    fun mapToEntity(note: Note) = note.run {
        NoteEntity(
            this.id,
            this.title,
            this.content,
            this.createTime,
            this.folderId
        )
    }

    fun mapFromEntity(noteEntity: NoteEntity) = noteEntity.run {
        Note(
            this.id,
            this.title,
            this.content,
            this.createTime,
            this.folderId
        )
    }
}