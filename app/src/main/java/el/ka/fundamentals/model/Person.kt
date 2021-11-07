package el.ka.fundamentals.model

import java.io.Serializable

data class Person(
    val name: String,
    val age: Int,
    val country: String
): Serializable {
    fun getString(): String {
        return "$name is $age years old and lives in $country"
    }
}
