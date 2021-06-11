package com.example.myapplication.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.models.FeedPost
import kotlinx.android.synthetic.main.layout_feed_list_item.view.*

class FeedRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items : List<FeedPost> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FeedPostViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_feed_list_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when(holder){
                is FeedPostViewHolder ->{
                    holder.bind(items.get(position))
                }
            }
    }

    override fun getItemCount(): Int = items.size
    fun submitList(feedList: List<FeedPost>) {
        items = feedList
    }

    class FeedPostViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
       val feedImage = itemView.iv_feed_image
        val feedTitle = itemView.tv_feed_title
        val  feedAuthor = itemView.tv_feed_author

        fun bind(feedPost: FeedPost){
            feedTitle.text = feedPost.tittle
            feedAuthor.text = feedPost.userName

            // handles errors for glide requests
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context).applyDefaultRequestOptions(requestOptions).load(feedPost.image).into(feedImage)
        }


    }
}