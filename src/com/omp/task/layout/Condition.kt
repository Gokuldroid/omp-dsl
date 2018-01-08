package com.omp.task.layout

enum class Condition(val condition: String) {
    EQUAL("=="),
    NOT_EQUAL("!=");

    override fun toString(): String {
        return condition
    }
}