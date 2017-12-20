package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    var trigger: Node? = null
    var target: Node? = null
    var no3: Node? = null
    var no4: Node? = null
    var no5: Node? = null
    var no6: Node? = null
    val root = Node("USER_CREATION_WITH_LICENSE") {
        styleClass = "row"
        node("col-md-12") {
            node("static-container-sm center-block") {
                node("form-horizontal align-right o365-ml-m22") {
                    trigger = node {
                        componetId = "O365_LICENSES"
                        emberComponent = EmberComponent.O365_LICENSES
                        placeHolderText = "select_license"
                        mandatory()
                    }
                    target = node {
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
                                placeHolderText = "select_location"
                                mandatory()
                            }
                        }
                    }
                }
            }
        }
    }

    root.copyToClipBoard({
        addRule(trigger!!, target!!, Action.HIDE, Condition.EQUAL, "demo")
    })
}