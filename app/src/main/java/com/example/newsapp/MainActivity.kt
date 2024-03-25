package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>
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
        val newsContent = arrayOf(getString(R.string.news1),getString(R.string.news2),getString(R.string.news3),getString(R.string.news4),getString(R.string.news6))
        //to set how item inside recycler view are showing and scrolled
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()
        for(index in newsImageArray.indices){
            val news = News(newsHeadingArray[index],newsImageArray[index],newsContent[index])
            newsArrayList.add(news)
        }
        var adapter = MyAdapter(newsArrayList,this)
        myRecyclerView.adapter = adapter
        adapter.setItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
               val intent = Intent(applicationContext,NewsDetailsActivity::class.java)
                intent.putExtra("heading",newsArrayList[position].heading)
                intent.putExtra("image",newsArrayList[position].image)
                intent.putExtra("content",newsArrayList[position].newsContent)
                startActivity(intent)
            }

        })
    }
}