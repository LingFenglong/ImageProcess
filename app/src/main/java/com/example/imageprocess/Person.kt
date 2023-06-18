package com.example.imageprocess

class Person (name: String, sex: Int) {
    var name: String? = ""
        get() = field
        set(value) {
            field = value
        }

    private var sex: Int? = 0
        get() = field
        set(value) {
            field = value
        }

    override fun toString(): String {
        return "Person(aName='$name', aSex=$sex)"
    }
}

fun main() {
    val person = Person("ZhangSan", 1)

    println(person)
//    println(person.sex)
    println(person)

    person.name = "张三"

    println(person)
}