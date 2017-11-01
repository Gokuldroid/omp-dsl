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
                        styleClass = "form-group"
                        node {
                            label = "add_remove_roles"
                            htmlTag = "label"
                            styleClass = "col-md-4 control-label o365-pt-0"
                        }
                        node {
                            styleClass = "col-md-7"
                            node {
                                componetId = "ADD_REMOVE_ROLES"
                                emberComponent = EmberComponent.RADIO_GROUP
                            }
                        }
                    }
                    node {
                        styleClass = "from-group"
                        node {
                            label = "exchange_role"
                            styleClass = "col-md-4 control-label"
                        }
                        node {
                            styleClass = "col-md-7 o365-valign-top"
                            node {
                                styleClass = "input-group static"
                                node {
                                    componetId = "EXCHANGE_ROLES"
                                    emberComponent = EmberComponent.REP_POPUP
                                }
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}