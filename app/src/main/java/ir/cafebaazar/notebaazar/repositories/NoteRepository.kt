package ir.cafebaazar.notebaazar.repositories

import ir.cafebaazar.notebaazar.data.db.NoteDao
import ir.cafebaazar.notebaazar.data.models.Note
import ir.cafebaazar.notebaazar.data.models.mappers.NoteMapper
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun insertNote(note: Note) {
        noteDao.insertNote(NoteMapper.mapToEntity(note))
    }

    suspend fun getAllNotes() = noteDao.getAllNotes().map { NoteMapper.mapFromEntity(it) }

    suspend fun getNoteById(noteId: Int) = NoteMapper.mapFromEntity(noteDao.getNoteById(noteId))

    suspend fun getNotesByFolderId(folderId: Int) =
        noteDao.getNotesByFolderId(folderId).map { NoteMapper.mapFromEntity(it) }

    suspend fun getNoteCountByFolderId(folderId: Int) = noteDao.getNoteCountByFolderId(folderId)
}