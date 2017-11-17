package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    Node("RESET_PASSWORD") {
        styleClass = "row o365-mb-5"
        node("col-md-6") {
            node("line line-right o365-pr-20") {
                node("form-horizontal align-left o365-ml-40 o365-pb-10") {
                    node("form-group") {
                        labelNode("col-md-12 control-label") {
                            node {
                                componetId = "RESET_PASSWORD_UI"
                                emberComponent = EmberComponent.CHECK_BOX
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}