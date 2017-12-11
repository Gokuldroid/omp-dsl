package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    val root = Node("MAILBOX_AUTO_REPLY_CONFIGURATION") {
        styleClass = "row o365-mb-5"
        node {
            styleClass = "col-md-12"
            node {
                styleClass = "center-block static-container-sm"
                node {
                    styleClass = "form-horizontal align-left"
                    node {
                        styleClass = "form-group"
                        node {
                            styleClass = "col-md-12"
                            node {
                                componetId = "AUTO_REPLY_STATE"
                                emberComponent = EmberComponent.RADIO_GROUP
                                //inputType = "RADIO_GROUP_HORIZONTAL_SPACE_5"
                            }
                        }
                    }
                    node {
                        styleClass = "form-group sendAutoReply o365-make-relative"
                        node {
                            styleClass = "col-md-12"
                            node {
                                emberComponent = EmberComponent.TAB_LAYOUT
                                node {
                                    label = "o365.input_fields.inside_org"
                                    styleClass = "o365-p-5"
                                    node {
                                        styleClass = "o365-mh-100"
                                        node {
                                            componetId =  "AUTO_REPLY_INSIDE_MSG"
                                            emberComponent = EmberComponent.RT_EDITOR
                                        }
                                    }
                                }
                                node {
                                    styleClass = "o365-p-5"
                                    label = "o365.input_fields.outside_org"
                                    node {
                                        styleClass = "o365-mb-5"
                                        labelNode ("checkbox-inline"){
                                            node {
                                                emberComponent = EmberComponent.CHECKBOX
                                                componetId = "ENABLE_AUTO_REPLY_OUTSIDE_ORG"
                                            }
                                            spanNode ("o365-space-2"){  }
                                            spanNode {
                                                label = "auto_rep_outside_org"
                                            }
                                        }
                                    }
                                    node {
                                        styleClass = "o365-make-relative"
                                        node {
                                            styleClass = "o365-mh-100"
                                            node {
                                                componetId =  "AUTO_REPLY_OUTSIDE_MSG"
                                                emberComponent = EmberComponent.RT_EDITOR
                                            }
                                        }
                                        node {
                                            styleClass = "o365-mt-5"
                                            labelNode ("checkbox-inline"){
                                                node {
                                                    emberComponent = EmberComponent.CHECKBOX
                                                    componetId = "EXCLUDE_SENDERS_NOT_IN_CONTACT"
                                                }
                                                spanNode ("o365-space-2"){  }
                                                spanNode {
                                                    label = "exculde_senders_not_in_contact"
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    node("form-group sendAutoReply o365-make-relative") {
                        node("form-group o365-mb-15 o365-make-relative o365-mt-20") {
                            labelNode("checkbox-inline o365-ml-15") {
                                node {
                                    componetId = "SCHEDULE_AUTO_REPLY"
                                    emberComponent = EmberComponent.CHECK_BOX
                                }
                                spanNode("o365-space-2")
                                spanNode {
                                    labelWrapper = "%s<span class=\"o365-space-1\"></span>"
                                    label = "send_reply_period"
                                }
                            }
                            node("o365-inline-block o365-valign-middle o365-make-relative") {
                                node {
                                    componetId = "AUTO_REPLY_DURATION"
                                    emberComponent = EmberComponent.DATE_PICKER
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    root.copyToClipBoard()
}