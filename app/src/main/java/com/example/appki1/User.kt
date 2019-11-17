package com.example.appki1

class User(var ajdi:Int, var name:String, var forename:String) {
    override fun toString(): String {
        return name + forename
    }
}