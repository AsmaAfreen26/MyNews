package com.example.mynews

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mynews.modelclasses.Results

class NewsAdapter(val newsList: List<Results>?): RecyclerView.Adapter<NewsAdapter.NewsVH>() {

   inner class NewsVH(v: View) : RecyclerView.ViewHolder(v) {
        val title: TextView = itemView.findViewById(R.id.newsTitle)
       val description: TextView = itemView.findViewById(R.id.newsDescription)
        val image: ImageView = itemView.findViewById(R.id.newsImage)
        val newsPubDate: TextView = itemView.findViewById(R.id.newsPubDate)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH {
        return NewsVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return newsList!!.size
    }

    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        val news = newsList!![position]
        holder.title.text = news.title
//        holder.description.text = news.description
        holder.newsPubDate.text = news.pubDate
        Glide.with(holder.itemView.context).load(news.imageUrl).into(holder.image)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, NewsDetails::class.java)
            intent.putExtra("news", news.description)
            holder.itemView.context.startActivity(intent)
        }
    }
}