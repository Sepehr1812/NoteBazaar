package ir.cafebaazar.notebaazar.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.cafebaazar.notebaazar.data.models.entities.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes ORDER BY createTime DESC")
    suspend fun getAllNotes(): List<NoteEntity>

    @Query("SELECT DISTINCT * FROM notes WHERE id = :noteId")
    suspend fun getNoteById(noteId: Int): NoteEntity

    @Query("SELECT * FROM notes WHERE folderId = :folderId ORDER BY createTime DESC")
    suspend fun getNotesByFolderId(folderId: Int): List<NoteEntity>

    @Query("SELECT COUNT(*) FROM notes WHERE folderId = :folderId")
    suspend fun getNoteCountByFolderId(folderId: Int): Int
}