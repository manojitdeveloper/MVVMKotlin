package com.j2travel.assignment.model

import java.io.Serializable

data class Media (

    var id : Int,
    var blogId : Int,
    var createdAt : String,
    var image : String,
    var title : String,
    var url : String

) : Serializable