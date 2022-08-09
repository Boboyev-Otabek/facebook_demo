package com.example.facebook_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook_demo.adapter.FeedAdapter
import com.example.facebook_demo.model.Feed
import com.example.facebook_demo.model.Post
import com.example.facebook_demo.model.Story

class MainActivity : AppCompatActivity() {
   lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    fun initView(){
        recyclerView=findViewById(R.id.recyclerfeed)
        recyclerView.layoutManager=GridLayoutManager(this,1)

        refreshAdapter(getAllFeed())

    }

    fun refreshAdapter(feed:ArrayList<Feed>){
        var adapter=FeedAdapter(this,feed)
        recyclerView.adapter=adapter
    }

    fun getAllFeed():ArrayList<Feed>{
        var stories=ArrayList<Story>()
        stories.add(Story(R.drawable.post_1,R.drawable.user_1,"Boboyev Otabek"))
        stories.add(Story(R.drawable.post_2,R.drawable.user_2,"Boboyev Otabek"))
        stories.add(Story(R.drawable.post_3,R.drawable.user_3,"Boboyev Otabek"))
        stories.add(Story(R.drawable.post_2,R.drawable.user_4,"Boboyev Otabek"))
        stories.add(Story(R.drawable.post_1,R.drawable.user_2,"Boboyev Otabek"))
        stories.add(Story(R.drawable.post_3,R.drawable.user_1,"Boboyev Otabek"))

        var feed=ArrayList<Feed>()

        feed.add(Feed())

        feed.add(Feed(stories))

        feed.add(Feed(Post(R.drawable.user_1,R.drawable.user_3,"Ali")))
        feed.add(Feed(Post(R.drawable.user_1,"Boboyev Otabek",R.drawable.post_1)))
        feed.add(Feed(Post(R.drawable.user_2,"Boboyev Otabek",R.drawable.post_2)))
        feed.add(Feed(Post(R.drawable.user_3,"Boboyev Otabek",R.drawable.post_3)))
        feed.add(Feed(Post(R.drawable.user_4,"Boboyev Otabek",R.drawable.post_1)))
        feed.add(Feed(Post(R.drawable.user_2,"Boboyev Otabek",R.drawable.post_3)))
        feed.add(Feed(Post(R.drawable.user_1,"Boboyev Otabek",R.drawable.post_1)))


        feed.add(Feed(Post(R.drawable.user_3,"Ali",R.drawable.car_1,R.drawable.car_2,R.drawable.car_3,R.drawable.car_4,R.drawable.car_5)))

        return feed
    }
}