package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    Node("MAILBOX_FORWARD_TO") {
        styleClass = "row o365-mb-5"
        node("col-md-6") {
            node("o365-ml-30 o365-pr-30") {
                node("form-horizontal align-left") {
                    node("form-group") {
                        node("col-md-12") {
                            labelNode("radio-inline") {
                                node {
                                    componetId = "MAILBOX_FWD_TO_DISABLED"
                                    emberComponent = EmberComponent.RADIO_GROUP

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
                                                node {
                                                    componetId = "MAILBOX_FWD_TO_INTERNAL"
                                                    emberComponent = EmberComponent.RADIO_GROUP
                                                }
                                            }
                                        }
                                        tdNode {
                                            node ("o365-w-260"){
                                                componetId = "MAILBOX_FWD_TO_INTERNAL_ADDRESS"
                                                emberComponent = EmberComponent.REP_POPUP
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
                                        node {
                                            componetId = "MAILBOX_FWD_TO_EXTERNAL"
                                            emberComponent = EmberComponent.RADIO_GROUP
                                        }
                                    }
                                }
                                tdNode {
                                    node("o365-inline-block o365-valign-top o365-make-relative") {
                                        node("form-control o365-w-260") {
                                            componetId = "MAILBOX_FWD_TO_EXTERNAL_ADDRESS"
                                            emberComponent = EmberComponent.TEXT
                                        }
                                    }
                                }
                            }
                        }
                    }
                    node("form-group ifa o365-make-absolute o365-mt-m25"){
                        node("col-md-12 deilver-to-mailbxox"){
                            labelNode("checkbox-inline") {
                                node {
                                    componetId = "DELIVER_TO_MAILBOX_AND_FORWARD"
                                    emberComponent = EmberComponent.CHECK_BOX
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
    }.copyToClipBoard()
}