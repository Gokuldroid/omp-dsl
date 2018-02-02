package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    var mailtipEnabled: Node? = null
    var mailtip: Node? = null
    Node("MAILTIP_SETTINGS") {
        styleClass = "row"
        node("col-md-12") {
            node("static-container center-block o365-pl-25") {
                node("form-horizontal align-right o365-pl-3") {
                    node("form-group") {
                        labelNode("col-md-4 control-label o365-pt-0") {
                            label = "set_remove_mailtip"
                        }
                        node("col-md-7 o365-valign-top") {
                            mailtipEnabled = node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "IS_MAILTIP_ENABLED"
                                value = "\$true"
                            }
                        }
                    }
                    node("form-group o365-mb-20") {
                        mailtip = node("col-md-7 col-md-offset-4 o365-valign-top") {
                            node {
                                styleClass = "mailtip"
                                emberComponent = EmberComponent.TEXT
                                componetId = "MAILTIP"
                                tooltip = "mailtip"
                                placeHolderText = "mailtip_placeholder"
                                mandatory()
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard({
        addRule(mailtipEnabled, mailtip, Action.HIDE, Condition.EQUAL, "\$false")
    })
}