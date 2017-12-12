package com.omp.task.layout

enum class Action(val action: String) {
    HIDE("hide"),
    SHOW("show");

    override fun toString(): String {
        return action
    }
}