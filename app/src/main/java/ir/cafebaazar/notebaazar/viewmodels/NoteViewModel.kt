package ir.cafebaazar.notebaazar.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.cafebaazar.notebaazar.data.models.Note
import ir.cafebaazar.notebaazar.repositories.NoteRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

    val getNoteResponse = MutableLiveData<Note>()

    fun insertNote(note: Note) {
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    }

    fun getNoteById(noteId: Int) {
        viewModelScope.launch {
            getNoteResponse.value = noteRepository.getNoteById(noteId)
        }
    }
}