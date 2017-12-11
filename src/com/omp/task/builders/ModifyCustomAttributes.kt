package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    Node("GRP_CUSTOM_ATTRIB_MODIFICATION") {
        styleClass = "o365-mb-5"
        node("static-container") {
            node("o365-mb-10") {
                node {
                    componetId = "GRP_CUSTOM_ATTRIBUTES"
                    emberComponent = EmberComponent.CUSTOM_ATTRIBUTES
                }
            }
        }
    }.copyToClipBoard()
}