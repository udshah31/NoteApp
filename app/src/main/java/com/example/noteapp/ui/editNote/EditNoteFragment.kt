package com.example.noteapp.ui.editNote

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
import kotlinx.android.synthetic.main.fragment_edit_note.*

class EditNoteFragment : Fragment(R.layout.fragment_edit_note) {
    lateinit var viewModel: HomeViewModel
    lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).homeViewModel
        navController = Navigation.findNavController(view)

        val args = arguments
        val header: String? = args?.getString("title")
        val context: String? = args?.getString("context")

        val editTitle: EditText = view.findViewById(R.id.edit_note_title)
        val editDescription: EditText = view.findViewById(R.id.edit_note_description)

        editTitle.setText(header.toString())
        editDescription.setText(context.toString())

        edit_note_save_btn.setOnClickListener {

            val title = editTitle.text.toString()
            val description = editDescription.text.toString()
            val item = Notes(title, description)

            if (title.isEmpty() || description.isEmpty()) {
                Toast.makeText(activity, "Please enter all the information", Toast.LENGTH_LONG)
                    .show()
            }
                Toast.makeText(activity, "Note information is updated", Toast.LENGTH_LONG).show()
                viewModel.update(item)
                navController.navigate(R.id.action_nav_editNote_to_nav_home)


        }

    }
}