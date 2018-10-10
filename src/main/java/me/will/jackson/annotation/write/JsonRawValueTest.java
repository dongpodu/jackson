package me.will.jackson.annotation.write;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;
import me.will.jackson.JsonUtils;

@Data
public class JsonRawValueTest {
    public String name;
    @JsonRawValue
    public String json;

    public static void main(String[] args) {
        JsonRawValueTest test = new JsonRawValueTest();
        test.setJson("hello");
        test.setName("will");
        String result = JsonUtils.serialize(test);
        System.out.println(result);
    }
}
