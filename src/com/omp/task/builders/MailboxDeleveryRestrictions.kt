package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    Node("MAILBOX_MESSAGE_SIZE_RESTRICTION") {
        styleClass = "row o365-mb-5"
        node("col-md-6") {
            node("form-horizontal align-left o365-ml-40 line line-right") {
                node("form-group o365-mb-5") {
                    labelNode("control-label") {
                        node {
                            emberComponent = EmberComponent.CHECK_BOX
                            componetId = "MODIFY_SEND_MESSAGE_SIZE_UI"
                        }
                        spanNode("o365-space-2")
                        spanNode("o365-thin-bold") {
                            label = "modify_send_message_size"
                        }
                    }
                }
                node("form-group") {
                    node("o365-ml-40 o365-pl-5 o365-make-relative float-left-first-div") {
                        node {
                            componetId = "MODIFY_SEND_MESSAGE_SIZE"
                            emberComponent = EmberComponent.RADIO_GROUP
                        }
                        node {
                            componetId = "MAX_SEND_SIZE"
                            emberComponent = EmberComponent.SIZE
                        }
                    }
                }

                node("form-group o365-mb-5") {
                    labelNode("control-label") {
                        node {
                            emberComponent = EmberComponent.CHECK_BOX
                            componetId = "MODIFY_RECEIVE_MESSAGE_SIZE_UI"
                        }
                        spanNode("o365-space-2")
                        spanNode("o365-thin-bold") {
                            label = "modify_receive_message_size"
                        }
                    }
                }
                node("form-group") {
                    node("o365-ml-40 o365-pl-5 o365-make-relative float-left-first-div") {
                        node {
                            componetId = "MODIFY_RECEIVE_MESSAGE_SIZE"
                            emberComponent = EmberComponent.RADIO_GROUP
                        }
                        node {
                            componetId = "MAX_RECEIVE_SIZE"
                            emberComponent = EmberComponent.SIZE
                        }
                    }
                }
            }
        }
        node("col-md-6") {
            node("form-horizontal align-left o365-ml-10") {
                node("form-group o365-mb-10") {
                    labelNode("control-label") {
                        node {
                            emberComponent = EmberComponent.CHECK_BOX
                            componetId = "MODIFY_MESSAGE_RESTRICTIONS"
                        }
                        spanNode("o365-space-2")
                        spanNode("o365-thin-bold") {
                            label = "modify_message_restrictions"
                        }
                    }
                }

                node("form-group o365-mb-5") {
                    labelNode("radio-inline  o365-ml-15") {
                        labelWrapper = "<span class=\"o365-space-2\"></span>%s<span class=\"o365-space-3\"></span>"
                        label = "accept_message_from"
                    }
                }
                node("form-group o365-mb-15  o365-pl-3 float-left-first-div o365-ml-40") {
                    node {
                        componetId = "ACCEPT_MESSAGES_FROM"
                        emberComponent = EmberComponent.RADIO_GROUP
                    }
                    node("o365-inline-block o365-valign-middle") {
                        node {
                            componetId = "ACCEPT_MESSAGES_FROM_USERS"
                            emberComponent = EmberComponent.REP_POPUP
                        }
                    }
                }

                node("form-group o365-mb-5") {
                    labelNode("radio-inline  o365-ml-15") {
                        labelWrapper = "<span class=\"o365-space-2\"></span>%s<span class=\"o365-space-3\"></span>"
                        label = "reject_message_from"
                    }
                }
                node("form-group o365-mb-15  o365-pl-3 float-left-first-div o365-ml-40") {
                    node {
                        componetId = "REJECT_MESSAGES_FROM"
                        emberComponent = EmberComponent.RADIO_GROUP
                    }
                    node("o365-inline-block o365-valign-middle") {
                        node {
                            componetId = "REJECT_MESSAGES_FROM_USERS"
                            emberComponent = EmberComponent.REP_POPUP
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}