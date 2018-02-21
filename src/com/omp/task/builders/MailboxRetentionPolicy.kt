package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    doOperationsForRetentionPolicy("MAILBOX_RETENTION_POLICY_CHANGES")
    doOperationsForRetentionPolicy("SHARED_MBX_RETENTION_POLICY_CHANGES")
}

fun doOperationsForRetentionPolicy(taskId:String){
    var rentionHoldUI: Node? = null
    var duration: Node? = null
    var comment: Node? = null
    Node(taskId) {
        styleClass = "row"
        node("col-md-6") {
            node("form-horizontal align-right line line-right o365-ml-20") {
                node("form-group") {
                    node("col-md-4 control-label") {
                        label = "retention_policy"
                    }
                    node("col-md-7 o365-valign-top") {
                        node {
                            emberComponent = EmberComponent.REP_POPUP
                            componetId = "RETENTION_POLICY"
                            label = "retention_policy"
                        }
                    }
                }
                node("form-group") {
                    node("col-md-4 control-label") {
                        label = "retention_url"
                    }
                    node("col-md-8 o365-valign-top") {
                        node {
                            emberComponent = EmberComponent.TEXT
                            componetId = "RETENTION_URL"
                            styleClass = "form-control o365-inline-block"
                        }
                    }
                }
                node("form-group") {
                    node("col-md-4 control-label o365-pt-5") {
                        label = "retain_deleted_items_for"
                    }
                    node("col-md-7 o365-valign-top") {
                        node {
                            styleClass = "input-md o365-mxw-60"
                            emberComponent = EmberComponent.TEXT
                            componetId = "RETAIN_DELETED_ITEMS_FOR"
                        }
                    }
                }
            }
        }
        node("col-md-6") {
            node("static-container-sm") {
                node("form-horizontal align-left  o365-ml-10") {
                    node("form-group") {
                        labelNode("col-md-12") {
                            rentionHoldUI = node {
                                componetId = "RETENTION_HOLD_ENABLED"
                                emberComponent = EmberComponent.CHECK_BOX
                            }
                            spanNode("o365-space-1")
                            spanNode {
                                label = "enable_retention_hold"
                            }
                        }
                    }
                    duration = node("form-group o365-make-relative o365-ml-15") {
                        disabled()
                        labelNode("col-md-3 control-label text-right") {
                            label = "retention_hold_duration"
                        }
                        node("col-md-7 o365-valign-top o365-ml-10") {
                            node {
                                componetId = "RETENTION_HOLD_DURATION"
                                emberComponent = EmberComponent.DATE_PICKER
                            }
                        }
                    }

                    comment = node("form-group o365-mb-20 o365-make-relative o365-ml-15") {
                        disabled()
                        labelNode("col-md-3 control-label") {
                            label = "retention_comment"
                            labelWrapper = "<div class=\"o365-align-right\">%s</div>"
                        }
                        node("col-md-7 o365-valign-top") {
                            node {
                                styleClass = "form-control o365-ml-10 retention-comment"
                                componetId = "RETENTION_COMMENT"
                                emberComponent = EmberComponent.TEXT
                            }
                        }
                    }
                }
            }
        }
    }.replaceTasksXml({
        addRule(rentionHoldUI,comment,Action.DISABLE,Condition.EQUAL,"\$false")
        addRule(rentionHoldUI,duration,Action.DISABLE,Condition.EQUAL,"\$false")
    })
}