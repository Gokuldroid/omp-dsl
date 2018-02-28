package com.omp.task.builders

import com.omp.task.layout.Action
import com.omp.task.layout.Condition
import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    var acceptMailFromUI: Node? = null
    var acceptMailFrom: Node? = null
    var acceptMailFrom2: Node? = null
    var restrictUsersUI: Node? = null
    var restrictUsersEle1: Node? = null
    var restrictUsersEle2: Node? = null
    Node("GROUP_ACCEPT_MAIL_FROM") {
        styleClass = "row"
        node("col-md-6") {
            node("form-horizontal align-right o365-ml-15 o365-pl-20 o365-make-relative") {
                node("form-group") {
                    labelNode("o365-inline-block control-label o365-pt-0 o365-pr-15") {
                        acceptMailFromUI = node {
                            componetId = "GROUP_ACCEPT_MAIL_FROM_UI"
                            emberComponent = EmberComponent.CHECK_BOX
                            value = "\$true"
                        }
                        spanNode("o365-space-2")
                        node {
                            htmlTag = "span"
                            label = "accept_mail_from"
                        }
                    }
                    node("o365-inline-block o365-valign-top") {
                        acceptMailFrom = node("radio o365-mb-10") {
                            node {
                                componetId = "ONLY_INTERNAL_SENDERS"
                                emberComponent = EmberComponent.RADIO_GROUP
                                value = "Internal"
                            }
                        }
                        acceptMailFrom2 = node("radio") {
                            node {
                                componetId = "INTERNAL_AND_EXTERNAL_SENDERS"
                                emberComponent = EmberComponent.RADIO_GROUP
                            }
                        }
                    }
                }
            }
        }
        node("col-md-6") {
            node("line line-left o365-ml-m15 o365-pl-30") {
                node("form-horizontal align-left  o365-ml-m10") {
                    node("form-group o365-mb-0") {
                        labelNode("col-md-4 control-label text-right") {
                            restrictUsersUI = node {
                                componetId = "RESTRICT_USERS_UI"
                                emberComponent = EmberComponent.CHECK_BOX
                                value = "\$false"
                            }
                            node("o365-space-2") {
                                htmlTag = "span"
                            }
                            node {
                                htmlTag = "span"
                                label = "restrict_users_groups"
                            }
                        }
                        restrictUsersEle1 = node("col-md-8 o365-valign-top grp-accept-mail-from") {
                            disabled()
                            node {
                                componetId = "GROUPS_USERS"
                                label = "select_users"
                                emberComponent = EmberComponent.REP_POPUP
                                mandatory()
                            }
                        }
                    }
                    node("form-group o365-mb-20 o365-mt-10") {
                        node("col-md-8 col-md-offset-4") {
                            restrictUsersEle2 = labelNode("o365-ml-m40") {
                                disabled()
                                node {
                                    componetId = "OVERWRITE_EXISTING_USERS"
                                    emberComponent = EmberComponent.CHECK_BOX
                                }
                                spanNode("o365-space-1")
                                node {
                                    htmlTag = "span"
                                    label = "overwrite_existing_users"
                                    tooltip ="overwrite_existing_users"
                                }
                            }
                        }
                    }
                }
            }
        }
    }.replaceTasksXml({
        addRule(acceptMailFromUI, acceptMailFrom, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(acceptMailFromUI, acceptMailFrom2, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(restrictUsersUI, restrictUsersEle1, Action.DISABLE, Condition.EQUAL, "\$false")
        addRule(restrictUsersUI, restrictUsersEle2, Action.DISABLE, Condition.EQUAL, "\$false")
    })
}