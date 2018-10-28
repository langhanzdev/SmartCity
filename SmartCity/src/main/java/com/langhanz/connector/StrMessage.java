package com.langhanz.connector;

import java.util.List;
import java.util.Iterator;
import java.util.function.Function;
import java.util.ArrayList;
/**
 * String protocol message
 *
 * @author gustavo
 */
public class StrMessage {
    private String category;
    private String type;
    private List<?> value;
    private String addr1;
    private List<Integer> addr2;

    /**
     * StrMessage constructor
     *
     * @param category String protocol category field
     * @param type String protocol type field
     * @param value String protocol value field
     * @param addr1 String protocol addr1 field
     * @param addr2 String protocol addr2 field
     */
    public StrMessage(String category, String type, 
      List<?> value, String addr1, List<Integer> addr2) 
    {
        this.category = category;
        this.type = type;
        this.value = value;
        this.addr1 = addr1;
        this.addr2 = addr2;
    }

    /**
     * StrMessage constructor
     * 
     * @param message String representation of StrMessage object
     */
    public StrMessage(String message) {
        String[] str = message.split(String.format("\\%s", StrDef.DELIM));
        if(str.length != 5) return;
        category = str[0];
        type = str[1];
        if(category.equals(StrDef.Category.RES) || type.equals(StrDef.Type.ADDLPC) ||
           type.equals(StrDef.Type.REMLPC) || type.equals(StrDef.Type.TEMP) ||
           type.equals(StrDef.Type.LUMIN) || type.equals(StrDef.Type.CURRENT))
        {
            value = stringToList(String.class, str[2]);
        } else if(type.equals(StrDef.Type.LIGHT)) {
            value = stringToList(Boolean.class, str[2]);
        } else if(type.equals(StrDef.Type.DIMMER)) {
            value = stringToList(Integer.class, str[2]);
        }
        addr1 = str[3];
        addr2 = stringToList(Integer.class, str[4]);
    }

    @Override
    public String toString() {
        String _value = "";
        String _addr2 = listToString(addr2);
        if(value == null) {
            _value = StrDef.NULL;
        } else if(category.equals(StrDef.Category.REQ) && type.equals(StrDef.Type.LIGHT)) {
           // _value = listToString((List<Boolean>) value, b -> b ? "ON" : "OFF");
        } else {
            _value = listToString(value);
        }
        return String.format(
          "%2$s%1$s%3$s%1$s%4$s%1$s%5$s%1$s%6$s", StrDef.DELIM, category, type, _value, addr1, _addr2);
    }

    /**
     *
     * @return String protocol category field
     */
    public String getCategory() { return category; }

    /**
     *
     * @return String protocol type field
     */
    public String getType() { return type; }

    /**
     *
     * @return String protocol value field
     */
    public List<?> getValue() { return value; }

    /**
     *
     * @return String protocol addr1 field
     */
    public String getAddr1() { return addr1; }

    /**
     *
     * @return String protocol addr2 field
     */
    public List<Integer> getAddr2() { return addr2; }

    private static <T> String listToString(List<T> list) {
        String str = "";
        for(Iterator<T> itr = list.iterator(); itr.hasNext();) {
                str += itr.next();
                if(itr.hasNext()) str += StrDef.SEP;
        }
        return str;
    }
    private static <T> String listToString(List<T> list, Function<T, String> fun) {
        String str = "";
        for(Iterator<T> itr = list.iterator(); itr.hasNext();) {
                str += fun.apply(itr.next());
                if(itr.hasNext()) str += StrDef.SEP;
        }
        return str;
    }
    private static <T> List<T> stringToList(Class<T> typeClass, String str) {
        String[] aux = str.split(String.format("\\%s", StrDef.SEP));
        if(aux.length < 1) return null;
        List<T> list = new ArrayList<>(aux.length);
        if(typeClass == String.class) {
            for(int i = 0; i < aux.length; i++) 
                list.add(i, (T)aux[i]);
        } else if(typeClass == Boolean.class) {
            for(int i = 0; i < aux.length; i++) 
                list.add(i, (T)(Object)aux[i].equals("ON"));
        } else if(typeClass == Integer.class) {
            for(int i = 0; i < aux.length; i++)
                list.add(i, (T)(Object)Integer.parseInt(aux[i]));
        }
        return list;
    }
}