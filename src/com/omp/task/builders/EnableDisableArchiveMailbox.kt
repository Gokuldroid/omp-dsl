package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by Gokul.
 */

fun main(args: Array<String>) {
    doChangesForEnableDisableArchieveMailbox("ENABLE_DISABLE_ARCHIVE_MAILBOX")
}

fun doChangesForEnableDisableArchieveMailbox(taskId: String) {
    var archiveEnabled: Node? = null
    var archiveNameHideOption: Node? = null
    Node(taskId) {
        styleClass = "row"
        node("col-md-12") {
            node("static-container center-block o365-pl-25") {
                node("form-horizontal align-right o365-pl-3") {
                    node("form-group") {
                        labelNode("col-md-4 control-label o365-pt-0") {
                            label = "enable_disable_archive_mailbox"
                        }
                        node("col-md-7 o365-valign-top mailtip-radio") {
                            archiveEnabled = node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "IS_ARCHIVE_ENABLED"
                                value = "\$true"
                            }
                        }
                    }
                    archiveNameHideOption = node("form-group o365-mb-20") {
                        labelNode("col-md-4 control-label o365-pt-0") {
                            label = "archive_name"
                        }
                        node("col-md-7 o365-valign-top") {
                            node ("form-control o365-w-260"){
                                emberComponent = EmberComponent.TEXT
                                componetId = "ARCHIVE_NAME"
                                placeHolderText = "archive_name"
                                mandatory()
                            }
                        }
                    }
                }
            }
        }
    }.replaceTasksXml({
        addRule(archiveEnabled!!, archiveNameHideOption!!, Action.HIDE, Condition.EQUAL, "\$false")
    })
}