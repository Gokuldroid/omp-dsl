package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    Node("HIDE_UNHIDE_CONTACTS"){
        styleClass = "row o365-mb-5"
        node {
            styleClass = "col-md-12"
            node {
                styleClass = "center-block static-container-sm"
                node {
                    styleClass = "form-horizontal align-left"
                    node {
                        styleClass = "form-group"
                        node {
                            styleClass = "col-md-12 col-md-push-3"
                            node {
                                componetId = "HIDE_UNHIDE_FROM_ADDRESSLIST"
                                emberComponent = EmberComponent.RADIO_GROUP
                                value = "\$true"
                                mandatory()
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}