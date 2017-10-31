package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    Node("LITIGATION_HOLD_CHANGES") {
        styleClass = "gsection"
        node("gspan_2_of_4 gcolumn line line-right o365-mb-15") {
            node("o365-ml-40 o365-mb-15") {
                node("checkbox-inline") {
                    htmlTag = "label"
                    node {
                        componetId = "LITIGATION_HOLD_SETTINGS_UI"
                        emberComponent = EmberComponent.CHECK_BOX
                    }
                    node("o365-space-1") {
                        htmlTag = "span"
                    }
                    node {
                        htmlTag = "span"
                        label = "litigation_hold"
                    }
                }
            }
            node("o365-ml-60 o365-pr-20") {
                node("form-horizontal align-right o365-make-relative") {
                    node("form-group") {
                        node {
                            styleClass = "col-md-4 control-label o365-pt-0"
                            label = "litigation_hold"
                            htmlTag = "label"
                        }
                        node {
                            styleClass = "col-md-7 o365-valign-top"
                            node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = "LITIGATION_HOLD_ENABLED"
                            }
                        }
                    }
                    node("form-group o365-make-relative") {
                        node {
                            styleClass = "col-md-4 control-label o365-pt-0"
                            label = "put_on_hold_by"
                            htmlTag = "label"
                        }
                        node {
                            styleClass = "col-md-7 o365-valign-top"
                            node {
                                emberComponent = EmberComponent.REP_POPUP
                                componetId = "LITIGATION_HOLD_OWNER"
                            }
                        }
                    }
                    node {
                        styleClass = "form-group o365-make-relative o365-mb-5"
                        node {
                            styleClass = "col-md-4 control-label o365-pt-0"
                            label = "hold_duration"
                            htmlTag = "label"
                        }
                        node {
                            styleClass = "col-md-7 o365-valign-top"
                            node {
                                emberComponent = EmberComponent.TEXT
                                componetId = "LITIGATION_HOLD_DURATION"
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
                            node {
                                emberComponent = EmberComponent.CHECK_BOX
                                componetId = "RETENTION_COMMENT_UI"
                            }
                            node("o365-space-2") {
                                htmlTag = "span"
                            }
                            node{
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
                        node {
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
                            node {
                                emberComponent = EmberComponent.CHECK_BOX
                                componetId = "RETENTION_URL_UI"
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
                        node {
                            emberComponent = EmberComponent.TEXT
                            componetId = "RETENTION_COMMENT"
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}