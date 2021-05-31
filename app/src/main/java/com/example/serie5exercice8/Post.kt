package com.example.serie5exercice8

import com.google.gson.annotations.SerializedName

public class Post {
    private var userId: Int = 0
    private var id: Int = 0
    private var title: String =""
    @SerializedName("body")
    private var text: String =""
    public fun getuserId(): Int{
        return userId
    }
    public fun getid(): Int{
        return id
    }
    public fun gettitle(): String{
        return title
    }
    public fun gettext(): String{
        return text
    }
}