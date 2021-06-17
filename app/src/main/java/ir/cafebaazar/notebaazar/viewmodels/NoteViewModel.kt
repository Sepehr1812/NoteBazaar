package ir.cafebaazar.notebaazar.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.cafebaazar.notebaazar.data.models.Note
import ir.cafebaazar.notebaazar.repositories.NoteRepository
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteRepository: NoteRepository) : ViewModel() {

    fun insertNote(note: Note) {
        noteRepository.insertNote(note)
    }
}