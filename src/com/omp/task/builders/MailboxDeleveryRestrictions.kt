package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
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

    Node("MAILBOX_MESSAGE_SIZE_RESTRICTION") {
        styleClass = "row o365-mb-5"
        node("col-md-6") {
            node("form-horizontal align-left o365-ml-40 line line-right") {
                node("form-group o365-mb-5") {
                    labelNode("control-label") {
                        modifySendUI = node {
                            emberComponent = EmberComponent.CHECK_BOX
                            componetId = "MODIFY_SEND_MESSAGE_SIZE_UI"
                            value = "\$true"
                        }
                        spanNode("o365-space-2")
                        spanNode("o365-thin-bold") {
                            label = "modify_send_message_size"
                        }
                    }
                }
                sendSizeGroup = node("form-group o365-make-relative") {
                    node("o365-ml-40 o365-pl-5 o365-make-relative float-left-first-div") {
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

                node("form-group o365-mb-5") {
                    labelNode("control-label") {
                        modifyReceiveUI = node {
                            emberComponent = EmberComponent.CHECK_BOX
                            componetId = "MODIFY_RECEIVE_MESSAGE_SIZE_UI"
                            value = "\$true"
                        }
                        spanNode("o365-space-2")
                        spanNode("o365-thin-bold") {
                            label = "modify_receive_message_size"
                        }
                    }
                }
                receiveSizeGroup = node("form-group o365-make-relative") {
                    node("o365-ml-40 o365-pl-5 o365-make-relative float-left-first-div") {
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
                        spanNode("o365-space-2")
                        spanNode("o365-thin-bold") {
                            label = "modify_message_restrictions"
                        }
                    }
                }
                restrictionsGroup = node("o365-make-relative") {
                    node("form-group o365-mb-5") {
                        labelNode("radio-inline  o365-ml-15") {
                            labelWrapper = "<span class=\"o365-space-2\"></span>%s<span class=\"o365-space-3\"></span>"
                            label = "accept_message_from"
                        }
                    }
                    node("form-group o365-mb-15  o365-pl-3 float-left-first-div o365-ml-40") {
                        acceptMessagesFrom = node {
                            componetId = "ACCEPT_MESSAGES_FROM"
                            emberComponent = EmberComponent.RADIO_GROUP
                            value = "All"
                        }
                        node("o365-inline-block o365-valign-middle") {
                            acceptMessagesFromUsers = node {
                                componetId = "ACCEPT_MESSAGES_FROM_USERS"
                                emberComponent = EmberComponent.REP_POPUP
                            }
                        }
                    }
                    node("form-group o365-mb-5") {
                        labelNode("radio-inline  o365-ml-15") {
                            labelWrapper = "<span class=\"o365-space-2\"></span>%s<span class=\"o365-space-3\"></span>"
                            label = "reject_message_from"
                        }
                    }
                    node("form-group o365-mb-15  o365-pl-3 float-left-first-div o365-ml-40") {
                        rejectMessagesFrom = node {
                            componetId = "REJECT_MESSAGES_FROM"
                            emberComponent = EmberComponent.RADIO_GROUP
                            value = "NoSenders"
                        }
                        node("o365-inline-block o365-valign-middle") {
                            rejectMessagesFromUsers = node {
                                componetId = "REJECT_MESSAGES_FROM_USERS"
                                emberComponent = EmberComponent.REP_POPUP
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard({
        addRule(modifySendUI, sendSizeGroup, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(modifyReceiveUI, receiveSizeGroup, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(modifyRestrictionsUI, restrictionsGroup, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(sendLimitOption, sendLimit, Action.DISABLE, Condition.EQUAL, "UseDefaultLimit")
        addRule(receiveLimitOption, receiveLimit, Action.DISABLE, Condition.EQUAL, "UseDefaultLimit")
        addRule(modifyRestrictionsUI, restrictionsGroup, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(acceptMessagesFrom, acceptMessagesFromUsers, Action.DISABLE, Condition.NOT_EQUAL, "custom")
        addRule(rejectMessagesFrom, rejectMessagesFromUsers, Action.DISABLE, Condition.NOT_EQUAL, "custom")
    })
}