package me.will.jackson.annotation.write;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;

/**
 * The @JsonRootName annotation is used – if wrapping is enabled – to specify the name of the root wrapper to be used.
 */
@Data
@JsonRootName(value = "test")
public class JsonRootNameTest {
    public int id;
    public String name;

    public static void main(String[] args) throws JsonProcessingException {
        JsonRootNameTest test = new JsonRootNameTest();
        test.setName("will");
        test.setId(11);
        ObjectMapper mapper = new ObjectMapper();
        //enable wrapping
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE,true);
        String result=mapper.writeValueAsString(test);
        System.out.println(result);
    }
}
