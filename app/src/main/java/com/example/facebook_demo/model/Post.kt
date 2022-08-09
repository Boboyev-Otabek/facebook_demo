package com.example.facebook_demo.model

class Post {
    var profile:Int=0
    var profile_1:Int=0
    var fullname:String=""
    var photo:Int=0

    var photo_1:Int=0
    var photo_2:Int=0
    var photo_3:Int=0
    var photo_4:Int=0
    var photo_5:Int=0

    constructor(profile:Int=0,fullname:String="",photo:Int=0){
        this.profile=profile
        this.fullname=fullname
        this.photo=photo
    }

    constructor(profile:Int=0,profile_1:Int=0,fullname:String=""){
        this.profile=profile
        this.profile_1=profile_1
        this.fullname=fullname

    }

    constructor(profile:Int=0,fullname:String="",photo_1:Int=0,photo_2:Int=0,photo_3:Int=0,photo_4:Int=0,photo_5:Int=0){
        this.profile=profile
        this.fullname=fullname
        this.photo_1=photo_1
        this.photo_2=photo_2
        this.photo_3=photo_3
        this.photo_4=photo_4
        this.photo_5=photo_5
    }



}