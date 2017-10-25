package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    Node("EXCHANGE_ROLE_CHANGES") {
        styleClass = "row"
        node {
            styleClass = "col-md-12"
            node {
                styleClass = "static-container-sm center-block"
                node {
                    styleClass = "form-horizontal align-right o365-ml-m22"
                    node {
                        label = "add_remove_roles"
                    }
                    node {
                        componetId = 48
                        emberComponent = EmberComponent.RADIO_GROUP
                    }
                    node {
                        label = "exchange_role"
                        componetId = 49
                        emberComponent = EmberComponent.REP_POPUP
                    }
                }
            }
        }
    }.copyToClipBoard()
}