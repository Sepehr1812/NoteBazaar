package ir.cafebaazar.notebaazar.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ir.cafebaazar.notebaazar.R
import ir.cafebaazar.notebaazar.data.models.Note
import ir.cafebaazar.notebaazar.databinding.FragmentNoteBinding
import ir.cafebaazar.notebaazar.heipers.DigitHelper
import ir.cafebaazar.notebaazar.viewmodels.NoteViewModel
import saman.zamani.persiandate.PersianDate
import saman.zamani.persiandate.PersianDateFormat
import java.util.*

@AndroidEntryPoint
class NoteFragment : Fragment() {

    private val noteViewModel: NoteViewModel by viewModels()
    private val args: NoteFragmentArgs by navArgs()
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    private var note: Note? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        args.folderId.let {
            if (it != -1)
                noteViewModel.getNoteById(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialViews()
        subscribeLiveData()

        args.noteId.let {
            if (it != -1)
                noteViewModel.getNoteById(it)
        }
    }

    private fun initialViews() {
        binding.apply {
            imageViewNoteBack.setOnClickListener {
                saveNote()
            }

            textViewNoteDate.text = DigitHelper
                .convertDigitsToPersian(PersianDateFormat("j F y").format(PersianDate()))
        }

        // handle back press callback
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                saveNote()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    private fun subscribeLiveData() {
        noteViewModel.getNoteResponse.observe(viewLifecycleOwner) {
            note = it
            val persianDate = PersianDate(it.createTime)
            binding.textViewNoteDate.text = DigitHelper
                .convertDigitsToPersian(PersianDateFormat("j F y").format(persianDate))
        }
    }

    private fun saveNote() {
        noteViewModel.insertNote(
            Note(
                title = binding.editTextNoteTitle.text.toString(),
                content = binding.editTextNoteContent.text.toString(),
                createTime = note?.createTime ?: Date().time,
                folderId = args.folderId.let { if (it != -1) it else null }
            )
        )

        Toast.makeText(requireContext(), R.string.note_saved_successfully, Toast.LENGTH_SHORT)
            .show()
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}