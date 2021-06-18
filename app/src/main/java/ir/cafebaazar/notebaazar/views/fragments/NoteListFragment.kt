package ir.cafebaazar.notebaazar.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.cafebaazar.notebaazar.databinding.FragmentNoteListBinding
import ir.cafebaazar.notebaazar.viewmodels.NoteListViewModel
import ir.cafebaazar.notebaazar.views.adapters.NoteFolderItemAdapter

@AndroidEntryPoint
class NoteListFragment : Fragment() {

    private val noteListViewModel by viewModels<NoteListViewModel>()
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
        subscribeLiveData()

        noteListViewModel.getNoteAndFolderList()
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

    private fun subscribeLiveData() {
        noteListViewModel.getListResponse.observe(viewLifecycleOwner) {
            println(it)
            binding.recyclerViewNoteList.adapter = NoteFolderItemAdapter(it)
            binding.recyclerViewNoteList.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}