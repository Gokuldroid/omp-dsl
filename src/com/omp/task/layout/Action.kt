package com.omp.task.layout

enum class Action(val action: String) {
    HIDE("hide"),
    DISABLE("disable"),
    SHOW("show");

    override fun toString(): String {
        return action
    }
}