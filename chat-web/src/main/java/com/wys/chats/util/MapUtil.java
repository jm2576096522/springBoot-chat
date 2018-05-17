package com.wys.chats.util;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import net.sf.json.xml.XMLSerializer;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.xml.sax.SAXException;


/**
 * Map工具类
 *
 * Created by HuangKai on 2017/8/29.
 */
public class MapUtil {


    /**
     * 将指定map的键值和value值摄入新map，并返回
     */
    public static Map<String, Object> getSpecialMap(Map<String, Object> map, String... args) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (map == null) {
            return null;
        }
        for (String s : args) {
            if (map.containsKey(s)) {
                resultMap.put(s, map.get(s));
            }
        }
        return resultMap;
    }

    /**
     * 将指定Object的值填充到map中
     */
    public static Map<String, Object> setMapValueOfObject(Object obj, Map<String, Object> data) throws Exception {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), cls);
            Method getMethod = pd.getReadMethod();//获得get方法  
            Object objValue = getMethod.invoke(obj);
            if (objValue != null) {
                data.put(name, objValue);
            }
        }
        return data;
    }

    /**
     * 将指定map的值填充到Object中，并返回
     */
    public static Object setObjectFileValue(Object obj, Map<String, Object> data) throws Exception {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            Class<?> clsType = field.getType();
            String name = field.getName();
            String strSet = "set" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
            Method methodSet = cls.getDeclaredMethod(strSet, clsType);
            if (data.containsKey(name)) {
                Object o = data.get(name);
                if (o == null) {
                    continue;
                }
                Object objValue = typeConversion(clsType, o);
                methodSet.invoke(obj, objValue);
            }
        }
        return obj;
    }

    public static Object typeConversion(Class<?> cls, Object o) {
        String str = o.toString();
        Object obj = null;
        String nameType = cls.getSimpleName();
        if ("Integer".equals(nameType) || "int".equals(nameType)) {
            obj = Integer.valueOf(str);
        } else if ("String".equals(nameType)) {
            obj = str;
        } else if ("Float".equals(nameType) || "float".equals(nameType)) {
            obj = Float.valueOf(str);
        } else if ("Double".equals(nameType) || "double".equals(nameType)) {
            obj = Double.valueOf(str);
        } else if ("Boolean".equals(nameType) || "boolean".equals(nameType)) {
            obj = Boolean.valueOf(str);
        } else if ("Long".equals(nameType) || "long".equals(nameType)) {
            obj = Long.valueOf(str);
        } else if ("Short".equals(nameType) || "short".equals(nameType)) {
            obj = Short.valueOf(str);
        } else if ("Character".equals(nameType) || "char".equals(nameType)) {
            obj = str.charAt(1);
        } else if ("List".equals(nameType)) {
            obj = o;
        }
        return obj;
    }

    /**
     * map是否模糊匹配某值
     */
    public static Boolean HasLikeValue(Map<String, Object> map, String value) {
        for (String key : map.keySet()) {
            if (map.get(key) == null) {
                continue;
            }
            if (map.get(key).toString().contains(value)) {
                return true;
            }
        }

        return false;
    }


}
