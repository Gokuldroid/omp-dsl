package com.omp.task.layout

enum class Action(val action: String) {
    HIDE("hide"),
    DISABLE("disable"),
    SHOW("show"),
    VIEW_ASSIGN_LICENSE("view_assign_license"),
    SHOW_TICK("show_auto_reply_tick"),

    VIEW_LICENSE_OPTIONS("view_license_options");

    override fun toString(): String {
        return action
    }
}