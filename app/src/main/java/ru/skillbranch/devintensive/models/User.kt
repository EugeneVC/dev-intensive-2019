package ru.skillbranch.devintensive.models

import java.util.*

data class User (
    val id:String,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int = 0,
    var lastVisit:Date? = Date(),
    val isOnline:Boolean = false
){
    constructor(id:String, firstName: String?, lastName:String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id:String) : this(
        id,
        "John",
        "Doe $id"
    )

    init{
        println("It's Alive!!!")
        println("His name is $firstName $lastName")
    }

    fun printMe()=println("""
        id:$id
        firstName:$firstName
        lastName:$lastName
        avatar:$avatar
        rating:$rating
        respect:$respect
        lastVisit:$lastVisit
        isOnline:$isOnline
        """.trimIndent())

    companion object Factory{
        private  var lastid:Int = -1
        fun makeUser(fullName:String?) : User{
            lastid++
            val parts : List<String>? = fullName?.split(" ")

            val firstName = parts?.getOrNull(0)
            val lastName = parts?.getOrNull(0)

            return User(id="$lastid",firstName = firstName, lastName = lastName )
        }
    }
}