package ir.cafebaazar.notebaazar.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.cafebaazar.notebaazar.data.models.entities.FolderEntity
import ir.cafebaazar.notebaazar.data.models.entities.NoteEntity

@Database(entities = [NoteEntity::class, FolderEntity::class], version = 1)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    abstract fun folderDao(): FolderDao
}