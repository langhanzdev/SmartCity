package com.langhanz.connector;
/**
 * String protocol definitions
 *
 * @author gustavo
 */
public final class StrDef {
    private StrDef() {}

    /**
     *
     */
    public static final String DELIM = "|";

    /**
     *
     */
    public static final String SEP   = "#";

    /**
     *
     */
    public static final String NULL = "NULL";

    /**
     * Category field
     */
    public final class Category {

        /**
         *
         */
        public static final String REQ = "REQ";

        /**
         *
         */
        public static final String RES = "RES";

    }

    /**
     * Type field
     */
    public final class Type {

        /**
         *
         */
        public static final String ADDLPC  = "ADDLPC";

        /**
         *
         */
        public static final String REMLPC  = "REMLPC";

        /**
         *
         */
        public static final String LIGHT   = "LIGHT";

        /**
         *
         */
        public static final String DIMMER  = "DIMMER";

        /**
         *
         */
        public static final String TEMP    = "TEMP";

        /**
         *
         */
        public static final String LUMIN   = "LUMIN";

        /**
         *
         */
        public static final String CURRENT = "CURRENT"; 
    }

}