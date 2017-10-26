package com.omp.task.builders

import com.omp.task.layout.EmberComponent
import com.omp.task.layout.Node

/**
 * Created by gokul-4192.
 */

fun main(args: Array<String>) {
    Node("LITIGATION_HOLD_CHANGES") {
        styleClass = "gsection"
        node {
            styleClass = "gspan_2_of_4 gcolumn line line-right o365-mb-15"
            node {
                styleClass = "o365-ml-40 o365-mb-15"
                label = "litigation_hold"
            }
            node {
                styleClass = "o365-ml-60 o365-pr-20"
                node {
                    styleClass = "form-horizontal align-right o365-make-relative"
                    node {
                        styleClass = "form-group"
                        node {
                            styleClass = "col-md-4 control-label o365-pt-0"
                            label = "litigation_hold"
                            htmlTag = "label"
                        }
                        node {
                            styleClass = "col-md-7 o365-valign-top"
                            node {
                                emberComponent = EmberComponent.RADIO_GROUP
                                componetId = 1
                            }
                        }
                    }
                    node {
                        styleClass = "form-group o365-make-relative"
                        node {
                            styleClass = "col-md-4 control-label o365-pt-0"
                            label = "put_on_hold_by"
                            htmlTag = "label"
                        }

                        node {
                            styleClass = "col-md-7 o365-valign-top"
                            node {
                                styleClass = "input-group static"
                                node {
                                    emberComponent = EmberComponent.REP_POPUP
                                    componetId = 35
                                }
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
                                componetId = 1
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
                        label = "notes"
                    }
                    node {
                        styleClass = "form-column o365-valign-top"
                        node {
                            emberComponent = EmberComponent.TEXT
                            componetId = 1

                        }
                    }
                }
                node {
                    styleClass = "form-row"
                    node {
                        styleClass = "form-column control-label o365-pt-5"
                        label = "url"
                    }
                    node {
                        styleClass = "form-column o365-valign-top"
                        node {
                            emberComponent = EmberComponent.TEXT
                            componetId = 1
                        }
                    }
                }
            }
        }
    }.copyToClipBoard()
}