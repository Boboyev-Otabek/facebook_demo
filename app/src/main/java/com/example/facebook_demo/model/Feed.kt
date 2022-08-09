package com.example.facebook_demo.model

class Feed {
    //var isProfile:Boolean=false
    var isHeader: Boolean = false
    var post: Post? = null
    var stories = ArrayList<Story>()




    constructor() {
        this.isHeader = true
       // this.isProfile=false
    }

    constructor(post: Post) {
        this.post = post
        this.isHeader = false
       // this.isProfile=true
    }

    constructor(stories: ArrayList<Story>) {
        this.stories = stories
        this.isHeader = false
       // this.isProfile=false
    }

}