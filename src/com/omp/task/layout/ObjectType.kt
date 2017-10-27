/**
 * $Id: ObjectType.java,v 1.4 2017/09/04 11:30:51 prabaharan.s Exp $
 */

package com.omp.task.layout

import java.util.HashSet

enum class ObjectType {
    //0
    STRING,
    //1
    LONG,
    //2
    INT,
    //3
    BOOLEAN,
    //4
    JSON,
    //5
    JSON_ARRAY,
    //6
    EMAIL,
    //7
    ONE_FROM_MULTIPLE_VALS,
    //8
    DATE_RANGE,
    //9
    ENABLED_OR_DISABLED,
    NO_OF_DAYS,
    O365_LICENSES,
    UPN,
    O365_DOMAINS,
    SIZE_IN_KB,
    MULTI_SELECT,
    TRUE_OR_FALSE,
    YES_OR_NO,
    PLAIN_TEXT,
    SINGLE_SELECT,
    SIZE_IN_MB,
    PASSWORD;


    companion object {

        @Volatile private var enums: HashSet<String>? = null

        fun isValidEnum(enumString: String): Boolean {
            if (enums == null) {
                synchronized(ObjectType::class.java) {
                    if (enums == null) {
                        enums = HashSet<String>()
                        val vals = ObjectType.values()
                        for (`val` in vals) {
                            enums!!.add(`val`.name)
                        }
                    }
                }
            }
            return enums!!.contains(enumString)
        }
    }
}
