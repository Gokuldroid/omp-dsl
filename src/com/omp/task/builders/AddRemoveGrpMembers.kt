package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    Node("ADD_REMOVE_DIST_GRP_MEMBERS") {
        styleClass = "row"
        node("col-md-12") {
            node("static-container-sm center-block") {
                node("form-horizontal align-right o365-ml-m22") {
                    node("form-group") {
                        labelNode("col-md-4 control-label") {
                            label = "add_to_group"
                        }
                        node("col-md-7") {
                            node {
                                componetId = "ADD_TO_OFFICE_365_GROUP"
                                emberComponent = EmberComponent.REP_POPUP
                                label = "select_groups"
                                placeHolderText ="select_groups"
                            }
                        }
                    }

                    node("form-group") {
                        labelNode("col-md-4 control-label") {
                            label = "remove_from_group"
                        }
                        node("col-md-7") {
                            node {
                                componetId = "REMOVE_FROM_OFFICE_365_GROUP"
                                emberComponent = EmberComponent.REP_POPUP
                                label = "select_groups"
                                placeHolderText = "select_groups"
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}