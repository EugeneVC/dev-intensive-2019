package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.models.*

import ru.skillbranch.devintensive.models.User
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User("1")
        val user2 = User("2","John","Bow")
        val user3 = User("3","John","Silverhand",avatar = null,lastVisit = Date(),isOnline = true)

        user.printMe()
        user2.printMe()
        user3.printMe()

        println("$user $user2 $user3")
    }

    @Test
    fun test_factory(){
        val user = User.makeUser("Eugene Eremin")

        println(user.printMe())
    }

    @Test
    fun test_abstract_factory(){
        val user = User.makeUser("Eugene Eremin")

        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload =  "any text message", type="text")
        var imageMessage  = BaseMessage.makeMessage(user, Chat("0"),  payload = "https://anyurl.com", type="image",isIncomming = true)

        println(txtMessage.formatMessage())
        println(imageMessage.formatMessage())
    }

    @Test
    fun test_date(){
        val user = User.makeUser("Eugene Eremin")
        println(user.lastVisit?.format())
        println(user.lastVisit?.format("HH:mm"))
    }
}
