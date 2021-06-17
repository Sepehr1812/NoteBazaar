package ir.cafebaazar.notebaazar.repositories

import ir.cafebaazar.notebaazar.data.db.FolderDao
import ir.cafebaazar.notebaazar.data.models.Folder
import ir.cafebaazar.notebaazar.data.models.mappers.FolderMapper
import javax.inject.Inject

class FolderRepository @Inject constructor(private val folderDao: FolderDao) {
    fun insertNote(folder: Folder) {
        folderDao.insertFolder(FolderMapper.mapToEntity(folder))
    }

    fun getAllNotes() = folderDao.getAllFolders().map { FolderMapper.mapFromEntity(it) }
}