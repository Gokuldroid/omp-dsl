package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    var nodeselect: Node? = null;
    var licenseses: Node? = null
    val node = Node("LICENSE_MODIFICATION") {
        styleClass = "row"
        node {
            styleClass = "col-md-12"
            node {
                styleClass = "static-container-sm center-block"
                node {
                    styleClass = "form-horizontal align-right o365-ml-m22"
                    node {
                        styleClass = "form-group"
                        node {
                            htmlTag = "label"
                            styleClass = "col-md-4 control-label"
                            label = "assign_remove_licenses"
                            label = ""
                        }
                        node {
                            styleClass = "col-md-8"
                            nodeselect = node {
                                componetId = "ASSIGN_REMOVE_LICENSES"
                                placeHolderText = "select_option"
                                mandatory()
                                emberComponent = EmberComponent.DR_SELECT
                            }
                        }
                    }
                    licenseses = node {
                        componetId = "O365_LICENSES"
                        mandatory()
                        placeHolderText = "select_license"
                        emberComponent = EmberComponent.O365_LICENSES
                    }
                    node {
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
                                tooltip = "usage_location"
                                placeHolderText = "no_change_required"
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard({
        addRule(nodeselect!!, licenseses!!, Action.HIDE, Condition.EQUAL, "remove-all")
    })
}