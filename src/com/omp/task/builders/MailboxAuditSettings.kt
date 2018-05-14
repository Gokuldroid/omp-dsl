package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    doOperationsForAuditSettings("MAILBOX_AUDIT_SETTINGS")
    doOperationsForAuditSettings("SHARED_MBX_AUDIT_SETTINGS")
}

fun doOperationsForAuditSettings(taskId:String){
    var auditUI: Node? = null
    var audit: Node? = null
    var ageUI: Node? = null
    var age: Node? = null
    var delegateUI: Node? = null
    var delegate: Node? = null
    var ownersUI: Node? = null
    var owners: Node? = null
    var adminsUI: Node? = null
    var admins: Node? = null

    Node(taskId) {
        styleClass = "row o365-mb-10"
        node("col-md-6") {
            node("o365-ml-m40 o365-pr-20 o365-mt-10") {
                node("form-horizontal  o365-ml-40 o365-pl-30 align-left") {
                    node("form-group") {
                        labelNode("col-md-4 control-label o365-pt-0") {
                            spanNode("o365-nowrap") {
                                auditUI = node {
                                    componetId = "MODIFY_AUDIT_ENABLED"
                                    emberComponent = EmberComponent.CHECK_BOX
                                }
                                spanNode("o365-space-2")
                                spanNode {
                                    label = "mailbox_audit_settings"
                                }
                            }
                        }
                        audit = node("col-md-7 o365-valign-top o365-make-relative") {
                            disabled()
                            node {
                                componetId = "AUDIT_ENABLED"
                                emberComponent = EmberComponent.RADIO_GROUP
                                value = "\$true"
                            }
                        }
                    }
                    node("form-group o365-make-relative") {
                        labelNode("col-md-4 control-label") {
                            spanNode("o365-nowrap") {
                                ageUI = node {
                                    componetId = "MODIFY_AUDIT_LOG_AGE_LIMIT"
                                    emberComponent = EmberComponent.CHECK_BOX
                                }
                                spanNode("o365-space-2")
                                spanNode {
                                    label = "mailbox_audit_age_limit"
                                }
                            }
                        }
                        age = node("col-md-7 o365-valign-top o365-make-relative") {
                            disabled()
                            node {
                                mandatory()
                                componetId = "AUDIT_LOG_AGE_LIMIT"
                                styleClass = "input-md o365-mxw-60"
                                emberComponent = EmberComponent.TEXT
                                tooltip ="mailbox_audit_age_limit"
                            }
                        }
                    }
                }
            }
        }
        node("col-md-6 line line-left") {
            node("form-layout o365-ml-10") {
                node("form-row") {
                    labelNode("form-column o365-thin-bold") {
                        label = "assign_actions"
                    }
                }
                node("form-row") {
                    labelNode("form-column o365-pt-5 control-label") {
                        spanNode("o365-nowrap") {
                            delegateUI = node {
                                componetId = "MODIFY_AUDIT_DELEGATE"
                                emberComponent = EmberComponent.CHECK_BOX
                            }
                            node("o365-space-2")
                            spanNode {
                                label = "for_mailbox_delegates"
                            }
                            node("o365-space-3")
                        }
                    }
                    delegate = node("form-column o365-valign-top o365-make-relative") {
                        disabled()
                        node {
                            componetId = "AUDIT_DELEGATE"
                            emberComponent = EmberComponent.DR_SELECT_MUL
                            placeHolderText = "select_actions"
                        }
                    }
                }
                node("form-row") {
                    labelNode("form-column o365-pt-5 control-label") {
                        spanNode("o365-nowrap") {
                            ownersUI = node {
                                componetId = "MODIFY_AUDIT_OWNER"
                                emberComponent = EmberComponent.CHECK_BOX
                            }
                            node("o365-space-2")
                            spanNode {
                                label = "for_mailbox_owners"
                            }
                        }
                    }
                    owners = node("form-column o365-valign-top o365-make-relative") {
                        disabled()
                        node {
                            componetId = "AUDIT_OWNER"
                            emberComponent = EmberComponent.DR_SELECT_MUL
                            placeHolderText = "select_actions"
                        }
                    }
                }
                node("form-row o365-mb-20") {
                    labelNode("form-column o365-pt-5 control-label") {
                        spanNode("o365-nowrap") {
                            adminsUI = node {
                                componetId = "MODIFY_AUDIT_ADMIN"
                                emberComponent = EmberComponent.CHECK_BOX
                            }
                            node("o365-space-2")
                            spanNode {
                                label = "for_mailbox_admins"
                            }
                        }
                    }
                    admins = node("form-column o365-valign-top o365-make-relative") {
                        disabled()
                        node {
                            componetId = "AUDIT_ADMIN"
                            emberComponent = EmberComponent.DR_SELECT_MUL
                            placeHolderText = "select_actions"
                        }
                    }
                }
            }
        }
    }.replaceTasksXml({
        addRule(auditUI!!, audit, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(ageUI!!, age, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(delegateUI, delegate, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(ownersUI, owners, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(adminsUI, admins, Action.DISABLE, Condition.EQUAL, "\$false")
    })
}