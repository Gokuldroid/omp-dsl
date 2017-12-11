package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    Node("MAILBOX_CONVERSION") {
        styleClass = "row o365-mb-5"
        node("static-container-xs center-block") {
            node("form-horizontal o365-ml-m20 align-right") {
                node("form-group") {
                    labelNode("col-md-3 control-label") {
                        label = "convert_to"
                    }
                    node("col-md-9") {
                        node("col-md-9") {
                            node("o365-make-inline-block o365-mw-300 pull-left o365-make-relative") {
                                node{
                                    componetId = "MAILBOX_CONVERT_TO_TYPE"
                                    emberComponent = EmberComponent.DR_SELECT
                                }
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}