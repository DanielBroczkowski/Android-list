package com.example.appki1

class User(var name:String, var forename:String, var ajdi:Long?=null) {
    override fun toString(): String {
        return name + forename
    }
}