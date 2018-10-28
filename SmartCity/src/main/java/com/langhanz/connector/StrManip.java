package com.langhanz.connector;

import java.util.List;
/**
 * String protocol message manipulation
 *
 * @author gustavo
 */
public final class StrManip {

    /**
     * String protocol Request
     */
    public static final class Request {

        /**
         * Creates an String protocol ADDLPC request
         *
         * @param zbAddr Zigbee Address to go on value field
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the request
         */
        public static StrMessage addLPC(List<String> zbAddr, String scId, List<Integer> lpcId) {
            return req(StrDef.Type.ADDLPC, zbAddr, scId, lpcId);
        }       

        /**
         * Creates an String protocol REMLPC request
         *
         * @param zbAddr Zigbee Address to go on value field
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the request
         */
        public static StrMessage removeLPC(List<String> zbAddr, String scId, List<Integer> lpcId) {
            return req(StrDef.Type.REMLPC, zbAddr, scId, lpcId);
        }        

        /**
         * Creates an String protocol LIGHT request
         *
         * @param beOn Boolean to go on value field - True to turn on, False to turn off
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the request
         */
        public static StrMessage light(List<Boolean> beOn, String scId, List<Integer> lpcId) {
            return req(StrDef.Type.LIGHT, beOn, scId, lpcId);
        }

        /**
         * Creates an String protocol DIMMER request
         *
         * @param percent Percentage to go on value field - 10 to 100
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the request
         */
        public static StrMessage dimmer(List<Integer> percent, String scId, List<Integer> lpcId) {
            return req(StrDef.Type.DIMMER, percent, scId, lpcId);
        }

        /**
         * Creates an String protocol TEMP request
         *
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the request
         */
        public static StrMessage temperature(String scId, List<Integer> lpcId) {
            return req(StrDef.Type.TEMP, null, scId, lpcId);
        }

        /**
         * Creates an String protocol LUMIN request
         *
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the request
         */
        public static StrMessage luminosity(String scId, List<Integer> lpcId) {
            return req(StrDef.Type.LUMIN, null, scId, lpcId);
        }

        /**
         * Creates an String protocol CURRENT request
         *
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the request
         */
        public static StrMessage current(String scId, List<Integer> lpcId) {
            return req(StrDef.Type.CURRENT, null, scId, lpcId);
        }

        /**
         * Request Handler
         * Receives a StrMessage representation of a String protocol message
         * and calls IStrRequestHandler operations to handle it
         *
         * @param strMsg StrMessage object representation of the message to handle
         * @param handler IStrRequestHandler implementation
         */
        public static void handleRequest(StrMessage strMsg, IStrRequestHandler handler) {
            switch(strMsg.getType()) {
                case StrDef.Type.ADDLPC:  handler.addLPC((List<String>)strMsg.getValue(), strMsg.getAddr1(), strMsg.getAddr2()); break;
                case StrDef.Type.REMLPC:  handler.removeLPC((List<String>)strMsg.getValue(), strMsg.getAddr1(), strMsg.getAddr2()); break;
                case StrDef.Type.LIGHT:   handler.light((List<Boolean>)strMsg.getValue(), strMsg.getAddr1(), strMsg.getAddr2()); break;
                case StrDef.Type.DIMMER:  handler.dimmer((List<Integer>)strMsg.getValue(), strMsg.getAddr1(), strMsg.getAddr2()); break;
                case StrDef.Type.TEMP:    handler.temperature(strMsg.getAddr1(), strMsg.getAddr2()); break;
                case StrDef.Type.LUMIN:   handler.luminosity(strMsg.getAddr1(), strMsg.getAddr2()); break;
                case StrDef.Type.CURRENT: handler.current(strMsg.getAddr1(), strMsg.getAddr2()); break;
            }
        }

        private static <T> StrMessage req(String type, List<T> value, String scId, List<Integer> lpcId) {
            return new StrMessage(StrDef.Category.REQ, type, value, scId, lpcId);
        }
        private Request() {}
    }
    
    /**
     *
     */
    public static final class Response {

        /**
         * Creates an String protocol ADDLPC response
         *
         * @param res ADDLPC response to go on value field
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the response
         */
        public static StrMessage addLPC(List<String> res, String scId, List<Integer> lpcId) {
            return res(StrDef.Type.ADDLPC, res, scId, lpcId);
        }       

        /**
         * Creates an String protocol REMLPC response
         *
         * @param res REMLPC response to go on value field
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the response
         */
        public static StrMessage removeLPC(List<String> res, String scId, List<Integer> lpcId) {
            return res(StrDef.Type.REMLPC, res, scId, lpcId);
        }        

        /**
         * Creates an String protocol LIGHT response
         *
         * @param res LIGHT response to go on value field
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the response
         */
        public static StrMessage light(List<String> res, String scId, List<Integer> lpcId) {
            return res(StrDef.Type.LIGHT, res, scId, lpcId);
        }

        /**
         * Creates an String protocol DIMMER response
         *
         * @param res DIMMER response to go on value field
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the response
         */
        public static StrMessage dimmer(List<String> res, String scId, List<Integer> lpcId) {
            return res(StrDef.Type.DIMMER, res, scId, lpcId);
        }

        /**
         * Creates an String protocol TEMP response
         *
         * @param res TEMP response to go on value field
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the response
         */
        public static StrMessage temperature(List<String> res, String scId, List<Integer> lpcId) {
            return res(StrDef.Type.TEMP, res, scId, lpcId);
        }

        /**
         * Creates an String protocol LUMIN response
         *
         * @param res LUMIN response to go on value field
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the response
         */
        public static StrMessage luminosity(List<String> res, String scId, List<Integer> lpcId) {
            return res(StrDef.Type.LUMIN, res, scId, lpcId);
        }

        /**
         * Creates an String protocol CURRENT response
         *
         * @param res CURRENT response to go on value field
         * @param scId SC ID to go on addr1 field
         * @param lpcId LPC ID to go on addr2 field
         * @return StrMessage object representation of the response
         */
        public static StrMessage current(List<String> res, String scId, List<Integer> lpcId) {
            return res(StrDef.Type.CURRENT, res, scId, lpcId);
        }

        /**
         * Response Handler
         * Receives a StrMessage representation of a String protocol message
         * and calls IStrResponseHandler operations to handle it
         *
         * @param strMsg StrMessage object representation of the message to handle
         * @param handler IStrResponseHandler implementation
         */
        public static void handleResponse(StrMessage strMsg, IStrResponseHandler handler) {
            switch(strMsg.getType()) {
                case StrDef.Type.ADDLPC:  handler.addLPC((List<String>)strMsg.getValue(), strMsg.getAddr1(), strMsg.getAddr2()); break;
                case StrDef.Type.REMLPC:  handler.removeLPC((List<String>)strMsg.getValue(), strMsg.getAddr1(), strMsg.getAddr2()); break;
                case StrDef.Type.LIGHT:   handler.light((List<String>)strMsg.getValue(), strMsg.getAddr1(), strMsg.getAddr2()); break;
                case StrDef.Type.DIMMER:  handler.dimmer((List<String>)strMsg.getValue(), strMsg.getAddr1(), strMsg.getAddr2()); break;
                case StrDef.Type.TEMP:    handler.temperature((List<String>)strMsg.getValue(), strMsg.getAddr1(), strMsg.getAddr2()); break;
                case StrDef.Type.LUMIN:   handler.luminosity((List<String>)strMsg.getValue(), strMsg.getAddr1(), strMsg.getAddr2()); break;
                case StrDef.Type.CURRENT: handler.current((List<String>)strMsg.getValue(), strMsg.getAddr1(), strMsg.getAddr2()); break;
            }
        }

        private static <T> StrMessage res(String type, List<T> value, String scId, List<Integer> lpcId) {
            return new StrMessage(StrDef.Category.RES, type, value, scId, lpcId);
        }
        private Response() {}
    }

}