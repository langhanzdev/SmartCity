package net.iotll.cityos.cosvc.connector.strprotocol;

import java.util.List;
/**
 * Interface to be used on StrManip.Response.handleResponse to handle String
 * protocol response messages
 *
 * @author gustavo
 */
public interface IStrResponseHandler {

    /**
     * Called to handle ADDLPC messages
     *
     * @param value Data of value field (Response status)
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void addLPC(List<String> value, String addr1, List<Integer> addr2);

    /**
     * Called to handle REMLPC messages
     *
     * @param value Data of value field (Response status)
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void removeLPC(List<String> value, String addr1, List<Integer> addr2);

    /**
     * Called to handle LIGHT messages
     *
     * @param value Data of value field (Response status)
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void light(List<String> value, String addr1, List<Integer> addr2);

    /**
     * Called to handle DIMMER messages
     *
     * @param value Data of value field (Response status)
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void dimmer(List<String> value, String addr1, List<Integer> addr2);

    /**
     * Called to handle TEMP messages
     *
     * @param value Data of value field (Response status)
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void temperature(List<String> value, String addr1, List<Integer> addr2);

    /**
     * Called to handle LUMIN messages
     *
     * @param value Data of value field (Response status)
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void luminosity(List<String> value, String addr1, List<Integer> addr2);

    /**
     * Called to handle CURRENT messages
     *
     * @param value Data of value field (Response status)
     * @param addr1 Data of addr1 field
     * @param addr2 Data of addr2 field
     */
    public void current(List<String> value, String addr1, List<Integer> addr2);
}