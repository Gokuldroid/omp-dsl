package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    Node("GROUP_ACCEPT_MAIL_FROM") {
        styleClass = "row"
        node("col-md-6") {
            node("line line-right") {
                node("form-horizontal align-right o365-ml-15 o365-pl-20 o365-make-relative") {
                    node("form-group") {
                        labelNode("o365-inline-block control-label o365-pt-0 o365-pr-15") {
                            node {
                                componetId = "GROUP_ACCEPT_MAIL_FROM_UI"
                                emberComponent = EmberComponent.CHECK_BOX
                            }
                            node("o365-space-1") {
                                htmlTag = "span"
                            }
                            node {
                                htmlTag = "span"
                                label = "accept_mail_from"
                            }
                        }
                        node("o365-inline-block o365-valign-top") {
                            node("radio o365-mb-10") {
                                node {
                                    componetId = "ONLY_INTERNAL_SENDERS"
                                    emberComponent = EmberComponent.RADIO_GROUP
                                }
                            }
                            node("radio") {
                                node {
                                    componetId = "INTERNAL_AND_EXTERNAL_SENDERS"
                                    emberComponent = EmberComponent.RADIO_GROUP
                                }
                            }
                        }
                    }
                }
            }
        }
        node("col-md-6") {
            node("form-horizontal align-left  o365-ml-m10") {
                node("form-group o365-mb-0") {
                    labelNode("o365-inline-block control-label o365-pt-0 o365-pr-15") {
                        node {
                            componetId = "RESTRICT_USERS_UI"
                            emberComponent = EmberComponent.CHECK_BOX
                        }
                        node("o365-space-1") {
                            htmlTag = "span"
                        }
                        node {
                            htmlTag = "span"
                            label = "restrict_users_groups"
                        }
                    }
                    node("col-md-8 o365-valign-top") {
                        node {
                            componetId = "GROUPS_USERS"
                            emberComponent = EmberComponent.REP_POPUP
                        }
                    }
                }
                node("form-group o365-mb-20 o365-mt-10") {
                    node("col-md-8 col-md-offset-4") {
                        labelNode("o365-ml-m40") {
                            node {
                                componetId = "OVERRIDE_EXISTING_RESTRICTIONS"
                                emberComponent = EmberComponent.CHECK_BOX
                            }
                            node("o365-space-1") {
                                htmlTag = "span"
                            }
                            node {
                                htmlTag = "span"
                                label = "restrict_users_groups"
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}