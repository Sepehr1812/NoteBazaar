package ir.cafebaazar.notebaazar.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.cafebaazar.notebaazar.data.models.entities.FolderEntity

@Dao
interface FolderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFolder(folderEntity: FolderEntity)

    @Query("SELECT * FROM folders ORDER BY createTime DESC")
    suspend fun getAllFolders(): List<FolderEntity>
}