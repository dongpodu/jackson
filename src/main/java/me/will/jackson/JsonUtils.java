package me.will.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JsonUtils {

    public static String serialize(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        String result = null;
        try {
            result = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <T> T deserialize(String json,Class<T> tClass){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        T model = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            model = objectMapper.readValue(json,tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }

}
