package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    var dontFwd:Node ? = null
    var keepACopy:Node?= null
    var internalFwd: Node? = null
    var internalFwdAddress: Node? = null
    var externalFwd: Node? = null
    var externalFwDdAddress: Node? = null

    Node("MAILBOX_FORWARD_TO") {
        styleClass = "row o365-mb-5"
        node("col-md-6") {
            node("o365-ml-30 o365-pr-30") {
                node("form-horizontal align-left") {
                    node("form-group") {
                        node("col-md-12") {
                            labelNode("radio-inline") {
                                dontFwd = node {
                                    componetId = "MAILBOX_FWD_TO_DISABLED"
                                    emberComponent = EmberComponent.RADIO_GROUP
                                    value = "ForwardDisabled"
                                }
                            }
                        }
                    }
                    node("form-group o365-mb-10 o365-make-relative") {
                        node("o365-inline-block o365-valign-middle o365-make-relative") {
                            tableNode {
                                tbodyNode {
                                    trNode {
                                        tdNode {
                                            labelNode("radio-inline o365-ml-15 width-220") {
                                                internalFwd = node {
                                                    componetId = "MAILBOX_FWD_TO_INTERNAL"
                                                    emberComponent = EmberComponent.RADIO_GROUP
                                                }
                                            }
                                        }
                                        tdNode {
                                            internalFwdAddress = node("o365-w-260") {
                                                componetId = "MAILBOX_FWD_TO_INTERNAL_ADDRESS"
                                                emberComponent = EmberComponent.REP_POPUP
                                                mandatory()
                                                disabled()
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    node("form-group o365-mb-30 o365-make-relative external") {
                        tableNode {
                            trNode {
                                tdNode {
                                    labelNode("radio-inline o365-ml-15 width-220") {
                                        externalFwd = node {
                                            componetId = "MAILBOX_FWD_TO_EXTERNAL"
                                            emberComponent = EmberComponent.RADIO_GROUP
                                        }
                                    }
                                }
                                tdNode {
                                    node("o365-inline-block o365-valign-top o365-make-relative") {
                                        externalFwDdAddress = node("form-control o365-w-260") {
                                            componetId = "MAILBOX_FWD_TO_EXTERNAL_ADDRESS"
                                            emberComponent = EmberComponent.TEXT
                                            mandatory()
                                            disabled()
                                        }
                                    }
                                }
                            }
                        }
                    }
                    node("form-group ifa o365-make-absolute o365-mt-m25") {
                        node("col-md-12 deilver-to-mailbxox") {
                            keepACopy = labelNode("checkbox-inline") {
                                hide()
                                node {
                                    componetId = "DELIVER_TO_MAILBOX_AND_FORWARD"
                                    emberComponent = EmberComponent.CHECK_BOX
                                    value = "\$true"
                                }
                                spanNode { styleClass = "o365-space-1" }
                                spanNode {
                                    label = "keep_a_copy_in_this_mailbox"
                                }
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard({
        addRule(dontFwd,keepACopy,Action.HIDE,Condition.EQUAL,"ForwardDisabled")
        addRule(internalFwd,internalFwdAddress,Action.DISABLE,Condition.NOT_EQUAL,"ToInternal")
        addRule(externalFwd,externalFwDdAddress,Action.DISABLE,Condition.NOT_EQUAL,"ToExternal")
    })
}