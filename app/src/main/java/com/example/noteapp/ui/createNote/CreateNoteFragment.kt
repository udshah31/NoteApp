package com.example.noteapp.ui.createNote

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.noteapp.MainActivity
import com.example.noteapp.R
import com.example.noteapp.database.Notes
import com.example.noteapp.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.create_note_fragment.*

class CreateNoteFragment : Fragment(R.layout.create_note_fragment) {
    lateinit var viewModel: HomeViewModel
    lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).homeViewModel
        navController = Navigation.findNavController(view)

        val addTitle: EditText = view.findViewById(R.id.note_title)
        val addDescription: EditText = view.findViewById(R.id.note_description)

        note_save_btn.setOnClickListener {
            val title = addTitle.text.toString()
            val description = addDescription.text.toString()
            val item = Notes(title, description)

            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(context, "Please enter all the information", Toast.LENGTH_LONG)
                    .show()

            } else {
                Toast.makeText(context, "Note is created", Toast.LENGTH_LONG).show()
                viewModel.insert(item)
                navController.navigate(R.id.action_createNoteFragment_to_nav_home)
            }


        }


    }


}