package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    Node("MAILBOX_DELEGATION") {
        styleClass = "row"
        node ("col-md-6"){
            node ("line line-right o365-ml-m40 o365-pr-20"){
                node ("form-horizontal  o365-ml-40 o365-pl-30 align-left"){
                    //send as
                    node ("form-group o365-mb-5 o365-make-relative"){
                        labelNode ("col-md-4 control-label o365-pt-0"){
                            spanNode ("o365-nowrap"){
                                node {
                                    emberComponent = EmberComponent.CHECK_BOX
                                    componetId = "MODIFY_SEND_AS_UI"
                                }
                                spanNode("o365-space-2")
                                spanNode {
                                    label = "modify_send_as"
                                }
                            }
                        }
                        node("col-md-7 o365-valign-top o365-make-relative") {
                            node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "ADD_REMOVE_SEND_AS_PERMISSIONS"
                            }
                        }
                    }
                    node("form-group o365-make-relative") {
                        node("freeze o365-ml-40")
                        node("col-md-7 col-md-offset-4 o365-valign-top") {
                            node {
                                emberComponent = EmberComponent.REP_POPUP
                                componetId = "SEND_AS_MEMBERS"
                            }
                        }
                    }
                    //send on behalf
                    node ("form-group o365-mb-5 o365-make-relative"){
                        labelNode ("col-md-4 control-label o365-pt-0"){
                            spanNode ("o365-nowrap"){
                                node {
                                    emberComponent = EmberComponent.CHECK_BOX
                                    componetId = "MODIFY_SEND_ON_BEHALF_UI"
                                }
                                spanNode("o365-space-2")
                                spanNode {
                                    label = "modify_send_on_behalf"
                                }
                            }
                        }
                        node("col-md-7 o365-valign-top o365-make-relative") {
                            node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "ADD_REMOVE_SEND_ON_BEHALF_PERMISSIONS"
                            }
                        }
                    }
                    node("form-group o365-make-relative") {
                        node("freeze o365-ml-40")
                        node("col-md-7 col-md-offset-4 o365-valign-top") {
                            node {
                                emberComponent = EmberComponent.REP_POPUP
                                componetId = "SEND_ON_BEHALF_MEMBERS"
                            }
                        }
                    }
                }
            }
        }
        node("col-md-6") {
            node ("line line-right o365-ml-m40 o365-pr-20"){
                node ("form-horizontal  o365-ml-40 o365-pl-30 align-left"){
                    //full access
                    node ("form-group o365-mb-5 o365-make-relative"){
                        labelNode ("col-md-4 control-label o365-pt-0"){
                            spanNode ("o365-nowrap"){
                                node {
                                    emberComponent = EmberComponent.CHECK_BOX
                                    componetId = "MODIFY_FULL_ACCESS_UI"
                                }
                                spanNode("o365-space-2")
                                spanNode {
                                    label = "modify_full_access"
                                }
                            }
                        }
                        node("col-md-7 o365-valign-top o365-make-relative") {
                            node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "ADD_REMOVE_FULL_ACCESS_PERMISSIONS"
                            }
                        }
                    }
                    node("form-group o365-make-relative") {
                        node("freeze o365-ml-40")
                        node("col-md-7 col-md-offset-4 o365-valign-top") {
                            node {
                                emberComponent = EmberComponent.REP_POPUP
                                componetId = "FULL_ACCESS_MEMBERS"
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}