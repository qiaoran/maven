package org.util.common.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Copyright (c) 2015-2016 youzhai.com
 * </p>
 *
 * @Title: EnumJsonSerializer.java
 * </p>
 * @Package: com.xnac.yz.jackson
 * </p>
 * @author: gavin
 * </p>
 * @date 2015/9/25 16:49
 * </p>
 * @Description: 枚举序列化
        */
public class EnumJsonSerializer extends JsonSerializer<Enum> {

    public void serialize(Enum value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.ordinal());
        gen.writeStringField("name", value.name());
        for(Field f : value.getClass().getDeclaredFields()){
            for(Method m : value.getClass().getDeclaredMethods()){
                if(StringUtils.indexOfIgnoreCase(m.getName(), f.getName())>0){
                    try {
                        gen.writeObjectField(f.getName(), m.invoke(value, null));
                    } catch (Exception e) {}
                }
            }
        }
        gen.writeEndObject();
    }
}
