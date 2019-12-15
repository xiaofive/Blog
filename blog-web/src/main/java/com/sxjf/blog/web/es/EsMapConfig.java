package com.sxjf.blog.web.es;

import com.sxjf.blog.web.es.Entity.sales.EsSalesOrderHeader;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wangyang
 * @description
 * @Date 2019/12/13
 */
public class EsMapConfig {

    //Elasticsearch:7.1.1 mapping all type
    static String MAPPING_FIELD_TYPE = "type";

    static String TEXT = "text"; //String,默认分词
    static String KEYWORD = "keyword";

    static String INTEGER = "integer";
    static String LONG = "long";
    static String NUMBER = "number";

    static String DATE = "date";

    static String ARRAY = "array";
    static String OBJECT = "object"; //嵌套类型，不支持数组。
    static String NESTEN = "nested"; //一种特殊的object类型，存储object数组，可检索内部子项。

    static String IP = "ip";
    //Elasticsearch7.1.1 mapping settings
    static String ANALYZER = "analyzer"; //分词器设置
    static String BOOST = "boost"; //字段字段权重，默认1，_all根据此字段来权重
    static String DYNAMIC = "dynamic";
    static String INDEX = "index"; //是否构建倒排索引，否则无法作为搜索条件
    static String PROPERTIES = "properties";


    public static Map<String, Object> buildEsMapping(List<Class> classList) {
        Map<String, Object> mapping = new HashMap<>();
        mapping.put(PROPERTIES, getSimpleObject(classList));
        mapping.put(DYNAMIC, "strict");   //不支持未知字段
        return mapping;
    }

    private static Map<String, Object> getSimpleObject(List<Class> clsList) {
        Map<String, Object> objectMap = new HashMap<>();
        for (Class cls : clsList) {
            objectMap.put(cls.getSimpleName(), getSimpleField(cls, new HashMap<>()));
        }
        return objectMap;
    }

    private static Map<String, Object> getSimpleField(Class<?> cls, Map<String, Object> fieldMap) {
        Field[] fields = cls.getDeclaredFields();
        Map<String, Object> fieldType = new HashMap<>();
        fieldType.put(MAPPING_FIELD_TYPE, KEYWORD);
        for (Field field : fields) {
            //todo
            fieldMap.put(field.getName(), fieldType);
        }
        if (cls.getSuperclass() != null) {
            getSimpleField(cls.getSuperclass(), fieldMap);
        }
        Map<String, Object> objectValueMap = new HashMap<>();
        objectValueMap.put(PROPERTIES, fieldMap);
        objectValueMap.put(MAPPING_FIELD_TYPE, OBJECT);
        return objectValueMap;
    }


}
