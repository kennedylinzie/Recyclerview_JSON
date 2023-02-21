package com.example.recyclerview_json;

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_json.model.Data
import com.squareup.picasso.Picasso


public class MyAdapter(private val datalist: MutableList<Data>) : RecyclerView.Adapter<MyHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false))
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = datalist[position]

        val userFullNameTextView = holder.itemView.findViewById<TextView>(R.id.user_full_name)
        val avatarImgView = holder.itemView.findViewById<ImageView>(R.id.user_avatar)

        val fullName = "${data.firstName} ${data.lastName}"
        userFullNameTextView.text = fullName

        Picasso.get()
            .load(data.avatar)
            .into(avatarImgView)

        holder.itemView.setOnClickListener{
            //Toast.makeText(context,fullName,Toast.LENGTH_SHORT).show()

            val intent = Intent(context, View_person::class.java)
            intent.putExtra("name_id", fullName)
            intent.putExtra("image_url_id", data.avatar)
            context.startActivity(intent)

        }

    }
}