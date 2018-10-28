package com.langhanz.connector;

import java.util.List;
/**
 * Interface to be used on StrManip.Request.handleRequest to handle String
 * protocol request messages
 *
 * @author gustavo
 */
public interface IStrRequestHandler {

    /**
     * Called to handle ADDLPC messages
     *
     * @param value Data of value field (Zigbee address)
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void addLPC(List<String> value, String addr1, List<Integer> addr2);

    /**
     * Called to handle REMLPC messages
     *
     * @param value Data of value field (Zigbee address)
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void removeLPC(List<String> value, String addr1, List<Integer> addr2);

    /**
     * Called to handle LIGHT messages
     *
     * @param value Data of value field (ON or OFF)
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void light(List<Boolean> value, String addr1, List<Integer> addr2);

    /**
     * Called to handle DIMMER messages
     *
     * @param value Data of value field (Percentage)
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void dimmer(List<Integer> value, String addr1, List<Integer> addr2);

    /**
     * Called to handle TEMP messages
     *
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void temperature(String addr1, List<Integer> addr2);

    /**
     * Called to handle LUMIN messages
     *
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void luminosity(String addr1, List<Integer> addr2);

    /**
     * Called to handle CURRENT messages
     *
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void current(String addr1, List<Integer> addr2);
}