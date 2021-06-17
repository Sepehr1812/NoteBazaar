package ir.cafebaazar.notebaazar.data.models.mappers

import ir.cafebaazar.notebaazar.data.models.Folder
import ir.cafebaazar.notebaazar.data.models.entities.FolderEntity

object FolderMapper {

    fun mapToEntity(folder: Folder) = folder.run {
        FolderEntity(
            this.id,
            this.title,
            this.createTime
        )
    }

    fun mapFromEntity(folderEntity: FolderEntity) = folderEntity.run {
        Folder(
            this.id,
            this.title,
            this.createTime
        )
    }
}