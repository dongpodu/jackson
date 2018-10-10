package me.will.jackson.annotation.write;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import me.will.jackson.JsonUtils;

/**
 * 只序列化被JsonValue标注的字段或方法
 */
@Data
public class JsonValueTest {
    @JsonValue
    public Integer id;
    public String name;

    public static void main(String[] args) {
        JsonValueTest test = new JsonValueTest();
        test.setId(11);
        test.setName("will");
        String result = JsonUtils.serialize(test);
        System.out.println(result);
    }
}
