package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    Node("MAILTIP_SETTINGS") {
        styleClass = "row"
        node("col-md-12") {
            node("static-container center-block o365-pl-25") {
                node("form-horizontal align-right o365-pl-3") {
                    node("form-group o365-mb-10") {
                        labelNode("col-md-4 control-label o365-pt-0") {
                            label = "set_remove_mailtip"
                        }
                        node("col-md-7 o365-valign-top") {
                            node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "IS_MAILTIP_ENABLED"
                            }
                        }
                    }
                    node("form-group") {
                        node("col-md-7 col-md-offset-4 o365-valign-top") {
                            node {
                                emberComponent = EmberComponent.TEXT
                                componetId = "MAILTIP"
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}