package com.example.facebook_demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook_demo.R
import com.example.facebook_demo.model.Story
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(var context: Context, var item: ArrayList<Story>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var type_create = 0
    var type_story = 1

    override fun getItemCount(): Int {
        return item.size
    }

    override fun getItemViewType(position: Int): Int {
        if (iscreate(position)) {
            return type_create
        }
        return type_story
    }

    fun iscreate(position: Int): Boolean {
        return position == 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == type_create) {
            var view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_story_create_view, parent, false)
            return CreateViewHolder(view)
        }
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_story_view, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var story = item[position]

        if (holder is CreateViewHolder) {
        }

        if (holder is StoryViewHolder) {

            var iv_bacground = holder.iv_bacground
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            iv_bacground.setImageResource(story.bacground)
            iv_profile.setImageResource(story.profile)
            tv_fullname.text = story.fullname

        }
    }


    class CreateViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var iv_bacground: ShapeableImageView
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_bacground = view.findViewById(R.id.iv_bacground)
            iv_profile = view.findViewById(R.id.iv_story_profile)
            tv_fullname = view.findViewById(R.id.tv_story_fullname)
        }

    }


}