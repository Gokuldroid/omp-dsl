package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    Node("MAILBOX_PERMISSION_CHANGES") {
        styleClass = "row"
        node("col-md-12") {
            node {
                styleClass= "o365-ml-50"
                label = "select_permissions"
                componetId = "ADD_REMOVE_PERMISSION_SELECTION"
                emberComponent = EmberComponent.ADD_REMOVE_PERMISSIONS
                mandatory()
            }
        }
    }.copyToClipBoard()
}