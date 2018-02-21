package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    doOperationsForDeligations("MAILBOX_DELEGATION")
    doOperationsForDeligations("SHARED_MBX_DELEGATION")
}

fun doOperationsForDeligations(taskId:String){
    var modifySendAs: Node? = null
    var sendAsOption: Node? = null
    var sendAsMembers: Node? = null

    var modifySendOnBefhalf: Node? = null
    var sendOnBehalfOption: Node? = null
    var sendOnBehalfMembers: Node? = null

    var modifyFullAccess: Node? = null
    var fullAccessOption: Node? = null
    var fullAccessMembers: Node? = null

    Node(taskId) {
        styleClass = "row"
        node("col-md-6") {
            node("line line-right o365-ml-m40 o365-pr-20") {
                node("form-horizontal  o365-ml-40 o365-pl-30 align-left") {
                    //send as
                    node("form-group o365-mb-5 o365-make-relative") {
                        labelNode("col-md-4 control-label o365-pt-0") {
                            spanNode("o365-nowrap") {
                                modifySendAs = node {
                                    emberComponent = EmberComponent.CHECK_BOX
                                    componetId = "MODIFY_SEND_AS_UI"
                                    value = "\$false"
                                }
                                spanNode("o365-space-1")
                                spanNode {
                                    label = "modify_send_as"
                                }
                            }
                        }
                        sendAsOption = node("col-md-7 o365-valign-top o365-make-relative") {
                            disabled()
                            node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "ADD_REMOVE_SEND_AS_PERMISSIONS"
                                value = "AddPermissions"
                            }
                        }
                    }
                    node("form-group o365-make-relative") {
                        sendAsMembers = node("col-md-7 col-md-offset-4 o365-valign-top") {
                            disabled()
                            node {
                                emberComponent = EmberComponent.REP_POPUP
                                componetId = "SEND_AS_MEMBERS"
                                placeHolderText = "select_users"
                                mandatory()
                            }
                        }
                    }
                    //send on behalf
                    node("form-group o365-mb-5 o365-make-relative") {
                        labelNode("col-md-4 control-label o365-pt-0") {
                            spanNode("o365-nowrap") {
                                modifySendOnBefhalf = node {
                                    emberComponent = EmberComponent.CHECK_BOX
                                    componetId = "MODIFY_SEND_ON_BEHALF_UI"
                                    value = "\$false"
                                }
                                spanNode("o365-space-1")
                                spanNode {
                                    label = "modify_send_on_behalf"
                                }
                            }
                        }
                        sendOnBehalfOption = node("col-md-7 o365-valign-top o365-make-relative") {
                            disabled()
                            node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "ADD_REMOVE_SEND_ON_BEHALF_PERMISSIONS"
                                value = "AddPermissions"
                            }
                        }
                    }
                    node("form-group o365-make-relative") {

                        sendOnBehalfMembers = node("col-md-7 col-md-offset-4 o365-valign-top") {
                            disabled()
                            node {
                                emberComponent = EmberComponent.REP_POPUP
                                componetId = "SEND_ON_BEHALF_MEMBERS"
                                placeHolderText = "select_users"
                                mandatory()
                            }
                        }
                    }
                }
            }
        }
        node("col-md-6") {
            node("line line-right o365-ml-m40 o365-pr-20") {
                node("form-horizontal  o365-ml-40 o365-pl-40 align-left") {
                    //full access
                    node("form-group o365-mb-5 o365-make-relative") {
                        labelNode("col-md-3 control-label o365-pt-0") {
                            spanNode("o365-nowrap") {
                                modifyFullAccess = node {
                                    emberComponent = EmberComponent.CHECK_BOX
                                    componetId = "MODIFY_FULL_ACCESS_UI"
                                    value = "\$false"
                                }
                                spanNode("o365-space-1")
                                spanNode {
                                    label = "modify_full_access"
                                }
                            }
                        }
                        fullAccessOption = node("col-md-7 o365-valign-top o365-make-relative") {
                            disabled()
                            node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "ADD_REMOVE_FULL_ACCESS_PERMISSIONS"
                                value = "AddPermissions"
                            }
                        }
                    }
                    node("form-group o365-make-relative") {
                        fullAccessMembers = node("col-md-7 col-md-offset-3 o365-valign-top") {
                            disabled()
                            node {
                                emberComponent = EmberComponent.REP_POPUP
                                componetId = "FULL_ACCESS_MEMBERS"
                                placeHolderText = "select_users"
                                mandatory()
                            }
                        }
                    }
                }
            }
        }
    }.replaceTasksXml({
        addRule(modifySendAs, sendAsOption, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(modifySendOnBefhalf, sendOnBehalfOption, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(modifyFullAccess, fullAccessOption, Action.DISABLE, Condition.EQUAL, "\$false")

        addRule(modifySendAs, sendAsMembers, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(modifySendOnBefhalf, sendOnBehalfMembers, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(modifyFullAccess, fullAccessMembers, Action.DISABLE, Condition.EQUAL, "\$false")
    })
}