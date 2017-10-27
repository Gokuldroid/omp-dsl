package com.omp.task.builders

import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    Node("MAILBOX_MESSAGE_SIZE_RESTRICTION") {
        styleClass = "row o365-mb-5"
        node("col-md-6") {
            node("line line-right o365-pr-20") {
                node("form-horizontal align-left o365-ml-40") {
                    node("form-group") {
                        node("col-md-12 control-label") {

                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}