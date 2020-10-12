package com.j2travel.assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.j2travel.assignment.R
import com.j2travel.assignment.model.Articles
import java.text.SimpleDateFormat
import java.util.*

class ArticleListAdapter(private val articleList : List<Articles>) : RecyclerView.Adapter<ArticleListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val user_image = itemView.findViewById<ImageView>(R.id.user_image)
        val user_name = itemView.findViewById<TextView>(R.id.user_name)
        val user_designation = itemView.findViewById<TextView>(R.id.user_designation)
        val createdAt = itemView.findViewById<TextView>(R.id.createdAt)
        val article_image = itemView.findViewById<ImageView>(R.id.article_image)
        val article_content = itemView.findViewById<TextView>(R.id.article_content)
        val like = itemView.findViewById<TextView>(R.id.like)
        val comments = itemView.findViewById<TextView>(R.id.comments)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.adapter_article_list, parent, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.article_content?.text = articleList[position].content
        holder.user_name?.text = articleList[position].user[0].name + " " +articleList[position].user[0].lastname
        holder.user_designation?.text = articleList[position].user[0].designation

        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"))
        val time: Long = sdf.parse(articleList[position].createdAt).getTime()

        holder.createdAt?.text = getTimeAgo(time)
        holder.like?.text = "" + articleList[position].likes + " Likes"
        holder.comments?.text = "" + articleList[position].comments + " Comments"

        Glide.with(holder.user_image.context)
            .load(articleList[position].user[0].avatar)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(holder.user_image)

        Glide.with(holder.article_image.context)
            .load(articleList[position].media[0].image)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(holder.article_image)

    }

    private val SECOND_MILLIS = 1000
    private val MINUTE_MILLIS = 60 * SECOND_MILLIS
    private val HOUR_MILLIS = 60 * MINUTE_MILLIS
    private val DAY_MILLIS = 24 * HOUR_MILLIS

    fun getTimeAgo(time: Long): String? {
        var time = time
        if (time < 1000000000000L) {
            time *= 1000
        }
        val now = System.currentTimeMillis()
        if (time > now || time <= 0) {
            return null
        }
        val diff = now - time
        return if (diff < MINUTE_MILLIS) {
            "Just now"
        } else if (diff < 2 * MINUTE_MILLIS) {
            "1 minute"
        } else if (diff < 50 * MINUTE_MILLIS) {
            "" + diff.div(MINUTE_MILLIS) + " minutes"
        } else if (diff < 90 * MINUTE_MILLIS) {
            "1 hour"
        } else if (diff < 24 * HOUR_MILLIS) {
            "" + diff.div(HOUR_MILLIS)+ " hours"
        } else if (diff < 48 * HOUR_MILLIS) {
            "Yesterday"
        } else {
            "" + diff.div(DAY_MILLIS) + " days"
        }
    }

}
