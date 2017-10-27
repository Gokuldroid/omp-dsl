package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    val node = Node("LICENSE_MODIFICATION") {
        styleClass = "row"
        node {
            styleClass = "col-md-12"
            node {
                styleClass = "static-container-sm center-block"
                node {
                    styleClass = "form-horizontal align-right o365-ml-m22"
                    node{
                        styleClass = "form-group"
                        node {
                            htmlTag = "label"
                            styleClass = "col-md-4 control-label"
                            label = "assign_remove_licenses"
                        }
                        node {
                            styleClass = "col-md-8"
                            node {
                                componetId = "ADD_REMOVE_LICENCES"
                                emberComponent = EmberComponent.DR_SELECT
                            }
                        }
                    }
                    node{
                        styleClass = "form-group"
                        node {
                            htmlTag = "label"
                            styleClass = "col-md-4 control-label"
                            label = "usage_location"
                        }
                        node {
                            styleClass = "col-md-8"
                            node {
                                componetId = "USAGE_LOCATION"
                                emberComponent = EmberComponent.DR_SELECT
                            }
                        }
                    }
                    node {
                        componetId = "O365_LICENSES"
                        emberComponent = EmberComponent.O365_LICENSES
                    }
                }
            }
        }
    }.copyToClipBoard()
}