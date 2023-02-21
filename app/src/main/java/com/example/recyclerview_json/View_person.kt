package com.example.recyclerview_json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso

class View_person : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_person)
        val photo = findViewById<ImageView>(R.id.single_img)
        var username = findViewById<TextView>(R.id.single_name)

        val item_name = intent.getStringExtra("name_id")
        val img = intent.getStringExtra("image_url_id")
        username.text = item_name

        Picasso.get()
            .load(img)
            .into(photo)
        //Toast.makeText(this,itemId,Toast.LENGTH_SHORT).show()

    }
}