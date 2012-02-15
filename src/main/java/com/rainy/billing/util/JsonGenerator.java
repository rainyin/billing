package com.rainy.billing.util;

import flexjson.JSONSerializer;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Project:  billing <br>
 * Company: com.rainy <br>
 * Copyright: 2011 www.rainy.cn Inc. All rights reserved.<br>
 *
 * @2011-10-19
 * @author rainy
 * @version 1.0
 */
public final class JsonGenerator {

    private JsonGenerator() {
    }

    /**
     * serializer the object into json string
     * @param object the target serialize object
     * @return json string
     */
    public static String serializerObject(Object object,String ... excludeProperties) {
        JSONSerializer serializer = new JSONSerializer();
        return serializer.exclude("*.class").exclude(excludeProperties).serialize(object);
    }

    /**
     * serializer the object into json string, at the sametime include some specified property.
     * @param object object the target serialize object
     * @param propertyName which you specified include into the json string.
     * @return
     */
    public static String serializerObjectInclude(Object object, String... propertyName) {
        JSONSerializer serializer = new JSONSerializer();
        return serializer.exclude("*.class").include(propertyName).exclude("*").serialize(object);
    }
    
    /**
     * deep serializer the object into json string.
     * @param object object the target serialize object
     * @param propertyName which you specified not include into the json string.
     * @return
     */
    public static String deepSerializerObject(Object object, String... propertyName) {
       JSONSerializer serializer = new JSONSerializer();
       return serializer.exclude("*.class").exclude(propertyName).deepSerialize(object);
    }
    /**
     * deep serializer the object into json string.
     * @param object object the target serialize object
     * @param propertyName which you specified include into the json string.
     * @return
     */
    public static String deepSerializerObjectInclude(Object object, String... propertyName) {
    	JSONSerializer serializer = new JSONSerializer();
    	return serializer.exclude("*.class").include(propertyName).deepSerialize(object);
    }

}
