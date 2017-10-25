package com.omp.task.builders

import com.omp.task.Powerhsell
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    val root = Node("MAILBOX_FEATURES") {
        styleClass = "row o365-mb-5"
        node {
            styleClass = "col-md-6"
            node {
                styleClass = "form-horizontal align-right line line-right"
                node {
                    value = Powerhsell.TRUE
                    label = "imap"
                    emberComponent = EmberComponent.DR_SELECT
                    width = "100px"
                    componetId = 1
                }
                node {
                    value = Powerhsell.TRUE
                    label = "mapi"
                    emberComponent = EmberComponent.DR_SELECT
                    width = "100px"
                    componetId = 2
                }
                node {
                    value = Powerhsell.TRUE
                    label = "pop"
                    emberComponent = EmberComponent.DR_SELECT
                    width = "100px"
                    componetId = 3
                }
                node {
                    value = Powerhsell.TRUE
                    label = "ews"
                    emberComponent = EmberComponent.DR_SELECT
                    width = "100px"
                    componetId = 4
                }
            }
        }
        node {
            styleClass = "col-md-6"
            node {
                styleClass = "form-horizontal align-right  o365-ml-m40"
                node {
                    value = Powerhsell.TRUE
                    label = "owa"
                    emberComponent = EmberComponent.DR_SELECT
                    width = "100px"
                    componetId = 5
                }
                node {
                    value = Powerhsell.TRUE
                    label = "owa_for_devices"
                    emberComponent = EmberComponent.DR_SELECT
                    width = "100px"
                    componetId = 6
                }
                node {
                    value = Powerhsell.TRUE
                    label = "ews"
                    emberComponent = EmberComponent.DR_SELECT
                    width = "100px"
                    componetId = 7
                }
            }
        }
    }
    println(root.toString())
}