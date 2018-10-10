package me.will.jackson.annotation.read;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;

/**
 * 解决java属性名和json属性名不一致问题
 */
@Data
public class JsonCreatorTest {
    public int id;
    public String name;

    @JsonCreator
    public JsonCreatorTest(
            @JsonProperty("id") int id,
            @JsonProperty("theName") String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) throws IOException {
        String json = "{\"id\":1,\"theName\":\"My bean\"}";
        JsonCreatorTest bean = new ObjectMapper()
                .readerFor(JsonCreatorTest.class)
                .readValue(json);
        System.out.println(bean);
    }
}
