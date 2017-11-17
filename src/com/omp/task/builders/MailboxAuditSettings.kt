package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    Node("MAILBOX_AUDIT_SETTINGS") {
        styleClass = "row"
        node("col-md-6") {
            node("line line-right o365-ml-m40 o365-pr-20 o365-mt-10") {
                node("form-horizontal  o365-ml-40 o365-pl-30 align-left") {
                    node("form-group") {
                        labelNode("col-md-4 control-label o365-pt-0") {
                            spanNode("o365-nowrap") {
                                node {
                                    componetId = "MODIFY_AUDIT_ENABLED"
                                    emberComponent = EmberComponent.CHECK_BOX
                                }
                                spanNode("o365-space-2")
                                spanNode {
                                    label = "mailbox_audit_settings"
                                }
                            }
                        }
                        node("col-md-7 o365-valign-top o365-make-relative") {
                            node {
                                componetId = "AUDIT_ENABLED"
                                emberComponent = EmberComponent.RADIO_GROUP
                            }
                        }
                    }
                    node("form-group o365-make-relative") {
                        labelNode("col-md-4 control-label o365-pt-0") {
                            spanNode("o365-nowrap") {
                                node {
                                    componetId = "MODIFY_AUDIT_LOG_AGE_LIMIT"
                                    emberComponent = EmberComponent.CHECK_BOX
                                }
                                spanNode("o365-space-2")
                                spanNode {
                                    label = "mailbox_audit_age_limit"
                                }
                            }
                        }
                        node("col-md-7 o365-valign-top o365-make-relative") {
                            node {
                                componetId = "AUDIT_LOG_AGE_LIMIT"
                                styleClass = "input-md o365-mxw-50"
                                emberComponent = EmberComponent.TEXT
                            }
                        }
                    }
                }
            }
        }
        node("col-md-6") {
            node("form-layout o365-ml-10") {
                node("form-row") {
                    labelNode("form-column o365-thin-bold") {
                        label = "assign_actions"
                    }
                }
                node("form-row") {
                    labelNode("form-column o365-pt-5 control-label") {
                        spanNode("o365-nowrap") {
                            node {
                                componetId = "MODIFY_AUDIT_DELEGATE"
                                emberComponent = EmberComponent.CHECK_BOX
                            }
                            node("o365-space-2")
                            spanNode {
                                label = "for_mailbox_delegates"
                            }
                        }
                    }
                    node("form-column o365-valign-top o365-make-relative") {
                        node{
                            componetId = "AUDIT_DELEGATE"
                            emberComponent = EmberComponent.DR_SELECT_MUL
                        }
                    }
                }
                node("form-row") {
                    labelNode("form-column o365-pt-5 control-label") {
                        spanNode("o365-nowrap") {
                            node {
                                componetId = "MODIFY_AUDIT_OWNER"
                                emberComponent = EmberComponent.CHECK_BOX
                            }
                            node("o365-space-2")
                            spanNode {
                                label = "for_mailbox_owners"
                            }
                        }
                    }
                    node("form-column o365-valign-top o365-make-relative") {
                        node{
                            componetId = "AUDIT_OWNER"
                            emberComponent = EmberComponent.DR_SELECT_MUL
                        }
                    }
                }
                node("form-row o365-mb-20") {
                    labelNode("form-column o365-pt-5 control-label") {
                        spanNode("o365-nowrap") {
                            node {
                                componetId = "MODIFY_AUDIT_ADMIN"
                                emberComponent = EmberComponent.CHECK_BOX
                            }
                            node("o365-space-2")
                            spanNode {
                                label = "for_mailbox_admins"
                            }
                        }
                    }
                    node("form-column o365-valign-top o365-make-relative") {
                        node{
                            componetId = "AUDIT_ADMIN"
                            emberComponent = EmberComponent.DR_SELECT_MUL
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}