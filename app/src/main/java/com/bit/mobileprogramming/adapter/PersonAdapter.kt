package com.bit.mobileprogramming.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bit.mobileprogramming.R
import com.bit.mobileprogramming.model.Person
class PersonAdapter(
    private val context: Context,
    private val personList: List<Person>
) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText = itemView.findViewById<TextView>(R.id.nameText)
        val addressText = itemView.findViewById<TextView>(R.id.addressText)
        val phoneText = itemView.findViewById<TextView>(R.id.txtPhone)
        val websiteText = itemView.findViewById<TextView>(R.id.txtWebsite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = personList[position]
        holder.nameText.text = person.name
        holder.addressText.text = person.address
        holder.phoneText.text =  person.phone
        holder.websiteText.text = person.website

        holder.itemView.setOnClickListener {
            val shareText = "Name: ${person.name}\nAddress: ${person.address}"
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, shareText)
            context.startActivity(Intent.createChooser(intent, "Share via"))
        }

//        holder.itemView.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:${person.phone}")
//            context.startActivity(intent)
//        }

//        holder.itemView.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse(person.website)
//            context.startActivity(intent)
//        }

    }

    override fun getItemCount() = personList.size
}
