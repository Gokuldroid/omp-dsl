package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    doChangesForDeluiveryRestrictions("MAILBOX_MESSAGE_SIZE_RESTRICTION")
    doChangesForDeluiveryRestrictions("SHARED_MBX_MESSAGE_SIZE_RESTRICTION")
}

fun doChangesForDeluiveryRestrictions(taskId:String){
    var modifySendUI: Node? = null
    var sendSizeGroup: Node? = null
    var modifyReceiveUI: Node? = null
    var receiveSizeGroup: Node? = null
    var sendLimitOption: Node? = null
    var receiveLimitOption: Node? = null
    var sendLimit: Node? = null
    var receiveLimit: Node? = null

    var modifyRestrictionsUI: Node? = null
    var restrictionsGroup: Node? = null
    var acceptMessagesFrom: Node? = null
    var rejectMessagesFrom: Node? = null
    var acceptMessagesFromUsers: Node? = null
    var rejectMessagesFromUsers: Node? = null

    Node(taskId) {
        styleClass = "row o365-mb-5"
        node("col-md-6") {
            node("form-horizontal align-left o365-ml-40 line line-right") {
                node("form-group o365-mb-10") {
                    labelNode("control-label") {
                        modifySendUI = node {
                            emberComponent = EmberComponent.CHECK_BOX
                            componetId = "MODIFY_SEND_MESSAGE_SIZE_UI"
                            value = "\$true"
                        }
                        spanNode("o365-space-1")
                        spanNode("o365-thin-bold") {
                            label = "modify_send_message_size"
                        }
                    }
                }
                sendSizeGroup = node("form-group o365-make-relative") {
                    node("o365-ml-30 o365-make-relative float-left-first-div") {
                        sendLimitOption = node {
                            componetId = "MODIFY_SEND_MESSAGE_SIZE"
                            emberComponent = EmberComponent.RADIO_GROUP
                            value = "UseDefaultLimit"
                        }
                        sendLimit = node {
                            componetId = "MAX_SEND_SIZE"
                            emberComponent = EmberComponent.SIZE
                            disabled()
                        }
                    }
                }

                node("form-group o365-mb-10") {
                    labelNode("control-label") {
                        modifyReceiveUI = node {
                            emberComponent = EmberComponent.CHECK_BOX
                            componetId = "MODIFY_RECEIVE_MESSAGE_SIZE_UI"
                            value = "\$true"
                        }
                        spanNode("o365-space-1")
                        spanNode("o365-thin-bold") {
                            label = "modify_receive_message_size"
                        }
                    }
                }
                receiveSizeGroup = node("form-group o365-make-relative") {
                    node("o365-ml-30 o365-make-relative float-left-first-div") {
                        receiveLimitOption = node {
                            componetId = "MODIFY_RECEIVE_MESSAGE_SIZE"
                            emberComponent = EmberComponent.RADIO_GROUP
                            value = "UseDefaultLimit"
                        }
                        receiveLimit = node {
                            componetId = "MAX_RECEIVE_SIZE"
                            emberComponent = EmberComponent.SIZE
                            disabled()
                        }
                    }
                }
            }
        }
        node("col-md-6") {
            node("form-horizontal align-left o365-ml-10") {
                node("form-group o365-mb-10") {
                    labelNode("control-label") {
                        modifyRestrictionsUI = node {
                            emberComponent = EmberComponent.CHECK_BOX
                            componetId = "MODIFY_MESSAGE_RESTRICTIONS"
                            value = "\$true"
                        }
                        spanNode("o365-space-1")
                        spanNode("o365-thin-bold") {
                            label = "modify_message_restrictions"
                        }
                    }
                }
                restrictionsGroup = node("o365-make-relative") {
                    node("form-group o365-mb-10") {
                        labelNode("radio-inline  o365-ml-10") {
                            labelWrapper = "%s<span class=\"o365-space-3\"></span>"
                            label = "accept_message_from"
                        }
                    }
                    node("form-group o365-mb-15  o365-pl-3 float-left-first-div o365-ml-10 o365-pl-5") {
                        acceptMessagesFrom = node {
                            componetId = "ACCEPT_MESSAGES_FROM"
                            emberComponent = EmberComponent.RADIO_GROUP
                            value = "All"
                        }
                        spanNode("o365-space-1")
                        node("o365-inline-block o365-valign-middle o365-mtm-2") {
                            acceptMessagesFromUsers = node {
                                componetId = "ACCEPT_MESSAGES_FROM_USERS"
                                placeHolderText = "select_senders"
                                emberComponent = EmberComponent.REP_POPUP
                                mandatory()
                                disabled()
                            }
                        }
                    }
                    node("form-group o365-mb-10") {
                        labelNode("radio-inline  o365-ml-10") {
                            labelWrapper = "%s<span class=\"o365-space-3\"></span>"
                            label = "reject_message_from"
                        }
                    }
                    node("form-group o365-mb-15  o365-pl-3 float-left-first-div o365-ml-10 o365-pl-5") {
                        rejectMessagesFrom = node {
                            componetId = "REJECT_MESSAGES_FROM"
                            emberComponent = EmberComponent.RADIO_GROUP
                            value = "NoSenders"
                        }
                        spanNode("o365-space-1")
                        node("o365-inline-block o365-valign-middle o365-mtm-2") {
                            rejectMessagesFromUsers = node {
                                componetId = "REJECT_MESSAGES_FROM_USERS"
                                placeHolderText = "select_receivers"
                                emberComponent = EmberComponent.REP_POPUP
                                mandatory()
                                disabled()
                            }
                        }
                    }
                }
            }
        }
    }.replaceTasksXml({
        addRule(modifySendUI, sendSizeGroup, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(modifyReceiveUI, receiveSizeGroup, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(modifyRestrictionsUI, restrictionsGroup, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(sendLimitOption, sendLimit, Action.DISABLE, Condition.EQUAL, "UseDefaultLimit")
        addRule(receiveLimitOption, receiveLimit, Action.DISABLE, Condition.EQUAL, "UseDefaultLimit")
        addRule(modifyRestrictionsUI, restrictionsGroup, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(acceptMessagesFrom, acceptMessagesFromUsers, Action.DISABLE, Condition.NOT_EQUAL, "Custom")
        addRule(rejectMessagesFrom, rejectMessagesFromUsers, Action.DISABLE, Condition.NOT_EQUAL, "Custom")
    })
}