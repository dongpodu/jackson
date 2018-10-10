package me.will.jackson.annotation.read;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;

/**
 * JacksonInject is used to indicate a property that will get its value from the injection and not from the JSON data.
 */
@Data
public class JacksonInjectTest {
    @JacksonInject
    public int id;
    public String name;

    public static void main(String[] args) throws IOException {
        String json = "{\"name\":\"My bean\"}";
        InjectableValues inject = new InjectableValues.Std()
                .addValue(int.class, 1);
        JacksonInjectTest bean = new ObjectMapper().reader(inject)
                .forType(JacksonInjectTest.class)
                .readValue(json);
        System.out.println(bean);
    }
}
