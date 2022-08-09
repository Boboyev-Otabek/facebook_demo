package com.example.facebook_demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook_demo.R
import com.example.facebook_demo.model.Feed
import com.example.facebook_demo.model.Story
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(var context: Context, var item: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var type_head = 0
    var type_story = 1
    var type_post = 2
    var type_profile=3
    var type_post_5=4

    override fun getItemViewType(position: Int): Int {
        if (item[position].isHeader) return type_head
        else if (item[position].stories.size > 0) return type_story
        else if (item[position].post!!.profile_1>0 ) return type_profile
        else if (item[position].post!!.photo_1>0 ) return type_post_5
        return type_post
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == type_head) {
            var view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_head, parent, false)
            return HeadViewHolder(view)
        } else if (viewType == type_story) {
            var view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_feed_story, parent, false)
            return StriesViewHolder(context, view)
        }

        else if (viewType == type_profile) {
            var view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_feed_post_profile, parent, false)
            return ProfileViewHolder(view)
        }
        else if (viewType == type_post_5) {
            var view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_feed_post_5, parent, false)
            return Post5ViewHolder(view)}

        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_post, parent, false)
        return PostViewHolder(view)


    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var feed = item[position]

        if (holder is HeadViewHolder) {
        }

        if (holder is StriesViewHolder) {
            var recyclerView = holder.recyclerViewStory
            refreshAdapter(recyclerView, feed.stories)
        }

        if (holder is PostViewHolder) {
            var iv_profile = holder.iv_profile
            var iv_photo = holder.iv_photo
            var tv_fullname = holder.tv_fullname

            iv_profile.setImageResource(feed.post!!.profile)
            iv_photo.setImageResource(feed.post!!.photo)
            tv_fullname.text = feed.post!!.fullname
        }


        if(holder is ProfileViewHolder){
            var profile = holder.profile
            var profile_1 = holder.profile_1
            var fullname = holder.fullname

            profile.setImageResource(feed.post!!.profile)
            profile_1.setImageResource(feed.post!!.profile_1)
            fullname.text=feed.post!!.fullname
        }

        if(holder is Post5ViewHolder){

            var profile =holder.profile
            var fullname =holder.fullname
            var photo_1=holder.photo_1
            var photo_2=holder.photo_2
            var photo_3=holder.photo_3
            var photo_4=holder.photo_4
            var photo_5=holder.photo_5


            profile.setImageResource(feed.post!!.profile)
            fullname.text=feed.post!!.fullname
            photo_1.setImageResource(feed.post!!.photo_1)
            photo_2.setImageResource(feed.post!!.photo_2)
            photo_3.setImageResource(feed.post!!.photo_3)
            photo_4.setImageResource(feed.post!!.photo_4)
            photo_5.setImageResource(feed.post!!.photo_5)


        }



    }

    fun refreshAdapter(recycler: RecyclerView, stories: ArrayList<Story>) {

        var adapter = StoryAdapter(context, stories)
        recycler.adapter = adapter
    }


    class HeadViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

    class StriesViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerViewStory: RecyclerView

        init {
            recyclerViewStory = view.findViewById(R.id.recyclerstory)
            recyclerViewStory.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var iv_profile: ShapeableImageView
        var iv_photo: ImageView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_post_profile)
            iv_photo = view.findViewById(R.id.iv_post_photo)
            tv_fullname = view.findViewById(R.id.tv_post_fullname)
        }

    }


    class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var profile: ShapeableImageView
        var profile_1: ShapeableImageView
        var fullname: TextView

        init {
            profile = view.findViewById(R.id.profile)
            profile_1 = view.findViewById(R.id.profile_1)
            fullname = view.findViewById(R.id.fullname)
        }

    }

    class Post5ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        var profile: ShapeableImageView
        var fullname: TextView
        var photo_1:ShapeableImageView
        var photo_2:ShapeableImageView
        var photo_3:ShapeableImageView
        var photo_4:ShapeableImageView
        var photo_5:ShapeableImageView

        init {
            profile=view.findViewById(R.id.iv_post5_profile)
            fullname=view.findViewById(R.id.tv_post5_fullname)
            photo_1=view.findViewById(R.id.iv_post5_photo_1)
            photo_2=view.findViewById(R.id.iv_post5_photo_2)
            photo_3=view.findViewById(R.id.iv_post5_photo_3)
            photo_4=view.findViewById(R.id.iv_post5_photo_4)
            photo_5=view.findViewById(R.id.iv_post5_photo_5)
        }


    }


}