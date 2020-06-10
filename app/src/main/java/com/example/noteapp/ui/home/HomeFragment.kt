package com.example.noteapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.noteapp.MainActivity
import com.example.noteapp.R
import com.example.noteapp.database.AppDatabase
import com.example.noteapp.database.Notes
import com.example.noteapp.repositories.NoteRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    lateinit var navController: NavController
    lateinit var viewModel: HomeViewModel
    lateinit var adapter: NoteAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).homeViewModel
        navController = Navigation.findNavController(view)

        setRecycleView()

        viewModel.getAllNotes().observe(requireActivity(), Observer { Notes ->
            adapter.differ.submitList(Notes)
            adapter.notifyDataSetChanged()
        })

        add_note.setOnClickListener {
            navController.navigate(R.id.action_nav_home_to_createNoteFragment)
        }

    }

    private fun setRecycleView() {
        adapter = NoteAdapter()
        note_list.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        note_list.adapter = adapter

    }


}