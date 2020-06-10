package com.example.noteapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.database.Notes
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    lateinit var navController: NavController
    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Notes>() {
        override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)

        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val curNoteItem = differ.currentList[position]

        holder.itemView.apply {
            tv_title.text = curNoteItem.title
            tv_content.text = curNoteItem.description
            tv_id.text = curNoteItem.id.toString()

        }
        holder.itemView.setOnClickListener {
            val args = Bundle()
            args.putString("title", curNoteItem.title)
            args.putString("context", curNoteItem.description)
            navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_nav_home_to_nav_editNote, args)
        }


    }

}