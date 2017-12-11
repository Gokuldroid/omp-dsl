package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */
fun main(args: Array<String>) {
    Node("RESET_PASSWORD") {
        styleClass = "row o365-mb-5"
        node("col-md-6") {
            node("line line-right o365-pr-20") {
                node("form-horizontal align-left o365-ml-40 o365-pb-10") {
                    node("form-group") {
                        labelNode("col-md-12 control-label o365-thin-bold") {
                            node {
                                componetId = "RESET_PASSWORD_UI"
                                emberComponent = EmberComponent.CHECK_BOX
                            }
                            spanNode("o365-space-2")
                            spanNode("o365-thin-bold") {
                                label = "reset_password"
                            }
                        }
                    }
                    node("form-group default_mailbox o365-make-relative") {
                        tableNode {
                            tbodyNode {
                                trNode {
                                    tdNode("width-45") {}
                                    tdNode {
                                        node {
                                            componetId = "RANDOM_PASSWORD"
                                            emberComponent = EmberComponent.RADIO_GROUP
                                        }
                                    }
                                }
                            }
                        }
                    }
                    node("form-group o365-make-relative o365-mb-0") {
                        tableNode {
                            tbodyNode {
                                trNode {
                                    tdNode("width-45") {}
                                    tdNode {
                                        node {
                                            componetId = "CUSTOM_PASSWORD"
                                            emberComponent = EmberComponent.RADIO_GROUP
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        node("col-md-6") {
            node("form-horizontal align-left") {
                node("form-group") {
                    labelNode("col-md-12 control-label o365-pt-0") {
                        spanNode("o365-space-2") { }
                        spanNode("o365-thin-bold") {
                            label = "password_options"
                        }
                    }
                }
                node("form-group o365-make-relative") {
                    tableNode("o365-ml-25") {
                        tbodyNode {
                            trNode {
                                tdNode("width-260") {
                                    label = "change_password_on_nxt_logon"
                                }
                                tdNode("width-15") { }
                                tdNode {
                                    node {
                                        width = "100px"
                                        componetId = "CHANGE_PASSWORD_ON_NEXT_LOGON"
                                        emberComponent = EmberComponent.DR_SELECT
                                    }
                                }
                            }
                        }
                    }
                }
                node("form-group o365-make-relative") {
                    tableNode("o365-ml-25") {
                        tbodyNode {
                            trNode {
                                tdNode("width-260 o365-align-right") {
                                    label = "password_never_expires"
                                }
                                tdNode("width-15") { }
                                tdNode {
                                    node {
                                        width = "100px"
                                        componetId = "PASSWORD_NEVER_EXPIRES"
                                        emberComponent = EmberComponent.DR_SELECT
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}