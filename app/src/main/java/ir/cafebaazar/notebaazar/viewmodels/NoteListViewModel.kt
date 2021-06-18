package ir.cafebaazar.notebaazar.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.cafebaazar.notebaazar.data.models.NoteFolderItem
import ir.cafebaazar.notebaazar.repositories.FolderRepository
import ir.cafebaazar.notebaazar.repositories.NoteRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    private val folderRepository: FolderRepository
) : ViewModel() {

    val getListResponse = MutableLiveData<List<NoteFolderItem>>()

    fun getNoteAndFolderList() {
        val list = mutableListOf<NoteFolderItem>()

        viewModelScope.launch {
            list.addAll(noteRepository.getAllNotes())
            list.addAll(folderRepository.getAllFolders())
            getListResponse.value = list.sortedWith(compareByDescending { it.createTime })
        }
    }

    fun getNotesInFolder(folderId: Int) {
        viewModelScope.launch {
            getListResponse.value = noteRepository.getNotesByFolderId(folderId)
        }
    }
}