package com.j2travel.assignment.model

import java.io.Serializable

data class Articles (

    var id : Int,
    var createdAt : String,
    var content : String,
    var comments : Int,
    var likes : Int,
    var media : List<Media>,
    var user : List<User>

) : Serializable