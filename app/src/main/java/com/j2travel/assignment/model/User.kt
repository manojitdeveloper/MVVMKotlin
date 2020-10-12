package com.j2travel.assignment.model

import java.io.Serializable

data class User  (

    var id : Int,
    var blogId : Int,
    var createdAt : String,
    var name : String,
    var avatar : String,
    var lastname : String,
    var city : String,
    var designation : String,
    var about : String

) : Serializable