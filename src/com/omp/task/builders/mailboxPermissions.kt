package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    Node("MAILBOX_PERMISSION_CHANGES") {
        styleClass = "row"
        node("col-md-2 text-right") {
            label = "select_permissions"
        }
        node("col-md-8") {
            node {
                componetId = "ADD_REMOVE_PERMISSION_SELECTION"
                emberComponent = EmberComponent.ADD_REMOVE_PERMISSIONS
                mandatory()
            }
        }
    }.copyToClipBoard()
}