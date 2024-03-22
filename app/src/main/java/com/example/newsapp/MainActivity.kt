package com.example.newsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerview)
        val newsImageArray = arrayOf(R.drawable.news4,R.drawable.news1,R.drawable.news5,R.drawable.news2,R.drawable.news6)
        val newsHeadingArray = arrayOf("Number of known moonquakes tripled with discovery in Apollo archive",
            "Apple spent 3 years trying to connect Apple Watch to Android ",
            "Odysseus’ historic moon mission comes to an end, for now",
            "UN adopts first global AI resolution, asks countries to guard human rights and protect personal data",
            "Elon Musk's X takes another step to compete with LinkedIn, adds new job search feature"
            )
        //to set how item inside recycler view are showing and scrolled
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()
        for(index in newsImageArray.indices){
            val news = News(newsHeadingArray[index],newsImageArray[index])
            newsArrayList.add(news)
        }
        myRecyclerView.adapter = MyAdapter(newsArrayList,this)
    }
}