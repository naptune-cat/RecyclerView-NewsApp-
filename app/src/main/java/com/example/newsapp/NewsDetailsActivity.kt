package com.example.newsapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_details)

        //take the val coming from intent
        val heading = intent.getStringExtra("heading")
        val image = intent.getIntExtra("image",R.drawable.news6)
        val content = intent.getStringExtra("content")

        //find all the ids in this activity
        val newsHeading= findViewById<TextView>(R.id.heading)
        val newsImg = findViewById<ImageView>(R.id.headingImage)
        val newsContent= findViewById<TextView>(R.id.newscontent)

        //put values/merge both the intent and findViewById vals
        newsHeading.text = heading
        newsImg.setImageResource(image)
        newsContent.text  = content
    }
}