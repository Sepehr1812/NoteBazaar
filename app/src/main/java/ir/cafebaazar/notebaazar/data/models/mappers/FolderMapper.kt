package ir.cafebaazar.notebaazar.data.models.mappers

import ir.cafebaazar.notebaazar.data.models.Folder
import ir.cafebaazar.notebaazar.data.models.entities.FolderEntity

object FolderMapper {

    fun Folder.mapToEntity() = FolderEntity(
        this.id,
        this.title,
        this.createTime
    )

    fun FolderEntity.mapFromEntity() = Folder(
        this.id,
        this.title,
        this.createTime
    )
}