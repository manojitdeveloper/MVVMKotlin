package com.j2travel.assignment.utils

class NetworkState(status: Status, message: String) {

    private var status: Status? = status
    private var msg: String? = message

    companion object{
        val LOADED = NetworkState(Status.SUCCESS, "Success")
        val LOADING = NetworkState(Status.RUNNING, "Loading...")
    }

    enum class Status {
        RUNNING, SUCCESS, FAILED
    }

}