package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    val node = Node("LICENSE_MODIFICATION"){
        styleClass = "row"
        node {
            styleClass = "col-md-12"
            node {
                styleClass = "static-container-sm center-block"
                node{
                    styleClass = "form-horizontal align-right o365-ml-m22"
                    node {
                        componetId = 15
                        emberComponent = EmberComponent.DR_SELECT
                        label = "assign_remove_licenses"
                    }

                    node {
                        componetId = 16
                        emberComponent = EmberComponent.DR_SELECT
                        label = "usage_location"
                    }

                    node {
                        componetId = 17
                        emberComponent = EmberComponent.O365_LICENSES
                    }
                }
            }
        }
    }
    println(node)
}