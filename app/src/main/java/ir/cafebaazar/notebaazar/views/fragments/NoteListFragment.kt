package ir.cafebaazar.notebaazar.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.cafebaazar.notebaazar.databinding.FragmentNoteListBinding

@AndroidEntryPoint
class NoteListFragment : Fragment() {

    private var _binding: FragmentNoteListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialViews()
    }

    private fun initialViews() {
        binding.fabNoteListPlus.setOnClickListener {
            if (binding.fabNoteListFolder.isOrWillBeHidden) {
                binding.fabNoteListFolder.show()
                binding.fabNoteListNote.show()
            } else {
                binding.fabNoteListFolder.hide()
                binding.fabNoteListNote.hide()
            }
        }

        binding.fabNoteListNote.setOnClickListener {
            findNavController().navigate(NoteListFragmentDirections.actionNoteListFragmentToNoteFragment())
        }

        binding.fabNoteListFolder.setOnClickListener {
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}