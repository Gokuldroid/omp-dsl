package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    doOperationsForLitigationHoldSettings("LITIGATION_HOLD_CHANGES")
    doOperationsForLitigationHoldSettings("SHARED_MBX_LITIGATION_HOLD_CHANGES")
}

fun doOperationsForLitigationHoldSettings(taskId: String) {
    var litigationHoldUI: Node? = null
    var litigationHoldOptions: Node? = null
    var notesCheck: Node? = null
    var notes: Node? = null
    var urlCheck: Node? = null
    var url: Node? = null
    var isEnabled: Node? = null
    var owner: Node? = null
    var duration: Node? = null

    Node(taskId) {
        styleClass = "gsection"
        node("gspan_2_of_4 gcolumn line line-right o365-mb-15") {
            node("o365-ml-40 o365-mb-15") {
                node("checkbox-inline") {
                    htmlTag = "label"
                    litigationHoldUI = node {
                        componetId = "LITIGATION_HOLD_SETTINGS_UI"
                        emberComponent = EmberComponent.CHECK_BOX
                        value = "\$true"
                    }
                    node("o365-space-1") {
                        htmlTag = "span"
                    }
                    node {
                        htmlTag = "span"
                        label = "configure_litigation_hold"
                    }
                }
            }
            node("o365-ml-60 o365-pr-20") {
                litigationHoldOptions = node("form-horizontal align-right o365-make-relative") {
                    node("form-group") {
                        node {
                            styleClass = "col-md-4 control-label o365-pt-0"
                            label = "litigation_hold"
                            htmlTag = "label"
                        }
                        node {
                            styleClass = "col-md-7 o365-valign-top"
                            isEnabled = node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "LITIGATION_HOLD_ENABLED"
                                value = "\$true"
                            }
                        }
                    }
                    node("form-group o365-make-relative") {
                        node {
                            styleClass = "col-md-4 control-label"
                            label = "put_on_hold_by"
                            htmlTag = "label"
                        }
                        node {
                            styleClass = "col-md-7 o365-valign-top"
                            owner = node {
                                emberComponent = EmberComponent.REP_POPUP
                                componetId = "LITIGATION_HOLD_OWNER"
                                label = "put_on_hold_by"
                                placeHolderText = "select_owner"
                                tooltip = "litigation_hold_owner"
                            }
                        }
                    }
                    node("form-group o365-make-relative o365-mb-5") {
                        node {
                            styleClass = "col-md-4 control-label"
                            label = "litigation_hold_duration"
                            htmlTag = "label"
                        }
                        node {
                            styleClass = "col-md-7 o365-valign-top"
                            duration = node("input-md o365-mxw-60") {
                                emberComponent = EmberComponent.TEXT
                                componetId = "LITIGATION_HOLD_DURATION"
                                tooltip = "litigation_hold_duration"
                            }
                        }
                    }
                }
            }
        }
        node {
            styleClass = "gspan_2_of_4 gcolumn"
            node {
                styleClass = "form-layout align-left"
                node {
                    styleClass = "form-row"
                    node {
                        styleClass = "form-column control-label o365-pt-5"
                        htmlTag = "label"
                        node("o365-space-6") {
                            htmlTag = "span"
                        }
                        node("o365-nowrap") {
                            htmlTag = "span"
                            node("o365-space-2") {
                                htmlTag = "span"
                            }
                            notesCheck = node {
                                emberComponent = EmberComponent.CHECK_BOX
                                componetId = "RETENTION_COMMENT_UI"
                                value = "\$true"
                            }
                            node("o365-space-2") {
                                htmlTag = "span"
                            }
                            node {
                                htmlTag = "span"
                                label = "notes"
                            }
                        }
                        node("o365-space-4") {
                            htmlTag = "span"
                        }
                    }
                    node {
                        styleClass = "form-column o365-valign-top"
                        notes = node("form-control notestextarea litigation-hold") {
                            emberComponent = EmberComponent.TEXT
                            componetId = "RETENTION_COMMENT"
                        }
                    }
                }
                node {
                    styleClass = "form-row"
                    node {
                        styleClass = "form-column control-label o365-pt-5"
                        htmlTag = "span"
                        node("o365-space-6") {
                            htmlTag = "span"
                        }
                        node("o365-nowrap") {
                            htmlTag = "span"
                            node("o365-space-2") {
                                htmlTag = "span"
                            }
                            urlCheck = node {
                                emberComponent = EmberComponent.CHECK_BOX
                                componetId = "RETENTION_URL_UI"
                                value = "\$true"
                            }
                            node("o365-space-2") {
                                htmlTag = "span"
                            }
                            node {
                                htmlTag = "span"
                                label = "url"
                            }
                        }
                        node("o365-space-4") {
                            htmlTag = "span"
                        }
                    }
                    node {
                        styleClass = "form-column o365-valign-top"
                        url = node("form-control") {
                            emberComponent = EmberComponent.TEXT
                            componetId = "RETENTION_URL"
                        }
                    }
                }
            }
        }
    }.replaceTasksXml({
        addRule(litigationHoldUI!!, litigationHoldOptions!!, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(notesCheck!!, notes!!, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(urlCheck!!, url!!, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(isEnabled!!,owner!!,Action.DISABLE,Condition.EQUAL,"\$false")
        addRule(isEnabled!!,duration!!,Action.DISABLE,Condition.EQUAL,"\$false")
    })
}