package com.omp.task.builders

import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    Node("MAILBOX_DELEGATION") {
        styleClass = "row"
        node {
            styleClass = "col-md-6"
            node {
                styleClass = "line line-right o365-ml-m40 o365-pr-20"
                node {
                    styleClass = "form-horizontal  o365-ml-40 o365-pl-30 align-left"
                    node {
                        styleClass = "form-group o365-mb-5 o365-make-relative"
                    }
                }
            }
        }
        node {
            styleClass = "col-md-6"
            node {
                styleClass = "form-horizontal"
                node {
                    styleClass = "form-group o365-mb-5 o365-make-relative"
                }
                node {
                    styleClass = "form-group o365-make-relative"
                }
            }
        }
    }
}